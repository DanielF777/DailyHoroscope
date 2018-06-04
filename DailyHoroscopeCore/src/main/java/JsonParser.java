import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParser {

    private ObjectMapper objectMapper;

    public JsonParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Horoscopes allHoroscopesFromJson(String payload) {
        try {
            return objectMapper.readValue(payload, Horoscopes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
