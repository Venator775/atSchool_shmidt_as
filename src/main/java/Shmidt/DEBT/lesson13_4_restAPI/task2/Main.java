package Shmidt.DEBT.lesson13_4_restAPI.task2;

import org.json.JSONObject;

import java.io.IOException;

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

        Post p = new Post(getAuthPostsJson);

        System.out.println();
    }


}
