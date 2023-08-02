package Shmidt.DEBT.lesson13_4_restAPI.task2;

import org.json.JSONObject;

public class Response {
    private int code;
    private String body;

    public Response(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public JSONObject getJsonBody(){
        return new JSONObject(this.body);
    }

    public void showRespInfo(){
        System.out.println(this.getCode());
        System.out.println(this.getBody());
    }

    //region getters/setters
    public int getCode() {
        return code;
    }
    public String getBody() {
        return body;
    }
    //endregion
}
