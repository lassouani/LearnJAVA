package validateXML;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class parseXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Document doc = null;
		
		try {
			String xmlString = null;
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			
			factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			//factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			
			factory.setValidating(true);
			factory.setIgnoringElementContentWhitespace(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			ErrorHandler handler = new ErrorHandler() {
				
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					// TODO Auto-generated method stub
					System.out.println("warning "+exception.toString());
					
				}
				
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					// TODO Auto-generated method stub
					System.out.println("fatalerror "+exception.toString());
				}
				
				@Override
				public void error(SAXParseException exception) throws SAXException {
					// TODO Auto-generated method stub
					System.out.println("errror "+exception.toString());
				}
			};
			builder.setErrorHandler(handler);
            
            //Parse the content to Document object
            doc = builder.parse(new InputSource(new StringReader(xmlString)));

            String docType = doc.getLastChild().getNodeName();
            
            if (docType.contains(":"))
            	docType = docType.split(":")[1]; // remove nameSpace

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
