import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URISyntaxException;

public class Runner {

    public static void main(String[] args) throws URISyntaxException {

        ApiClient apiClient = new ApiClient(new URI("https://www.horoscopes-and-astrology.com/json"));

        JsonParser jsonParser = new JsonParser(new ObjectMapper());

        HoroscopeProvider horoscopeProvider = new HoroscopeProvider(jsonParser, apiClient);

        System.out.println(horoscopeProvider.horoscopeFor("Sagittarius"));

    }
}
