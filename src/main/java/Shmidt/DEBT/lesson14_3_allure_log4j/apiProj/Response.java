package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

import org.json.JSONObject;

public class Response {
    private int code;
    private String body;

    public Response(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public JSONObject getJsonBody(){
        JSONObject obj = null;
        try{
            obj = new JSONObject(this.body);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return obj;
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
