import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.OK_200);
        response.getWriter().println("{\n" +
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
                "}");

    }

}
