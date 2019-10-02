package okHttp3;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPostUploadFileExample {

    private static final String BASE_URL = "http://localhost:8080/spring-rest";

    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("username", "test").addFormDataPart("password", "test")
            .addFormDataPart("file", "file.txt", RequestBody.create(MediaType.parse("application/octet-stream"),
                new File("src/test/resources/test.txt")))
            .build();

        Request request = new Request.Builder().url(BASE_URL + "/users/multipart").post(requestBody).build();

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.code());
    }
    
    
    
}