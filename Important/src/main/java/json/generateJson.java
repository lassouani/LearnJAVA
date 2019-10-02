package json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class generateJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String codeRetour = "200";
		
		List<String> results = new ArrayList<>();
		List<String> Warnings = new ArrayList<>();
		
		Warnings.add("L'identifier du patient id :23 n'est pas créé");
		Warnings.add("Le dossier N° 1234 n'a pas été mis à jour.");
		
		results.add("ADT_A01 : Création du patient id :23 réussie");
		results.add("ADT_A31 : Erreur lors de la mise à jour du patient");
		
		
		Resultat resultJson = new Resultat(codeRetour, results, Warnings);
		
		Gson gson = new Gson();
		String returnVal = gson.toJson(resultJson);
		
		System.out.println(returnVal);

	}
	
	
	
	
	
	
	
	public static class Resultat{
		private String code;
		private List<String> messages;
		private  List<String> warnings;
		
		
		public Resultat(String code,  List<String> messages, List<String> warnings) {
			this.code = code;
			this.messages = messages;
			this.warnings = warnings;
		}
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public List<String> getMessages() {
			return messages;
		}
		public void setMessages(List<String> messages) {
			this.messages = messages;
		}
		public List<String> getWarnings() {
			return warnings;
		}
		public void setWarnings(List<String> warnings) {
			this.warnings = warnings;
		}

		
	}

}



