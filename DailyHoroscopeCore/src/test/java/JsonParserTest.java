import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class JsonParserTest {

    private final JsonParser jsonParser = new JsonParser();

    @Test
    public void canDeserializeToHoroscope() {
        String givenPayload = TestUtils.horoscopesApiPayload();

        Horoscopes actualHoroscopes = jsonParser.allHoroscopesFromJson(givenPayload);

        Horoscopes expectedHoroscopes = new Horoscopes(TestUtils.dailyhoroscope(), TestUtils.dates());

        // TODO fix assertions
        assertEquals(actualHoroscopes.getDailyhoroscope(), expectedHoroscopes.getDailyhoroscope());
        assertEquals(actualHoroscopes.getDates(), expectedHoroscopes.getDates());

    }

}
