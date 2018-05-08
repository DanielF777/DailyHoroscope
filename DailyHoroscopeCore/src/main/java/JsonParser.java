import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParser {

    private ObjectMapper objectMapper;

    public JsonParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Horoscope parseToHoroscope(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Horoscope.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
