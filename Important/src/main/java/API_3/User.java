package API_3;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.bson.types.ObjectId;


@Entity
public class User {
	
	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private Integer old;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getOld() {
		return old;
	}
	public void setOld(Integer old) {
		this.old = old;
	}
	
	

}
