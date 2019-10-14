package structure;

import java.util.HashSet;
import java.util.Set;

public class SetUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Set<Integer> set = new HashSet<Integer>(); 
//		
//		set.add(3);
//		set.add(5);
		
//		for (Integer i : set) {
//			System.out.println("la valeur : "+i);
//		}
		
		
		
		Set<MessageRMQ> set = new HashSet<MessageRMQ>(); 
		
		MessageRMQ mq = new MessageRMQ("A", "B");
		mq.setHost("A");
		mq.setTargetID("B");
		
		set.add(mq);
		
		MessageRMQ mq1 = new MessageRMQ("A", "B");
		set.add(mq1);
		
		MessageRMQ mq2 = new MessageRMQ("B", "C");
		set.add(mq2);
		
		
		System.out.println("size :"+set.size());
		
		for (MessageRMQ m : set) {
			System.out.println("host : "+m.getHost());
		}

		
		

	}
	
	
	
}

