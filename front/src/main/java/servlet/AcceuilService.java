package servlet;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AcceuilService")
public class AcceuilService extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServerException, IOException {
		process(request, reponse);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServerException, IOException {
		process(request, reponse);
	}

	protected void process(HttpServletRequest request, HttpServletResponse reponse)
			throws ServerException, IOException {
		RequestDispatcher rd ;
	
		rd = request.getRequestDispatcher("pages/acceuil.jsp");
		try {
			rd.forward(request, reponse);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
