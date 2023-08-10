package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) throws IOException {
        DummyJsonClientImpl clientImpl = new DummyJsonClientImpl();

        System.out.println("getUser");
        Response getUserResp = clientImpl.getUser(2);
        getUserResp.showRespInfo();
        JSONObject userJson = getUserResp.getJsonBody();
        User user1 = new User(userJson);

        System.out.println("login");
        Response postLoginResp = clientImpl.login(user1);
        postLoginResp.showRespInfo();
        JSONObject loginJson = clientImpl.login(user1).getJsonBody();

        System.out.println("posts");
        Response getAuthPosts = clientImpl.getPosts(user1, new Token(loginJson));
        getAuthPosts.showRespInfo();
        JSONObject getAuthPostsJson = getAuthPosts.getJsonBody();

        List<Post> posts = getPosts(getAuthPosts);

        System.out.println();
    }

    static List<Post> getPosts(Response getAuthPosts) {
        JSONArray jsonArrayPosts = getAuthPosts.getJsonBody().getJSONArray("posts");
        return StreamSupport.stream(jsonArrayPosts.spliterator(), false)
                .map(o -> o instanceof JSONObject ? (JSONObject) o : null)
                .filter(Objects::nonNull)
                .map(obj -> new Post(
                                obj.getInt("id"),
                                obj.getString("title"),
                                obj.getInt("userId")
                        )
                )
                .collect(Collectors.toList());
    }

}
