package Shmidt.tests.apiHttp5;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class HttpResponseDecorator implements HttpClientResponseHandler<HttpResponseDecorator> {
    private Integer statusCode;
    private String entity;

    public HttpResponseDecorator setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public HttpResponseDecorator setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public HttpResponseDecorator handleResponse(ClassicHttpResponse response){
        try {
            return new HttpResponseDecorator()
                    .setEntity(EntityUtils.toString(response.getEntity()))
                    .setStatusCode(response.getCode());
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getEntity() {
        return entity;
    }


}
