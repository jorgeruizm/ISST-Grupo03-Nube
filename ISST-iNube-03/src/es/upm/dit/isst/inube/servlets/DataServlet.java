package es.upm.dit.isst.inube.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.upm.dit.isst.inube.dao.TPVDAO;
import es.upm.dit.isst.inube.dao.TPVDAOImplementation;
import es.upm.dit.isst.inube.dao.TransactionDAO;
import es.upm.dit.isst.inube.dao.TransactionDAOImplementation;
import es.upm.dit.isst.inube.model.TPV;
import es.upm.dit.isst.inube.model.Transaction;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JSONObject response = new JSONObject();
		if (req.getParameter("type").equals("dia")) {
			double ingresos[] = new double[31];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				for (int j=1; j<32; j++) {
					if(Integer.parseInt(transactions.get(i).getDay()) == j) {
						ingresos[j-1] += transactions.get(i).getAmount();
						continue;
					}
				}
			}
			
			for (int k=0; k<ingresos.length; k++) {
				response.put(Integer.toString(k+1), ingresos[k]);
			}
		} 
		
		if (req.getParameter("type").equals("mes")) {
			double ingresosMensuales[] = new double[12];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				for (int j=1; j<13; j++) {
					if(Integer.parseInt(transactions.get(i).getMonth()) == j) {
						ingresosMensuales[j-1] += transactions.get(i).getAmount();
						continue;
					}
				}
			}
			
			for (int k=0; k<ingresosMensuales.length; k++) {
				response.put(Integer.toString(k+1), ingresosMensuales[k]);
			}
		} 
		
		if (req.getParameter("type").equals("transmes")) {
			int transaccionesMensuales[] = new int[12];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				for (int j=1; j<13; j++) {
					if(Integer.parseInt(transactions.get(i).getMonth()) == j) {
						++transaccionesMensuales[j-1];
						continue;
					}
				}
			}
			
			for (int k=0; k<transaccionesMensuales.length; k++) {
				response.put(Integer.toString(k+1), transaccionesMensuales[k]);
			}
		} 
		if (req.getParameter("type").equals("edad")) {
			int clientes[] = new int[53];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				for (int j=18; j<71; j++) {
					if(Integer.parseInt(transactions.get(i).getAge()) == j) {
						++clientes[j-18];
						continue;
					}
				}
			}
			
			for (int k=0; k<clientes.length; k++) {
				response.put(Integer.toString(k+18), clientes[k]);
			}
		} 
		
		if (req.getParameter("type").equals("zipcode")) {
			int cont1= 0;
			int cont2= 0;
			int cont3= 0;
			int cont4= 0;
			int cont5= 0;
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				switch(transactions.get(i).getZipCode()){
					case "28030":
						cont1++;
						break;
					case "28040":
						cont2++;
						break;
					case "28080":
						cont3++;
						break;
					case "28100":
						cont4++;
						break;
					case "28230":
						cont5++;
						break;
					default: 
						break;
				}
			}
			response.put("28030", cont1);
			response.put("28040", cont2);
			response.put("28080", cont3);
			response.put("28100", cont4);
			response.put("28230", cont5);
		} 
		
		if (req.getParameter("type").equals("genero")) {
			int cont1= 0;
			int cont2= 0;
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				switch(transactions.get(i).getSex()){
					case "hombre":
						cont1++;
						break;
					case "mujer":
						cont2++;
						break;
					default: 
						break;
				}
			}
			response.put("hombre", cont1);
			response.put("mujer", cont2);
		} 
		
		if (req.getParameter("type").equals("fidelidad")) {
			double clientes[] = new double[60];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				for (int j=1; j<61; j++) {
					if(transactions.get(i).getClient() == j) {
						clientes[j-1]++;
						continue;
					}
				}
			}
			
			for (int k=0; k<clientes.length; k++) {
//				String s = "Cliente " + Integer.toString(k+1);
				response.put(Integer.toString(k+1), clientes[k]);
			}
		} 
		
		
		if (req.getParameter("type").equals("hora")) {
			double ingresosHora[] = new double[11];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions = tpv.getTransactions();
			
			for(int i=0; i<transactions.size(); i++) {
				for (int j=10; j<21; j++) {
					if(Integer.parseInt(transactions.get(i).getTime()) == j) {
						ingresosHora[j-10] += transactions.get(i).getAmount();
						continue;
					}
				}
			}
			
			for (int k=0; k<ingresosHora.length; k++) {
//				String s = Integer.toString(k+10) + ":00";
				response.put(Integer.toString(k+10), ingresosHora[k]);
			}
		} 

		resp.getWriter().write(response.toString());
	}
	
}
