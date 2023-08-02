package Shmidt.DEBT.lesson13_4_restAPI.task2.examples;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SendJSONPOSTRequest {
    public static void main(String[] args) {

        try {
            StringBuilder json = new StringBuilder();
            json.append("{");
            json.append("\"name\":\"mkyong\",");
            json.append("\"notes\":\"hello\"");
            json.append("}");

            String result = sendPOST("https://httpbin.org/post",json.toString());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String sendPOST(String url, String json) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);


        // send a JSON data
        post.setEntity(new StringEntity(json));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
}
