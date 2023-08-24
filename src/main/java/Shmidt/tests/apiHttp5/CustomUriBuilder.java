package Shmidt.tests.apiHttp5;


import org.apache.hc.core5.net.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Собирает ссылку
 */
public class CustomUriBuilder extends URIBuilder {

    private URI uri;
    //private final URIBuilder uriBuilder = new URIBuilder();

    public CustomUriBuilder() {
    }

    public CustomUriBuilder(String host) {
        try {
            this.uri = new URI(host);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }

    public CustomUriBuilder(String host, String parameters) {
        try {
            this.uri = new URI(host + "/" + parameters);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }


/*    public CustomUriBuilder(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }*/

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }


}
