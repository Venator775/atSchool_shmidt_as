package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DummyJsonClientImpl implements DummyJsonClient {

    private static final Logger logger = LogManager.getLogger(DummyJsonClientImpl.class);

    public DummyJsonClientImpl() {
    }

    // dummyjson.com/users/{id}
    public Response getUser(int id) {
        String requestUrl = "https://dummyjson.com/users/" + id;
        HttpGet requestGet = new HttpGet(requestUrl);
        Response response = null;
        logger.debug("getUser() - Request: " + requestUrl);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse getResponse = httpClient.execute(requestGet)) {
//                System.out.println(getResponse.getProtocolVersion());              // HTTP/1.1
//                System.out.println(getResponse.getStatusLine().getStatusCode());   // 200
//                System.out.println(getResponse.getStatusLine().getReasonPhrase()); // OK
//                System.out.println(getResponse.getStatusLine().toString());        // HTTP/1.1 200 OK
            logger.trace("getUser() - getStatusLine: " + getResponse.getStatusLine().toString());
            HttpEntity entity = getResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);

                response = new Response(getResponse.getStatusLine().getStatusCode(), result);
            }
        } catch (Exception ex) {
            logger.error("getUser() - " + ex.getMessage());
        }

        logger.debug("getUser() - Response: " + response.getJsonBody().toString());
        return response;
    }

    // dummyjson.com/auth/login/
    public Response login(User u) throws IOException {

        HttpPost requestPost = new HttpPost("https://dummyjson.com/auth/login");

        Response result = null;

        String json = "{\"username\":\"" + u.getLogin() + "\",\"password\":\"" + u.getPassword() + "\"}";
        StringEntity entity = new StringEntity(json);
        requestPost.setEntity(entity);
        requestPost.setHeader("Accept", "application/json");
        requestPost.setHeader("Content-type", "application/json");

        logger.debug("login() - Request: " + json);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse postResponse = httpClient.execute(requestPost)) {
            result = new Response(postResponse.getStatusLine().getStatusCode(), EntityUtils.toString(postResponse.getEntity()));
            logger.trace("login() - getStatusLine: " + postResponse.getStatusLine().toString());
        } catch (Exception ex) {
            logger.error("login() - " + ex.getMessage());
        }

        logger.debug("login() - Response: " + result.getJsonBody().toString());
        return result;
    }

    // dummyjson.com/auth/posts/{user.id}
    public Response getPosts(User u, Token token) {

        HttpGet requestGet = new HttpGet("https://dummyjson.com/auth/posts/user/" + u.getId());
        requestGet.addHeader("Authorization", "Bearer " + token.getToken());

        Response response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse getResponse = httpClient.execute(requestGet)) {

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
