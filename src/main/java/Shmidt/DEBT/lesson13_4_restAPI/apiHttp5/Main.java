package Shmidt.DEBT.lesson13_4_restAPI.apiHttp5;

import Shmidt.DEBT.lesson13_4_restAPI.task2.Response;
import org.json.JSONObject;

import java.net.URISyntaxException;

import static Shmidt.DEBT.lesson13_4_restAPI.apiHttp5.BaseMethods.readJSONToObj;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        BaseMethods getMethods = new BaseMethods("https://dummyjson.com/users");

        var g = getMethods.get();

        BaseMethods postMethods = new BaseMethods("https://dummyjson.com/auth/login");
        JSONObject jsonObj = readJSONToObj("src/test/resources/user.json");

        var p = postMethods.post("{\"password\":\"CQutx25i8r\",\"id\":\"2\",\"username\":\"hbingley1\"}");

        Response res = new Response(p.getStatusCode(), p.getEntity());
        System.out.println(res.getCode());
        System.out.println(res.getBody());
    }
}