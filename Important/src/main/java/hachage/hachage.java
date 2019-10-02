package hachage;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class hachage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = "C:\\Users\\slassoua\\Desktop\\unitTest\\nbLineResult.csv";
		
		//System.out.println(getHashOfFile(filePath,"MD5"));
		
		
		
		
		
		
		String  path = "/Desktop/unitTest/hashFiles.csv";

		System.out.println("ici "+System.getProperty("user.home").concat(path).replaceAll("\\\\","/").replaceFirst(new File(path).getName(), "tmp/"));

		System.out.println( new File("C:/User/temp/src/ReadMe.txt").getName());
		


	}


	
	
	
	/**
	 * 
	 * @param filePath
	 * @return getMd5OfFile
	 */
	public static String getHashOfFile(String filePath) {
		return getHashOfFile(filePath, "MD5");
	}
	
	/**
	 * 
	 * @param filePath
	 * @param algorithm
	 * @return
	 * 
	 * 		Ex : getMd5OfFile(filePath,"MD5")
	 * 				algorithm = "MD2", "MD5", "SHA-1", "SHA-224", "SHA-256", SHA-384, "SHA-512"
	 */
	public static String getHashOfFile(String filePath, String algorithm)
	{
	    String returnVal = "";
	    try 
	    {
	        InputStream   input   = new FileInputStream(filePath); 
	        byte[]        buffer  = new byte[1024];
	        MessageDigest algorithmHash = MessageDigest.getInstance(algorithm);
	        int           numRead = 0;
	        while (numRead != -1)
	        {
	            numRead = input.read(buffer);
	            if (numRead > 0)
	            {
	            	algorithmHash.update(buffer, 0, numRead);
	            }
	        }
	        input.close();

	        byte [] md5Bytes = algorithmHash.digest();
	        for (int i=0; i < md5Bytes.length; i++)
	        {
	            returnVal += Integer.toString( ( md5Bytes[i] & 0xff ) + 0x100, 16).substring( 1 );
	        }
	    } 
	    catch(Throwable t) {
	    	t.printStackTrace();
	    }
	    
	    return returnVal.toUpperCase();
	}
	
	
	
}
