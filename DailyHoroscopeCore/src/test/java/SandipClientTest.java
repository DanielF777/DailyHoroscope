import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.RoleInfo;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.Servlet;
import java.io.IOException;
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

    private SandipClient classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new SandipClient(new URI("http://localhost:7070"));
    }

    @Test
    public void canGetDataFromEndpoint() throws Exception {

        startServer();

        String expected = primedJSONResponse();

        String actual = classUnderTest.horoscopePayloadFor(getHardCodedStarsign());

        assertThat(expected, equalTo(actual));

    }

    private void startServer() throws Exception {

        SessionHandler sessionHandler = new SessionHandler();
        ConstraintSecurityHandler securityHandler = new ConstraintSecurityHandler();
        ServletHandler servletHandler = new ServletHandler();

        Server server = new Server(7070);

        ServletContextHandler handler = new ServletContextHandler(
                server,
                sessionHandler,
                securityHandler,
                servletHandler,
                null
        );

        handler.addServlet(MyServlet.class, "/");

        server.start();

    }

    private String primedJSONResponse() {
        return "{\n" +
                " \"sunsign\": \"Gemini\",\n" +
                " \"credit\": \"(c) Kelli Fox, The Astrologer, http://new.theastrologer.com\",\n" +
                " \"date\" : \"2018-03-09\",\n" +
                " \"horoscope\" : \"The world is your oyster today. So what are you waiting for? \n" +
                " Get out there and find your adventure. It's a perfect day for learning \n" +
                " something new. This can be formalized through taking a class, or it can be \n" +
                " an informal, impromptu process. That's what 'the world is your oyster' means \n" +
                " -- your pearl of knowledge is out there, just waiting to be discovered. So \n" +
                " where will you search for it first?\n" +
                " (c) Kelli Fox, The Astrologer, http://new.theastrologer.com\",\n" +
                " \"meta\" { \n" +
                "    \"mood\" : \"strange\",\n" +
                "    \"keywords\": \"one-sided, fervor\",\n" +
                "    \"intensity\": \"87%\" \n" +
                "  } \n" +
                "}\n";
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
