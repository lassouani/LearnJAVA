package API_3;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public final class ConexionUtils {
	
	public static final Integer PORT = 27017;
	public static final String SERVER = "localhost";
	public static final String DB_NAME = "collect";
	public static final String COLLECTION_NAME = "User";
	
	public static Datastore getConnexion() {
	
		MongoClient client = new MongoClient(SERVER, PORT); //connect to mongodb
		Datastore datastore = new Morphia().createDatastore(client, DB_NAME); //select collection
	
	return datastore;
	}
	
	
	

}
