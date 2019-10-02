package okHttp3;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPost {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        String result = null;
        try {
        	Response response = client.newCall(request).execute();
        	result = response.body().string();
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return result;
        
    }

    public static void main(String[] args) throws IOException {
        OkHttpPost example = new OkHttpPost();
        String json = "{\r\n" +
            " \"firstName\" : \"Ramesh\",\r\n" +
            " \"lastName\" : \"Fadatare\",\r\n" +
            " \"emailId\" : \"ramesh@gmail.com\"\r\n" +
            "}";
        String response = example.post("http://localhost:8080/api/v1/employees", json);
        System.out.println(response);
    }
}
