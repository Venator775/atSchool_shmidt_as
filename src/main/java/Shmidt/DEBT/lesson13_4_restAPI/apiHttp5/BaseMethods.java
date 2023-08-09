package Shmidt.DEBT.lesson13_4_restAPI.apiHttp5;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicHeader;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.apache.hc.core5.http.HttpHeaders.ACCEPT;
import static org.apache.hc.core5.http.HttpHeaders.CONTENT_TYPE;


public class BaseMethods implements Methods {
    private final Client client = new Client();

    private CustomUriBuilder uriBuilder;// = new CustomUriBuilder("https://dummyjson.com/users");

    public BaseMethods(String uri) {
        uriBuilder = new CustomUriBuilder(uri);
    }

    public BaseMethods() {
        uriBuilder = new CustomUriBuilder("https://dummyjson.com/users");
    }

    @Override
    public HttpResponseDecorator get() {
        HttpGet get = new HttpGet(uriBuilder.getUri());
        get.setHeaders(
                new BasicHeader(CONTENT_TYPE, "application/json"),
                new BasicHeader(ACCEPT, "application/json")
        );
        try {
            return client.getSimpleClient().execute(get, new HttpResponseDecorator());
        } catch (Exception ex) {
            ex.getMessage();
        }
        throw new RuntimeException("Запрос не выполнен");
    }

    @Override
    public HttpResponseDecorator post(String json) {
        HttpPost post = new HttpPost(uriBuilder.getUri());
        post.setHeaders(getBasicHeaders());
        post.setEntity(new StringEntity(json));

        try {
            client.getSimpleClient().execute(post, new HttpResponseDecorator());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Запрос не выполнен");
    }

    @Override
    public HttpResponseDecorator post(JSONObject jsonObj) {
        String json = jsonObj.toString();

        HttpPost post = new HttpPost(uriBuilder.getUri());
        post.setHeaders(getBasicHeaders());
        post.setEntity(new StringEntity(json));

        try {
            client.getSimpleClient().execute(post, new HttpResponseDecorator());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Запрос не выполнен");
    }

    private Header[] getBasicHeaders() {
        return new Header[]{
                new BasicHeader(CONTENT_TYPE, "application/json"),
                new BasicHeader(ACCEPT, "application/json")
        };
    }


    public CustomUriBuilder getUriBuilder() {
        return uriBuilder;
    }

    public static JSONObject readJSONToObj(String path) {
        Path filePath = Path.of(path);
        try {
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            return new JSONObject(content);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
