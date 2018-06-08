import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class HoroscopeProviderTest extends JsonTestBase {

    private ApiClient apiClient= mock(ApiClient.class);
    private JsonParser jsonParser = mock(JsonParser.class);
    private Horoscopes horoscopes = mock(Horoscopes.class);

    private HoroscopeProvider classUnderTest = new HoroscopeProvider(jsonParser, apiClient);

    @Before
    public void setUp() throws Exception {
        when(apiClient.horoscopePayload()).thenReturn(horoscopesApiPayload());
        when(jsonParser.allHoroscopesFromJson(horoscopesApiPayload())).thenReturn(horoscopes);
    }

    @Test
    public void returnsAValidHoroscope() throws Exception {
        String givenStarsign = "starsign";

        String actual = classUnderTest.horoscopeFor(givenStarsign);

        verify(horoscopes, times(1)).getHoroscope(givenStarsign);
    }
}