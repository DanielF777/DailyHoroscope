import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;

import static java.nio.charset.Charset.defaultCharset;

public class ApiClient {

    private URI uri;

    public ApiClient(URI uri) {
        this.uri = uri;
    }

    public String horoscopePayload() {

        String payload = "";

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(uri.toString());

        try {
            HttpResponse response = httpClient.execute(request);
            payload = IOUtils.toString(response.getEntity().getContent(), defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return payload;

    }

}
