package acceptance.test;

import io.cucumber.spring.CucumberContextConfiguration;
import main.Main;
import main.util.ResponseUtil;
import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.io.IOException;

@CucumberContextConfiguration
@SpringBootTest(classes = Main.class)
public class SpringIntegrationTest {
    private String link = "http://localhost:8080/v1/comment/";
    private final OkHttpClient client = new OkHttpClient();

    ResponseEntity<Object> executePost(String json) throws IOException {
        RequestBody body = RequestBody.create( json, MediaType.parse("application/json"));
        Request request = new Request.Builder().url(link)
                .addHeader("Authorization", Credentials.basic("admin", "adminpassword"))
                .post(body).build();
        final Call call = client.newCall(request);
        final Response response = call.execute();
        return ResponseUtil.buildResponse(response.body(), HttpStatus.valueOf(response.code()), response.message());
    }
}
