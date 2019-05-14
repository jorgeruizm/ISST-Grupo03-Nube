package es.upm.dit.isst.inube.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inube.dao.TPVDAO;
import es.upm.dit.isst.inube.dao.TPVDAOImplementation;
import es.upm.dit.isst.inube.model.TPV;

/**
 * Servlet implementation class TableServlet
 */
@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String terminal = req.getParameter("terminal");
		System.out.println(terminal);
		TPVDAO tpdao = TPVDAOImplementation.getInstance();
		TPV tpv = tpdao.read(Integer.parseInt(terminal));
		req.getSession().setAttribute( "terminal", tpv );
		
		getServletContext().getRequestDispatcher( "/TableView.jsp" ).forward( req, resp );
	}

}
