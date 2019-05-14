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

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		String zipCode = req.getParameter( "zipCode" );
		String cnae = req.getParameter( "cnae" );
		String password = req.getParameter( "password" );
		
		UserDAO udao = UserDAOImplementation.getInstance();
		User user = udao.read( email );
		BusinessDAO bdao = BusinessDAOImplementation.getInstance();
		Business business = bdao.read(user.getBusiness().getMerchant());
		business.setZipCode(zipCode);
		business.setCnae(cnae);
		
		user.setPassword( new Sha256Hash( password ).toString() );
		
		bdao.update(business);
		user.setBusiness(business);
		udao.update(user);
		
		resp.sendRedirect( req.getContextPath() + "/ProfileServlet?email=" + email);
	}
}
