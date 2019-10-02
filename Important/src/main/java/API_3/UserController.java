package API_3;

import static API_3.JsonUtil.json;
import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;
import com.mongodb.DBObject;

import API_3.ResponseError;
import API_3.User;
import API_3.UserService;
import spark.Request;
import spark.Response;
import spark.Route;

public class UserController {

	Gson gson = new Gson();
	
	public UserController(final UserService userService) {
		
//		get("/users", new Route() {
//		      @Override
//		      public Object handle(Request request, Response response) {
//		        // process request
//		        return userService.getAllUsers();
//		      }
//
//		});
		
		get("/users", (req, res) -> userService.getAllUsers(), json());
		
		
		get("/users/:id", (req, res) -> {

			String id = req.params(":id");
			User user = userService.getUser(id);
			if (user != null) {
				return user;
			}
			res.status(400);
			return new ResponseError("No user with id '%s' found", id);
		}, json());
		
		
//		post("/users", (req, res) -> userService.createUser(
//				req.queryParams("name"),
//				req.queryParams("email"), req.body()
//		), json());
		
		post("/user", (req, res) -> {
			res.type("application/json");
			
			User u = gson.fromJson(req.body(), User.class);
			return userService.createUser(u);
		}, json());
		
		
		
	}
}
