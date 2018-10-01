package td.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Hello extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) 
			throws ServerException, IOException
	{
		process(request, reponse);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse)
			throws ServerException, IOException 
	{
		process(request, reponse);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse reponse) 
	throws ServerException, IOException
	{
		reponse.setContentType("text/html");
		PrintWriter out = reponse.getWriter();
		out.println("<h1>Hello World </h1>");
		out.println("<h1>Servelet name" +getServletName() + "</h1>");
		out.println("<h1>URI" + request.getRequestURI() + "</h1>");
	}

}
