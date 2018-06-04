import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiClientTest extends JsonTestBase {

    private ApiClient classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new ApiClient(new URI("http://localhost:7070"));
    }

    @Test
    public void canGetDataFromEndpoint() throws Exception {

        startServer();

        String expected = primedJsonText();
        String actual = classUnderTest.horoscopePayload();

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
}
