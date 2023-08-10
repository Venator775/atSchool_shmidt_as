package lesson14_3_allure_log4j.apiProj.login;

import Shmidt.DEBT.lesson13_4_restAPI.task2.Response;

import static lesson13_4_restAPI.task2.JsonHelper.getJsonStringParameter;

public class LoginChecks {
    public static void checkLoginToken(Response response){
        getJsonStringParameter(response.getJsonBody(), "token");
    }
}
