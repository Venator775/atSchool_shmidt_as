package Shmidt.DEBT.lesson13_4_restAPI.apiHttp5;

import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.net.http.HttpClient;

public class Client {

    private CookieStore cookieStore = new BasicCookieStore();

    public CloseableHttpClient getSimpleClient(){
        return HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }
}
