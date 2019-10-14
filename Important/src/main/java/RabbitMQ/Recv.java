package RabbitMQ;

import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Recv {

	private final static String QUEUE_NAME = Constantes.QUEUE_NAME;
    private final static String EXCHANGE_NAME = Constantes.EXCHANGE_NAME;
    private final static String ROUTING_KEY = Constantes.ROUTING_KEY;
    
    private final static String REJECT_QUEUE_NAME ="reject";
    private final static String REJECT_ROUTING_KEY ="reject";

    public static void main(String[] argv) throws Exception {
    	ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, ROUTING_KEY);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        
        


        int nbrMsg = channel.queueDeclarePassive(QUEUE_NAME).getMessageCount();
        System.out.println(channel.messageCount(QUEUE_NAME));
        
        
        for (int i = 0; i <nbrMsg ; i++) {
        	GetResponse response = channel.basicGet(QUEUE_NAME, false);
        	
        	String message = new String(response.getBody(), "UTF-8");
        	
        	if (message.endsWith("--")) {
				channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
				System.out.println(message);
			}else {
				
				BasicProperties props = response.getProps();
				int nbrRetry = (props.getHeaders().get("nbrRetry") == null ? 0 : ((int)props.getHeaders().get("nbrRetry")))+1;
				
				Map<String,Object> headers = props.getHeaders();
				
				if (headers.isEmpty()) {
					headers = new HashMap<String,Object>();
				}
					
				headers.put("nbrRetry", nbrRetry);
				
		        props = new BasicProperties( null,null,headers, null,null,null,
		                   null,null,null,null,null,null,null,null);
				
				if (nbrRetry>=3) {
					// REJECT
					
					channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
					channel.basicPublish(EXCHANGE_NAME, REJECT_ROUTING_KEY, props, message.getBytes("UTF-8"));
					System.out.println("message supprimé");
				}else {
					//RETRY
				channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
				channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, props, message.getBytes("UTF-8"));
				
				
				}
			}
        	
        	 
		}
        
        channel.close();
        connection.close();


        
        

//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
////        	String host =  new String((byte[]) delivery.getProperties().getHeaders().get("host"), "UTF-8" );
////        	System.out.println(" [x] host '" + host + "'");
//        	//System.out.println(host);
//        	
//        		int nbrRetry =delivery.getProperties().getHeaders().get("retry") != null ? (int)delivery.getProperties().getHeaders().get("retry") : 0;
//                System.out.println(nbrRetry);
//            
//        	//delivery.getProperties().getHeaders().put("retry", nbrRetry++);
//        	System.out.println(delivery.getProperties().getHeaders().get("retry"));
//            String message = new String(delivery.getBody(), "UTF-8");
//            System.out.println(" [x] Received '" + message + "'");
            
//            delivery.getProperties().getHeaders().put("retry", nbrRetry++);

            //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), true);
        //};
        //channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
        
        
//       GetResponse response = channel.basicGet(QUEUE_NAME, true);
//       
//       System.out.println(new String(response.getBody(), "UTF-8"));
    }
}
