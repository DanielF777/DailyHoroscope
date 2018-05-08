import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Horoscope {

    private String starsign;
    private String credit;
    private String horoscope;
    private Date date;
    private Metadata metaData;

    public Horoscope(@JsonProperty("sunsign") String starsign,
                     @JsonProperty("credit") String credit,
                     @JsonProperty("date") Date date,
                     @JsonProperty("horoscope") String horoscope,
                     @JsonProperty("meta") Metadata metaData) {
        this.starsign = starsign;
        this.date = date;
        this.horoscope = horoscope;
        this.metaData = metaData;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public String getStarsign() {
        return starsign;
    }

    public Date getDate() {
        return date;
    }

    public Metadata getMetaData() {
        return metaData;
    }
}
