import com.fasterxml.jackson.annotation.JsonProperty;

public class Horoscope {
    private final String starsign;
    private final String horoscope;

    public Horoscope(@JsonProperty String starsign, @JsonProperty String horoscope) {
        this.starsign = starsign;
        this.horoscope = horoscope;
    }

    public String getStarsign() {
        return starsign;
    }

    public String getHoroscope() {
        return horoscope;
    }
}
