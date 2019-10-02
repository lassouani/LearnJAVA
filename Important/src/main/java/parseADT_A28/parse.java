package parseADT_A28;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationWithoutTNBuilder;
import ca.uhn.hl7v2.validation.impl.NoValidation;

public class parse {

	public static void main(String[] args) throws HL7Exception {
		// TODO Auto-generated method stub
		
		String A28 = "MSH|^~\\&|orion|tests-lionel|globule|Ki-Lab|20181017104815||ADT^A28^ADT_A28|13591162|P|2.5^FRA^2.4|||||FRA|8859/15|FRA\r\n" + 
				"PID|||5555555555^^^NHS^NH||Smith^John^Joe^^Mr||19700101|M|||My flat name^1, The Road^London^London^SW1A 1AA^GBR||john.smith@hotmail.com^NET~01234567890^PRN~07123456789^PRS|john.smith@company.com^NET~01234098765^WPN||||||||||||||||N|\r\n" + 
				"AL1|1||^Paracetamol^|^Mild^|Coughing|\r\n" + 
				"NTE|||||^Foster^John^Harry^^Dr|\r\n" + 
				"DG1|1||^Asthma^||201408310408|||||||||||^Foster^John^Harry^^Dr|\r\n" + 
				"ZRX|^Once A Day^^201409020909^201409160909|^Paracetamol^|1||^Tablet^||^Instructions||||||^Foster^John^Harry^^Dr|\r\n" + 
				"ZTM|first_alias~second_alias~third_alias|";
		
		String a28 = "MSH|^~\\&|orion|tests-lionel|globule|Ki-Lab|20181017104815||ADT^A28|13591162|P|2.5^FRA^2.4|||||FRA|8859/15|FRA\r\n" + 
				"PID|||5555555555^^^NHS^NH||Smith^John^Joe^^Mr||19700101|M|||My flat name^1, The Road^London^London^SW1A 1AA^GBR||john.smith@hotmail.com^NET~01234567890^PRN~07123456789^PRS|john.smith@company.com^NET~01234098765^WPN||||||||||||||||N|\r\n" + 
				"AL1|1||^Paracetamol^|^Mild^|Coughing|\r\n" + 
				"NTE|||||^Foster^John^Harry^^Dr|\r\n" + 
				"DG1|1||^Asthma^||201408310408|||||||||||^Foster^John^Harry^^Dr|\r\n" + 
				"ZRX|^Once A Day^^201409020909^201409160909|^Paracetamol^|1||^Tablet^||^Instructions||||||^Foster^John^Harry^^Dr|\r\n" + 
				"ZTM|first_alias~second_alias~third_alias|";
		
		String A01 = "MSH|^~\\&|orion|tests-lionel|globule|Ki-Lab|20181017104815||ADT^A01^ADT_A01|13591162|P|2.5^FRA^2.4|||||FRA|8859/15|FRA\r\n" + 
				"EVN||20181009104643|201810090900|||201810090900|\r\n" + 
				"PID|||2019091720||soufian10^soufian10^^^^^D~soufian10^soufian10^^^^^L||19940622|M|||15 Boulevard george V ^^Bordeaux^^33000^100^H||^^PH~^^CP~|||S||17032214831|||||FRANCE|||||100||N||||||||||\r\n" + 
				"PV1||H|3311^0028^0028-33||17032214831||3311|||||||0|||||17032214831|||||||||||||||||4||||||||20170419021900|20181009090000|||||3938875|V||\r\n" + 
				"ZFU|||3311|201704190219|3311||\r\n" + 
				"ZUT||||||99131||||I|||N|N|\r\n" + 
				"MRG|250320191028|||250320191026||||\r\n" + 
				"ZRE||||99132||||||11612781|9074600|2554160|2373223||8947779|5||SIDI YKHLEF^Yamina^10101215530^|Agdsoin^Geraldine^12677543232423^|142059919002451||||ROTHERHAM|||||100^100||N";
		
		Message m;
		MSH msh;
		
		
		
//		m = parseMsg(A01);
//		msh = (MSH) m.get("MSH");
		
		
		m = parseMsg(a28);
		msh = (MSH) m.get("MSH");
		String type = msh.getMsh9_MessageType().getMsg2_TriggerEvent().getValue();
		
		PID pid = (PID)m.get("PID");
		
		final ADT_A05 A05 = (ADT_A05) m;
		msh = A05.getMSH();
		pid = A05.getPID();
		
		
		/*
		m = parseA28(a28);
		msh = (MSH) m.get("MSH");
		m.getName();
		
		if (m instanceof GenericMessage) {
			System.out.println("generique message ");
		}
//#####################################################################################		
		Structure[] str = m.getAll("MSH");
		Structure strc = m.get("MSH");
		msh = (MSH) str[0];
		Structure st = str[0];
		String type = msh.getMsh9_MessageType().getMsg2_TriggerEvent().getValue();

		//#####################################################################################	
		
		m = parseA28(A28);
		msh = (MSH) m.get("MSH");
		
		m = parseMsg(a28);
		msh = (MSH) m.get("MSH");
		
		m = parseMsg(A28);
		msh = (MSH) m.get("MSH");
		*/

	}
	
	
	
	
	public static Message parseA28(String msg) throws HL7Exception {
		
		msg = preProcess(msg);
		Parser parser = new GenericParser();
		parser.setValidationContext(new NoValidation());
		Message m = parser.parse(msg);
		
//		PipeParser pipeParser =  new PipeParser();
//		Message m1 =pipeParser.parse(msg);
		
		return m;
		
		
		
		
	}
	
	protected static String preProcess(String hl7Body) {
		if (hl7Body == null) {
			return null;
		}
		return hl7Body.replaceAll("\n", "\r");
	}
	
	
	
	
	
	
	
	
	public static Message parseMsg(String msg) {
		HapiContext context = new DefaultHapiContext();
		context.setValidationRuleBuilder(new DefaultValidationWithFrenchPhoneNumbers());
		Parser p = context.getGenericParser();
		
		Message hapiMsg = null;
		try {
			// The parse method performs the actual parsing
			hapiMsg = p.parse(msg);
		} catch (EncodingNotSupportedException e) {
			e.printStackTrace();
		} catch (HL7Exception e) {
			e.printStackTrace();
		}
		return hapiMsg;

	}

}


class DefaultValidationWithFrenchPhoneNumbers extends DefaultValidationWithoutTNBuilder {

	private static final long serialVersionUID = -4338563603721499444L;
	
	/**
	 * @todo ajouter un validateur pour le numéro de téléphone.
	 */
	protected void configure() {
		super.configure();
		// ceci aurait juste pour conséquence que le numéro de téléphone doive être renseigné.
		// mettre une validation du format du numéro de téléphone à la place
		// forVersion(Version.V23).message("ADT", "*").terser("PID-13", not(empty()));
	}

	
}
