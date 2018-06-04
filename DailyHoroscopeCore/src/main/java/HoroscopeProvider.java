public class HoroscopeProvider {

    private JsonParser jsonParser;
    private ApiClient apiClient;

    public HoroscopeProvider(JsonParser jsonParser, ApiClient apiClient) {
        this.jsonParser = jsonParser;
        this.apiClient = apiClient;
    }

    public Horoscope horoscopeFor(String starsign) {
        String payload = apiClient.horoscopePayload();
        Horoscopes horoscopes = jsonParser.allHoroscopesFromJson(payload);

        return horoscopes.getHoroscope(starsign);
    }

}
