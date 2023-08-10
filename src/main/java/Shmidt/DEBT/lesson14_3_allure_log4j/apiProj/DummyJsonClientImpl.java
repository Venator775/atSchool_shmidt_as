package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DummyJsonClientImpl implements DummyJsonClient {

    public DummyJsonClientImpl() {
    }

    // dummyjson.com/users/{id}
    public Response getUser(int id) {

        HttpGet request = new HttpGet("https://dummyjson.com/users/" + id);
        Response response = null;

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse getResponse = httpClient.execute(request)) {

//                System.out.println(getResponse.getProtocolVersion());              // HTTP/1.1
//                System.out.println(getResponse.getStatusLine().getStatusCode());   // 200
//                System.out.println(getResponse.getStatusLine().getReasonPhrase()); // OK
//                System.out.println(getResponse.getStatusLine().toString());        // HTTP/1.1 200 OK

            HttpEntity entity = getResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);

                response = new Response(getResponse.getStatusLine().getStatusCode(), result);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }

    // dummyjson.com/auth/login/
    public Response login(User u) throws IOException {
        HttpPost post = new HttpPost("https://dummyjson.com/auth/login");

        Response result = null;

        List<NameValuePair> requestBodyParameters = new ArrayList<>();
        requestBodyParameters.add(new BasicNameValuePair("username", u.getLogin()));
        requestBodyParameters.add(new BasicNameValuePair("password", u.getPassword()));
        post.setEntity(new UrlEncodedFormEntity(requestBodyParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            result = new Response(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    // dummyjson.com/auth/posts/{user.id}
    public Response getPosts(User u, Token token) {

        HttpGet request = new HttpGet("https://dummyjson.com/auth/posts/user/" + u.getId());
        request.addHeader("Authorization", "Bearer " + token.getToken());

        Response response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse getResponse = httpClient.execute(request)) {

            HttpEntity entity = getResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JSONArray jsonArray = new JSONObject(result).getJSONArray("posts");

                List<Post> posts = StreamSupport.stream(jsonArray.spliterator(), false)
                        .map(o -> {
                            if (o instanceof JSONObject) {
                                return (JSONObject) o;
                            }
                            return null;
                        })
                        .filter(Objects::nonNull)
                        .map(obj -> new Post(
                                        obj.getInt("id"),
                                        obj.getString("title"),
                                        obj.getInt("userId")
                                )
                        )
                        .collect(Collectors.toList());

                response = new Response(getResponse.getStatusLine().getStatusCode(), result);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return response;
    }


}
