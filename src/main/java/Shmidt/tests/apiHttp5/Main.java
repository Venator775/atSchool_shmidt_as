package Shmidt.tests.apiHttp5;

import org.json.JSONObject;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        BaseMethods getMethods = new BaseMethods("https://dummyjson.com/users");
        var g = getMethods.get();
        System.out.println(g.getStatusCode());
        System.out.println(g.getEntity());


        BaseMethods postMethods = new BaseMethods("https://dummyjson.com/auth/login");
        JSONObject jsonObj = BaseMethods.readJSONToObj("src/main/java/Shmidt/tests/apiHttp5/user.json");
        var p = postMethods.post(jsonObj);
        System.out.println(p.getStatusCode());
        System.out.println(p.getEntity());
    }
}