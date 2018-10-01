package td.servlet.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;


@WebServlet("/SessionShow")
public class SessionShow extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {

        HttpSession httpSession = request.getSession();

        Object sessionContent = httpSession.getAttribute("truc") == null ? "" : httpSession.getAttribute("truc");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + sessionContent.toString() + "</h1>");
    }

}