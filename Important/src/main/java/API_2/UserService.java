package API_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import API_2.User;

public class UserService {

	private Map<String, User> users = new HashMap<>();
	
	MongoClient client = new MongoClient("localhost", 27017); //connect to mongodb
	Datastore datastore = new Morphia().createDatastore(client, "collect"); //select collection

	public List<User> getAllUsers() {
		//List<User> list = datastore.find(User.class).asList();

		return new ArrayList<>(users.values());
	}

	public User getUser(String id) {
		return users.get(id);
	}

	public User createUser(String name, String email) {
		
		failIfInvalid(name, email);
		User user = new User(name, email);
		//datastore.save(user);
		users.put(user.getId(), user);
		return user;
	}

	public User updateUser(String id, String name, String email) {
		User user = users.get(id);
		if (user == null) {
			throw new IllegalArgumentException("No user with id '" + id + "' found");
		}
		failIfInvalid(name, email);
		user.setName(name);
		user.setEmail(email);
		return user;
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