package td.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloConfig")
public class HelloConfig extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) 
			throws ServerException, IOException {
		process(request, reponse);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse)
			throws ServerException, IOException {
		process(request, reponse);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse reponse) 
	throws ServerException, IOException {
		String lang = request.getParameter("lang");
		if(lang == null) lang = request.getLocale().getLanguage();
		String welcomeMsg;
		String nom = request.getParameter("nom").isEmpty() ? "" : request.getParameter("nom");

		switch(lang) {
		case "fr":
			welcomeMsg = "Bonjour world";
			break;
		default:
			welcomeMsg = "Hello world";
		}
		reponse.setContentType("text/html");
		PrintWriter out = reponse.getWriter();
		out.println("<h1>"+welcomeMsg + " " + nom +" </h1>");
		out.println("<h1>Servelet name" +getServletName() + "</h1>");
		out.println("<h1>URI" + request.getRequestURI() + "</h1>");
		out.println("<h1>Lang " + lang + "</h1>");
		
	}

}
