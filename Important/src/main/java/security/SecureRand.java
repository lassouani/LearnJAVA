package security;

import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;

public class SecureRand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(newSession());

	}

	
	
	protected static String newSession() {
		
		SecureRandom rand = new SecureRandom();
		byte bytes[] = new byte[20];    

		rand.nextBytes(bytes);  

		String cookie = new String(Hex.encodeHex(bytes));   
		return cookie; 

		
		
	}
}
