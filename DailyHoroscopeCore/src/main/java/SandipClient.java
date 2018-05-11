import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;

import static java.nio.charset.Charset.defaultCharset;

public class SandipClient {

    private URI uri;
    private CloseableHttpClient httpClient;

    public SandipClient(URI uri) {
        this.uri = uri;
        this.httpClient = HttpClientBuilder.create().build();
    }

    public String horoscopePayloadFor(String horoscope) {

        String payload = "";
        String endpoint = uri.toString() + "/" + horoscope + "/today";

        try {
            HttpResponse response = httpClient.execute(new HttpGet(endpoint));
            payload = IOUtils.toString(response.getEntity().getContent(), defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return payload;
    }
}
