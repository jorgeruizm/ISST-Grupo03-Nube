package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inube.dao.UserDAO;
import es.upm.dit.isst.inube.dao.UserDAOImplementation;
import es.upm.dit.isst.inube.model.User;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		
		UserDAO udao = UserDAOImplementation.getInstance();
		User user = udao.read( email );
		udao.delete( user );
		
		getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );
	}
}
