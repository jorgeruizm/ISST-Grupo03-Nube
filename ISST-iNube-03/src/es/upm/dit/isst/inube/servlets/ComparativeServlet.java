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
@WebServlet("/ComparativeServlet")
public class ComparativeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		JSONObject response = new JSONObject();
		if (req.getParameter("type").equals("dia")) {
			double ingresos1[] = new double[31];
			double ingresos2[] = new double[31];
			double ingresos3[] = new double[31];
			double ingresos4[] = new double[31];
			double ingresos5[] = new double[31];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv0 = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions0 = tpv0.getTransactions();
			TPV tpv1 = tpdao.read(1);
			List<Transaction> transactions1 = tpv1.getTransactions();
			TPV tpv2 = tpdao.read(2);
			List<Transaction> transactions2 = tpv2.getTransactions();
			TPV tpv3 = tpdao.read(3);
			List<Transaction> transactions3 = tpv3.getTransactions();
			TPV tpv4 = tpdao.read(4);
			List<Transaction> transactions4 = tpv4.getTransactions();
			TPV tpv5 = tpdao.read(5);
			List<Transaction> transactions5 = tpv5.getTransactions();
			
			switch(tpv0.getId()) {
				case 1:
					for(int i=0; i<transactions0.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions0.get(i).getDay()) == j) {
								ingresos1[j-1] += transactions0.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions2.get(i).getDay()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions3.get(i).getDay()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions4.get(i).getDay()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions5.get(i).getDay()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 2:
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions2.get(i).getDay()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions1.get(i).getDay()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions3.get(i).getDay()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions4.get(i).getDay()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions5.get(i).getDay()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 3:
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions3.get(i).getDay()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions1.get(i).getDay()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions2.get(i).getDay()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions4.get(i).getDay()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions5.get(i).getDay()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 4:
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions4.get(i).getDay()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions1.get(i).getDay()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions2.get(i).getDay()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions4.get(i).getDay()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions5.get(i).getDay()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 5:
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions5.get(i).getDay()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions1.get(i).getDay()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions2.get(i).getDay()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions3.get(i).getDay()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<32; j++) {
							if(Integer.parseInt(transactions4.get(i).getDay()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos5[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos4[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				default:
					break;
			}
		} 
		
		if (req.getParameter("type").equals("mes")) {
			double ingresos1[] = new double[12];
			double ingresos2[] = new double[12];
			double ingresos3[] = new double[12];
			double ingresos4[] = new double[12];
			double ingresos5[] = new double[12];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv0 = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions0 = tpv0.getTransactions();
			TPV tpv1 = tpdao.read(1);
			List<Transaction> transactions1 = tpv1.getTransactions();
			TPV tpv2 = tpdao.read(2);
			List<Transaction> transactions2 = tpv2.getTransactions();
			TPV tpv3 = tpdao.read(3);
			List<Transaction> transactions3 = tpv3.getTransactions();
			TPV tpv4 = tpdao.read(4);
			List<Transaction> transactions4 = tpv4.getTransactions();
			TPV tpv5 = tpdao.read(5);
			List<Transaction> transactions5 = tpv5.getTransactions();
			
			switch(tpv0.getId()) {
				case 1:
					for(int i=0; i<transactions0.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions0.get(i).getMonth()) == j) {
								ingresos1[j-1] += transactions0.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 2:
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 3:
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 4:
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos4[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos5[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				case 5:
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								ingresos5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								ingresos1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								ingresos2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								ingresos3[j-1] += transactions3.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								ingresos4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<ingresos1.length; k++) {
						List<Double> ingresos = new ArrayList<Double>();
						ingresos.add(ingresos5[k]);
						ingresos.add(ingresos1[k]);
						ingresos.add(ingresos2[k]);
						ingresos.add(ingresos3[k]);
						ingresos.add(ingresos4[k]);
						response.put(Integer.toString(k+1), ingresos);
					}
					break;
				default:
					break;
			}
		} 
		
		if (req.getParameter("type").equals("transacciones")) {
			double transacciones1[] = new double[12];
			double transacciones2[] = new double[12];
			double transacciones3[] = new double[12];
			double transacciones4[] = new double[12];
			double transacciones5[] = new double[12];
			double transaccionesMedia[] = new double[12];
			
			TPVDAO tpdao = TPVDAOImplementation.getInstance();
			TPV tpv0 = tpdao.read(Integer.parseInt(req.getParameter("tpv")));
			List<Transaction> transactions0 = tpv0.getTransactions();
			TPV tpv1 = tpdao.read(1);
			List<Transaction> transactions1 = tpv1.getTransactions();
			TPV tpv2 = tpdao.read(2);
			List<Transaction> transactions2 = tpv2.getTransactions();
			TPV tpv3 = tpdao.read(3);
			List<Transaction> transactions3 = tpv3.getTransactions();
			TPV tpv4 = tpdao.read(4);
			List<Transaction> transactions4 = tpv4.getTransactions();
			TPV tpv5 = tpdao.read(5);
			List<Transaction> transactions5 = tpv5.getTransactions();
			
			switch(tpv0.getId()) {
				case 1:
					for(int i=0; i<transactions0.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions0.get(i).getMonth()) == j) {
								transacciones1[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								transacciones2[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								transacciones3[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								transacciones4[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								transacciones5[j-1]++;
								continue;
							}
						}
					}
					
					
					for (int k=0; k<transacciones1.length; k++) {
						List<Double> transacciones = new ArrayList<Double>();
						transaccionesMedia[k] = (transacciones2[k]+transacciones3[k]+transacciones4[k]+transacciones5[k])/4;
						transacciones.add(transacciones1[k]);
						transacciones.add(transacciones2[k]);
						transacciones.add(transacciones3[k]);
						transacciones.add(transacciones4[k]);
						transacciones.add(transacciones5[k]);
						transacciones.add(transaccionesMedia[k]);
						System.out.println(transaccionesMedia[k]);
						response.put(Integer.toString(k+1), transacciones);
					}
					break;
				case 2:
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								transacciones2[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								transacciones1[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								transacciones3[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								transacciones4[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								transacciones5[j-1]++;
								continue;
							}
						}
					}
					
					
					for (int k=0; k<transacciones2.length; k++) {
						List<Double> transacciones = new ArrayList<Double>();
						transaccionesMedia[k] = (transacciones2[k]+transacciones3[k]+transacciones4[k]+transacciones5[k])/4;
						transacciones.add(transacciones2[k]);
						transacciones.add(transacciones1[k]);
						transacciones.add(transacciones3[k]);
						transacciones.add(transacciones4[k]);
						transacciones.add(transacciones5[k]);
						transacciones.add(transaccionesMedia[k]);
						System.out.println(transaccionesMedia[k]);
						response.put(Integer.toString(k+1), transacciones);
					}
					break;
				case 3:
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								transacciones3[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								transacciones1[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								transacciones2[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								transacciones4[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								transacciones5[j-1]++;
								continue;
							}
						}
					}
					
					
					for (int k=0; k<transacciones3.length; k++) {
						List<Double> transacciones = new ArrayList<Double>();
						transaccionesMedia[k] = (transacciones2[k]+transacciones1[k]+transacciones4[k]+transacciones5[k])/4;
						transacciones.add(transacciones3[k]);
						transacciones.add(transacciones1[k]);
						transacciones.add(transacciones2[k]);
						transacciones.add(transacciones4[k]);
						transacciones.add(transacciones5[k]);
						transacciones.add(transaccionesMedia[k]);
						System.out.println(transaccionesMedia[k]);
						response.put(Integer.toString(k+1), transacciones);
					}
					break;
				case 4:
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								transacciones4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								transacciones1[j-1] += transactions1.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								transacciones2[j-1] += transactions2.get(i).getAmount();
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								transacciones4[j-1] += transactions4.get(i).getAmount();
								continue;
							}
						}
					}
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								transacciones5[j-1] += transactions5.get(i).getAmount();
								continue;
							}
						}
					}
					
					
					for (int k=0; k<transacciones4.length; k++) {
						List<Double> transacciones = new ArrayList<Double>();
						transaccionesMedia[k] = (transacciones2[k]+transacciones3[k]+transacciones1[k]+transacciones5[k])/4;
						transacciones.add(transacciones4[k]);
						transacciones.add(transacciones1[k]);
						transacciones.add(transacciones2[k]);
						transacciones.add(transacciones3[k]);
						transacciones.add(transacciones5[k]);
						transacciones.add(transaccionesMedia[k]);
						System.out.println(transaccionesMedia[k]);
						response.put(Integer.toString(k+1), transacciones);
					}
					break;
				case 5:
					for(int i=0; i<transactions5.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions5.get(i).getMonth()) == j) {
								transacciones5[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions1.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions1.get(i).getMonth()) == j) {
								transacciones1[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions2.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions2.get(i).getMonth()) == j) {
								transacciones2[j-1]++;
								continue;
							}
						}
					}
					
					for(int i=0; i<transactions3.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions3.get(i).getMonth()) == j) {
								transacciones3[j-1]++;
								continue;
							}
						}
					}
					for(int i=0; i<transactions4.size(); i++) {
						for (int j=1; j<13; j++) {
							if(Integer.parseInt(transactions4.get(i).getMonth()) == j) {
								transacciones4[j-1]++;
								continue;
							}
						}
					}
					
					
					for (int k=0; k<transacciones5.length; k++) {
						List<Double> transacciones = new ArrayList<Double>();
						transaccionesMedia[k] = (transacciones2[k]+transacciones3[k]+transacciones4[k]+transacciones1[k])/4;
						transacciones.add(transacciones5[k]);
						transacciones.add(transacciones1[k]);
						transacciones.add(transacciones2[k]);
						transacciones.add(transacciones3[k]);
						transacciones.add(transacciones4[k]);
						transacciones.add(transaccionesMedia[k]);
						System.out.println(transaccionesMedia[k]);
						response.put(Integer.toString(k+1), transacciones);
					}
					break;
				default:
					break;
			}
		} 
			
		
		
		res.getWriter().write(response.toString());
	}
}

