import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.OK_200);
        response.getWriter().print(TestUtils.horoscopesApiPayload());
    }

}
