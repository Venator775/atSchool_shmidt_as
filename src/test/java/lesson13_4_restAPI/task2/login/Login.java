package lesson13_4_restAPI.task2.login;

import Shmidt.DEBT.lesson13_4_restAPI.task2.Response;

import static lesson13_4_restAPI.task2.JsonWorker.getJsonStringParameter;

public class Login {
    public static void checkLoginToken(Response response){
        getJsonStringParameter(response.getJsonBody(), "token");
    }
}
