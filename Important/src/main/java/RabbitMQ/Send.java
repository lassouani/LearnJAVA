package RabbitMQ;
import com.rabbitmq.client.AMQP.BasicProperties;

import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

    private final static String QUEUE_NAME = Constantes.QUEUE_NAME;
    private final static String EXCHANGE_NAME = Constantes.EXCHANGE_NAME;
    private final static String ROUTING_KEY = Constantes.ROUTING_KEY;
    
    private final static String REJECT_ROUTING_KEY =Constantes.REJECT_ROUTING_KEY;

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        
        Connection connection = null;
        Channel channel = null;
        
        System.out.println("Init...");
        
       try {
    	  connection = factory.newConnection();
          channel = connection.createChannel();
          
          Map<String, Object> args = new HashMap<String, Object>();
          args.put("x-queue-mode", "lazy");
          args.put("x-dead-letter-exchange", EXCHANGE_NAME);
          args.put("x-dead-letter-routing-key", REJECT_ROUTING_KEY);
           
          if (QUEUE_NAME.endsWith("2")) {
        	// Queue2 with args
			  channel.queueDeclare(QUEUE_NAME, true, false, false, args);
		  }else {
			// Queue1, 3 without args
        	  channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		  }


           //====================================================
//           channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
//           String queueName = channel.queueDeclare().getQueue();
//           channel.queueBind(queueName, EXCHANGE_NAME, ROUTING_KEY);
           //=============================================================
           String message = "Hello";
           String message1 = "Hello World";
           String message2 = "Hello World!--";
           String tab[] = {message, message1, message2, "mesage4", "message5"};
           int targetID[] = {1436, 1234, 654, 9808, 4567};
           int targetKind[] = {2, 4, 2, 3, 1};
          
           // m.getMessageProperties().getHeaders().put("foo", "bar");
           
           Map<String,Object> headers = new HashMap<String,Object>();
           
           BasicProperties props = null; /*new BasicProperties(
           		null,null,headers, null,null,null,
                   null,null,null,null,null,null,null,null);*/
          
          for (int i = 0; i < 2; i++) {
        	  System.out.println("Tour :"+i);
        	  for (int j = 0; j < targetKind.length; j++) {
        		  headers.put("targetID", targetID[j]);
                  headers.put("targetKind", targetKind[j]);
                  props = new BasicProperties( null,null,headers, null,null,null,null,null,null,null,null,null,null,null);
                  
                  channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, props, tab[j].getBytes("UTF-8"));
			}
        	  
        	  
        	 
//        	   for (String str : tab) {
//               	channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, props, str.getBytes("UTF-8"));
//               	//System.out.println(" [x] Sent '" + str + "'");
//       		}
          }
        
        channel.close();
        connection.close();
           
       } catch (Exception e) {
    	   
    	   channel.close();
           connection.close();
    	   e.printStackTrace();
    	   
       }
       
       
    }
}