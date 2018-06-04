import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HoroscopeProviderTest extends JsonTestBase {

    @Mock
    private ApiClient apiClient;

    @Mock
    private JsonParser jsonParser;

    private HoroscopeProvider classUnderTest;

    private Horoscopes horoscopes;

    @Before
    public void setUp() throws Exception {
        apiClient = Mockito.mock(ApiClient.class);
        jsonParser = Mockito.mock(JsonParser.class);
        classUnderTest = new HoroscopeProvider(jsonParser, apiClient);
        horoscopes = new Horoscopes(allHoroscopes());

        Mockito.when(apiClient.horoscopePayload()).thenReturn(primedJsonText());
        Mockito.when(jsonParser.allHoroscopesFromJson(primedJsonText())).thenReturn(horoscopes);
    }

    @Test
    public void returnsAValidHoroscope() throws Exception {
        Horoscope expected = someHoroscope();
        String starsign = expected.getStarsign();

        Horoscope actual = classUnderTest.horoscopeFor(starsign);

        assertThat(actual.getStarsign(), is(expected.getStarsign()));
        assertThat(actual.getHoroscope(), is(expected.getHoroscope()));
    }

    private Horoscope someHoroscope() {
        List<Horoscope> starSigns = Arrays.asList(allHoroscopes());

        Collections.shuffle(starSigns);

        return starSigns.get(0);
    }

    private Horoscope[] allHoroscopes() {
        return new Horoscope[]{
                new Horoscope(
                        "Gemini",
                        "\"You may catch yourself in the act of being suspicious of others " +
                                "and secretly ascribing hidden motives to their actions.\""
                ),
                new Horoscope("Aries",
                        "\"You shouldn't be listening to gossip or spreading it yourself. " +
                                "It's fun when someone else is the subject, but what if you were " +
                                "that person?\""),
                new Horoscope(
                        "Taurus",
                        "Be careful not to cut corners or take the easy way out - even " +
                                "though it is tempting, it is not worth it in the long run."
                )
        };
    }
}