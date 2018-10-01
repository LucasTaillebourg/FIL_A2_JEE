package td.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.rmi.ServerException;

@WebServlet("/Redirect")
public class Redirect extends HttpServlet {

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

        String pageNumber = request.getParameter("page").isEmpty() ? "" : request.getParameter("page");

        switch(pageNumber){
            case "1" : {
                response.sendRedirect("page1.html");
                break;
            }
            case "2" : {
                response.sendRedirect("page2.html");
                break;
            }
            default: {
                response.sendError(404);
            }
        }

    }

}