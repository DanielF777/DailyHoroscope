import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonParserTest extends JsonTestBase {

    private final JsonParser jsonParser = new JsonParser();

    @Test
    public void canDeserializeToHoroscope() {
        String givenPayload = horoscopesApiPayload();

        Horoscopes actualHoroscopes = jsonParser.allHoroscopesFromJson(givenPayload);

        Horoscopes expectedHoroscopes = new Horoscopes(dailyhoroscope(), dates());
        assertThat(actualHoroscopes.getDailyhoroscope(), equalTo(expectedHoroscopes.getDailyhoroscope()));
        assertThat(actualHoroscopes.getDates(), equalTo(expectedHoroscopes.getDates()));
    }

    private Horoscope[] somePrimedHoroscopes() {
        return new Horoscope[]{
                new Horoscope("Aries", "You shouldn’t be listening to gossip or spreading it yourself. " +
                        "It’s fun when someone else is the subject, but what if you were that person?" +
                        "<a href=\"https://horoscopes-and-astrology.com/Aries\">"),
                new Horoscope("Taurus", "Be careful not to cut corners or take the easy way out - " +
                        "even though it is tempting, it is not worth it in the long run." +
                        "<a href=\"https://horoscopes-and-astrology.com/Taurus\">"),
                new Horoscope("Gemini", "You may catch yourself in the act of being suspicious of others " +
                        "and secretly ascribing hidden motives to their actions." +
                        "<a href=\"https://horoscopes-and-astrology.com/Gemini\">")
        };
    }
}
