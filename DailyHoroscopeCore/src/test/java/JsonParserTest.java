import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonParserTest extends JsonTestBase {

    private JsonParser classUnderTest;

    @Mock
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = Mockito.mock(ObjectMapper.class);

        classUnderTest = new JsonParser(objectMapper);
    }

    @Test
    public void canParseFromJsonToHoroscope() throws Exception {

        Horoscopes expected = new Horoscopes(somePrimedHoroscopes());

        Mockito.when(objectMapper.readValue(primedJsonText(), Horoscopes.class)).thenReturn(expected);

        Horoscopes actual = classUnderTest.allHoroscopesFromJson(primedJsonText());

        Mockito.verify(objectMapper).readValue(primedJsonText(), Horoscopes.class);

        assertThat(expected, equalTo(actual));

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
