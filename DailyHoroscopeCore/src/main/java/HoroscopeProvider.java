import org.apache.commons.lang3.StringUtils;

public class HoroscopeProvider {

    private JsonParser jsonParser;
    private ApiClient apiClient;

    public HoroscopeProvider(JsonParser jsonParser, ApiClient apiClient) {
        this.jsonParser = jsonParser;
        this.apiClient = apiClient;
    }

    public String horoscopeFor(String starsign) {
        String payload = apiClient.horoscopePayload();
        Horoscopes horoscopes = jsonParser.allHoroscopesFromJson(payload);

        String capitalizedStarsign = StringUtils.capitalize(starsign.toLowerCase());
        String horoscopeAnswer = horoscopes.getHoroscope(capitalizedStarsign);
        return StringUtils.replacePattern(horoscopeAnswer, "<a.*", "");
    }

}
