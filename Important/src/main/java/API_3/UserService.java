package API_3;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import org.bson.BSONObject;
import org.bson.Document;


import API_3.User;
import API_3.ConexionUtils;

public class UserService {
	
	Datastore dataStore = ConexionUtils.getConnexion();
	
	
	public User createUser(User user) {
		dataStore.save(user);
		return user;
	}
	
	public List<User> getAllUsers() {
		List<User> list = dataStore.find(User.class).asList();

		return list;
	}

	public User getUser(String id) {
		User user = null;
		System.out.println(id);
		
		DB database = dataStore.getDB();
		System.out.println( database.getName());
		DBCollection dbCollection = database.getCollection(ConexionUtils.COLLECTION_NAME);
		System.out.println(dbCollection.getName());
//		DBObject user = dbCollection.findOne(new ObjectId(id));
		
	    BasicDBObject obj = new BasicDBObject();        
	    obj.append("id", new ObjectId(id));        
	    //BasicDBObject query = new BasicDBObject();
	    DBObject query = new BasicDBObject("id", new ObjectId(id));
	    query.put("id", new ObjectId(id));
	    query.putAll((BSONObject)query);
	    DBObject dbObject = dbCollection.findOne(query);
		
		System.out.println("résultat"+dbObject);
		
		//Document document = dbCollection.find(eq("_id", new ObjectId("4f693d40e4b04cde19f17205"))).first();
		
		return  user;
	}
	
	
	
	

	
	private void failIfInvalid(String name, String email) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'name' cannot be empty");
		}
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'email' cannot be empty");
		}
	}

}
