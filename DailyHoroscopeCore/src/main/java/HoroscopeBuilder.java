import java.util.Date;

public class HoroscopeBuilder {

    private String starsign;
    private Date date;
    private String horoscope;
    private Metadata metaData;
    private String credit;

    public HoroscopeBuilder withStarsign(String starsign) {
        this.starsign = starsign;
        return this;
    }

    public HoroscopeBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public HoroscopeBuilder withHoroscope(String horoscope) {
        this.horoscope = horoscope;
        return this;
    }

    public HoroscopeBuilder withMetaData(Metadata metaData) {
        this.metaData = metaData;
        return this;
    }

    public HoroscopeBuilder withCredit(String credit) {
        this.credit = credit;
        return this;
    }

    public Horoscope build() {
        return new Horoscope(starsign, credit, date, horoscope, metaData);
    }

}
