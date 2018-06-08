import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class HoroscopeProviderTest extends JsonTestBase {

    private ApiClient apiClient = mock(ApiClient.class);
    private JsonParser jsonParser = mock(JsonParser.class);
    private Horoscopes horoscopes = mock(Horoscopes.class);

    private HoroscopeProvider classUnderTest = new HoroscopeProvider(jsonParser, apiClient);

    @Before
    public void setUp() throws Exception {
        when(apiClient.horoscopePayload()).thenReturn(horoscopesApiPayload());
    }

    @Test
    public void verifyGetHoroscopeIsInvoked() throws Exception {
        when(jsonParser.allHoroscopesFromJson(horoscopesApiPayload())).thenReturn(horoscopes);

        classUnderTest.horoscopeFor("starSign");

        verify(horoscopes, times(1)).getHoroscope("Starsign");
    }

    @Test
    public void checkValidHoroscopeIsReturned() {
        String givenStarsign = "Gemini";
        when(jsonParser.allHoroscopesFromJson(horoscopesApiPayload())).thenReturn(new Horoscopes(dailyhoroscope(), dates()));

        String actualHoroscope = classUnderTest.horoscopeFor(givenStarsign);

        assertThat(actualHoroscope, is(expectedGeminiValue()));
    }

    @Test
    public void checkValidHoroscopeIsReturnedWhenUsingMixedCase() {
        String givenStarsign = "GeMiNi";
        when(jsonParser.allHoroscopesFromJson(horoscopesApiPayload())).thenReturn(new Horoscopes(dailyhoroscope(), dates()));

        String actualHoroscope = classUnderTest.horoscopeFor(givenStarsign);

        assertThat(actualHoroscope, is(expectedGeminiValue()));
    }

    private String expectedGeminiValue() {
        return "You can spend a huge amount of energy thinking and worrying about how others see you - but... can't you just not care?";
    }
}