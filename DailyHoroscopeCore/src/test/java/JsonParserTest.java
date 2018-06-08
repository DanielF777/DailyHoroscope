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

}
