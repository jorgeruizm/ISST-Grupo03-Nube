package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.inube.dao.UserDAO;
import es.upm.dit.isst.inube.dao.UserDAOImplementation;

@WebServlet({ "/LoginServlet", "/" })
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO udao = UserDAOImplementation.getInstance();
		//udao.read( null );
		getServletContext().getRequestDispatcher( "/LoginView.jsp" ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		String pass = req.getParameter( "password" );
		Subject currentUser = SecurityUtils.getSubject();
		if ( !currentUser.isAuthenticated() ) {
			UsernamePasswordToken token = new UsernamePasswordToken( email, pass );
			try {
				currentUser.login( token );
				if ( currentUser.hasRole( "admin" ) )
					resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
				else if ( currentUser.hasRole( "premium" ) )
					resp.sendRedirect( req.getContextPath() + "/PremiumServlet?email=" + currentUser.getPrincipal() );
				else if ( currentUser.hasRole( "basic" ) )
					resp.sendRedirect( req.getContextPath() + "/BasicServlet?email=" + currentUser.getPrincipal() );
			} catch ( Exception e ) {
				e.printStackTrace();
				System.out.println("error");
				resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
			}
		} else
			resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
	}
}
