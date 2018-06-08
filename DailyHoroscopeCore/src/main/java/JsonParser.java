import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParser {

    public Horoscopes allHoroscopesFromJson(String payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return objectMapper.readValue(payload, Horoscopes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
