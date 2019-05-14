package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.inube.dao.BusinessDAO;
import es.upm.dit.isst.inube.dao.BusinessDAOImplementation;
import es.upm.dit.isst.inube.dao.UserDAO;
import es.upm.dit.isst.inube.dao.UserDAOImplementation;
import es.upm.dit.isst.inube.model.Business;
import es.upm.dit.isst.inube.model.User;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter( "name" );
		String merchant = req.getParameter( "merchant" );
		String zipCode = req.getParameter( "zipCode" );
		String cnae = req.getParameter( "cnae" );
		String email = req.getParameter( "email" );
		String password = req.getParameter( "password" );
		
		User user = new User();
		
		Business business = new Business();
		user.setEmail( email );
		user.setPassword( new Sha256Hash( password ).toString() );
		user.setName( name );
		
		business.setMerchant(merchant);
		business.setZipCode(zipCode);
		business.setCnae(cnae);
		
		user.setBusiness(business);

		business.setUser(user);
		
		UserDAO udao = UserDAOImplementation.getInstance();
		udao.create( user );
		BusinessDAO bdao = BusinessDAOImplementation.getInstance();
		bdao.create( business );
		
		resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
	}


}
