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

public class OkHttpPostUploadFileExampleB64 {

    private static final String BASE_URL = "http://localhost:8080/spring-rest";

    static OkHttpClient client = new OkHttpClient();
    private static final MediaType MEDIA_TYPE_FORM_DATA = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    
    public static void main(String[] args) throws IOException {
    	byte[] bytes = null;
    	RequestBody requestBody = RequestBody.create(MEDIA_TYPE_FORM_DATA, bytes);
    	Request request = buildMultipartPostRequest("url.toString()", requestBody);
    	
    	
        

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.code());
    }
    
    
    private static Request buildMultipartPostRequest(String url, RequestBody requestBody) {
		final RequestBody request = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("file","", requestBody)
	            .build();
		return new Request.Builder().url(url).post(request).build();
	}
}