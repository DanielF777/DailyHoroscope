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

//    TODO revisit test

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

//       horoscopes = new Horoscopes(allHoroscopes(), new Dates[5]);

        Mockito.when(apiClient.horoscopePayload()).thenReturn(primedJsonText());
        Mockito.when(jsonParser.allHoroscopesFromJson(primedJsonText())).thenReturn(horoscopes);
    }

    @Test
    public void returnsAValidHoroscope() throws Exception {
//        Horoscope expected = someHoroscope();
//        String starsign = expected.getStarsign();

//        String actual = classUnderTest.horoscopeFor(starsign);

//        assertThat(actual, is(expected.getHoroscope()));
    }


}