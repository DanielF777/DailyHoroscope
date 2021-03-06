import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Horoscopes {

    private Map<String, String> dailyhoroscope;
    private Map<String, String> dates;

    public Horoscopes(@JsonProperty("dailyhoroscope") Map<String, String> dailyhoroscope,
                      @JsonProperty("dates") Map<String, String> dates) {
        this.dailyhoroscope = dailyhoroscope;
        this.dates = dates;
    }

    public String getHoroscope(String horoscopeName) {
        return dailyhoroscope.get(horoscopeName);
    }

    public Map getDailyhoroscope() {
        return dailyhoroscope;
    }

    public Map getDates() {
        return dates;
    }
}
