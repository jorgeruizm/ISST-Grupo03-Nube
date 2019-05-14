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

@WebServlet("/ChangeRoleServlet")
public class ChangeRoleServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );

		UserDAO udao = UserDAOImplementation.getInstance();
		User user = udao.read( email );
		System.out.println("1");
		System.out.println(user.getRole());
		if(user.getRole().equals("basic")) {
			System.out.println("2p");
			user.setRole("premium");
		} else {
			System.out.println("2b");
			user.setRole("basic");
		}
		System.out.println("3");
		System.out.println(user.getRole());
		udao.update(user);
			

		resp.sendRedirect( req.getContextPath() + "/AdminServlet");
//		getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );
	}
}
