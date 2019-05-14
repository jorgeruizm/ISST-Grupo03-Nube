package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inube.dao.BusinessDAO;
import es.upm.dit.isst.inube.dao.BusinessDAOImplementation;
import es.upm.dit.isst.inube.dao.UserDAO;
import es.upm.dit.isst.inube.dao.UserDAOImplementation;
import es.upm.dit.isst.inube.model.Business;
import es.upm.dit.isst.inube.model.User;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		
		UserDAO udao = UserDAOImplementation.getInstance();
		User user = udao.read( email );
		BusinessDAO bdao = BusinessDAOImplementation.getInstance();
		Business business = bdao.read(user.getNegocio().getMerchant());
		bdao.delete(business);
		udao.delete( user );
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet");
//		getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );
	}
}
