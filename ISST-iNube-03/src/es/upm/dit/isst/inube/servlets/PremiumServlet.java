package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inube.dao.TransactionDAO;
import es.upm.dit.isst.inube.dao.TransactionDAOImplementation;
import es.upm.dit.isst.inube.dao.UserDAO;
import es.upm.dit.isst.inube.dao.UserDAOImplementation;
import es.upm.dit.isst.inube.model.Transaction;
import es.upm.dit.isst.inube.model.User;
import es.upm.dit.isst.inube.rest.Database;

@WebServlet("/PremiumServlet")
public class PremiumServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		
		UserDAO udao = UserDAOImplementation.getInstance();
		User user = udao.read( email );
		
		Database.loadAll();
		
//		TransactionDAO tdao = TransactionDAOImplementation.getInstance();
//		List<Transaction> transactions = tdao.readAll();
//		System.out.println("Factura: " + transactions.get(0).getInvoice() + "\n" +
//						   "Edad: " + transactions.get(0).getAge() + "\n" +
//						   "Importe: " + transactions.get(0).getAmount() + "\n" + 
//						   "Cliente: " + transactions.get(0).getClient() + "\n" + 
//						   "Fecha: " + transactions.get(0).getDate());
		req.getSession().setAttribute("user", user);
		getServletContext().getRequestDispatcher("/ComparativeView.jsp").forward(req, resp);
	}
}
