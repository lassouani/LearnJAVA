package encodeB64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.codec.binary.Base64;

import encodeB64.BadBase64EncodingException;

public class encodeToB64 {

	public static void main(String[] args) {
		
		try {
			String base64EncodedStringOfPdfReport = ConvertToBase64String(new File("C:/Users/slassoua/Desktop/doc.rtf"));
			System.out.println(base64EncodedStringOfPdfReport);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String ConvertToBase64String(File inputFile) throws IOException
    {
        if (!inputFile.exists())
            throw new FileNotFoundException(String.format("The specified input file '%s' does not exist",inputFile.getAbsoluteFile()));

        return new String(Base64.encodeBase64(Files.readAllBytes(inputFile.toPath())));
    }

    public static byte[] ConvertFromBase64String(String base64EncodedString) throws BadBase64EncodingException
    {
        if (base64EncodedString == null || base64EncodedString.length() == 0)
            throw new IllegalArgumentException("You must supply byte string for Base64 decoding operation");
        
        if (base64EncodedString.length() % 4 != 0)
            throw new BadBase64EncodingException("The BASE-64 encoded data is not in correct form (divide by 4 resulted in a remainder)");

        try {
            return Base64.decodeBase64(base64EncodedString);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to decode Base-64 string supplied for operation. Please check your inputs");
        }
    }

}
