package okHttp3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPostRequestParameterExample {

    private static final String BASE_URL = "http://localhost:8080/spring-rest";

    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        final RequestBody formBody = new FormBody.Builder()
            .add("username", "test")
            .add("password", "test").build();

        final Request request = new Request.Builder()
            .url(BASE_URL + "/users")
            .post(formBody).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();
        System.out.println(response);
    }
}