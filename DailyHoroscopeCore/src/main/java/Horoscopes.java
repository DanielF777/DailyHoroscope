import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Horoscopes {

    private List<Horoscope> horoscopes;

    public Horoscopes(@JsonProperty("dailyhoroscope") Horoscope[] horoscopes) {
        this.horoscopes = Arrays.asList(horoscopes);
    }

    public Horoscope getHoroscope(String horoscopeName) {
        return horoscopes
                .stream()
                .filter(horoscope -> horoscopeName.equals(horoscope.getStarsign()))
                .collect(Collectors.toList())
                .get(0);
    }


}
