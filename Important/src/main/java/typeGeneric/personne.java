package typeGeneric;

import java.util.List;

public class personne {
	
	
	private String id;
	private String nom;
	private String prenom;
	
	private List<?> list;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	
	

}
