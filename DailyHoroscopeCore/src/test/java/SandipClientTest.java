import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SandipClientTest {

    @Mock
    private JsonParser jsonParser;

    private SandipClient classUnderTest;

    @Before
    public void setUp() throws Exception {
        jsonParser = mock(JsonParser.class);
        when(jsonParser.parseToHoroscope(primedJSONResponse())).thenReturn(horoscopeFromHardcodedResponse());
        classUnderTest = new SandipClient(new URI("http://localhost:7070"), jsonParser);
    }

    @Test
    public void canGetDataFromEndpoint() throws Exception {

        startServer();

        Horoscope expected = new HoroscopeBuilder()
                .withHoroscope(getHoroscopeText())
                .withDate(new Date(2018, 3, 9))
                .withMetaData(getMetadata())
                .withStarsign(getHardCodedStarsign())
                .build();

        Horoscope actual = classUnderTest.horoscopeFor(getHardCodedStarsign());

        assertThat(expected.getStarsign(), equalTo(actual.getStarsign()));
        assertThat(expected.getDate(), equalTo(actual.getDate()));
        assertThat(expected.getHoroscope(), equalTo(actual.getHoroscope()));
        assertThat(expected.getMetaData(), equalTo(actual.getMetaData()));

    }

    private void startServer() throws Exception {
        Server server = new Server(7070);

        ServletContextHandler handler = new ServletContextHandler(server, "/Gemini/Today");

        handler.addServlet(MyServlet.class, "/");

        server.start();

    }

    private String primedJSONResponse() {
        return "{\n" +
                "  \"sunsign\": \"Gemini\",\n" +
                "  \"credit\": \"(c) Kelli Fox, The Astrologer, http://new.theastrologer.com\",\n" +
                "  \"date\": \"2018-03-09\",\n" +
                "  \"horoscope\": \"The world is your oyster today. So what are you waiting for? Get out there and find your adventure. It's a perfect day for learning something new. This can be formalized through taking a class, or it can be an informal, impromptu process. That's what 'the world is your oyster' means -- your pearl of knowledge is out there, just waiting to be discovered. So where will you search for it first?(c) Kelli Fox, The Astrologer, http://new.theastrologer.com\",\n" +
                "  \"meta\": {\n" +
                "    \"mood\": \"strange\",\n" +
                "    \"keywords\": \"one-sided, fervor\",\n" +
                "    \"intensity\": \"87%\"\n" +
                "  }\n" +
                "}";
    }

    private Horoscope horoscopeFromHardcodedResponse() {
        return new Horoscope(
                getHardCodedStarsign(),
                "(c) Kelli Fox, The Astrologer, http://new.theastrologer.com",
                getDate(),
                getHoroscopeText(),
                getMetadata()
        );
    }

    private String getHardCodedStarsign() {
        return "Gemini";
    }

    private Metadata getMetadata() {
        return new Metadata(
                "strange",
                "one-sided, fervor",
                "87%"
        );
    }

    public Date getDate() {

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

        Date date = null;

        try {
            date = dateFormat.parse("2018-03-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }

    public String getHoroscopeText() {
        return "The world is your oyster today. So what are you waiting for? Get out there and find your adventure. It's a perfect day for learning something new. " +
                "This can be formalized through taking a class, or it can be an informal, impromptu process." +
                "That's what 'the world is your oyster' means -- your pearl of knowledge is out there, just waiting to be discovered. " +
                "So where will you search for it first?(c) Kelli Fox, The Astrologer, http://new.theastrologer.com";
    }
}
