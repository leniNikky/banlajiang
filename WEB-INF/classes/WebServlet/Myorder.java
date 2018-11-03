package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import dao.orderDao;
import dao.orderdetailDao;
import domain.orders;



public class Myorder extends HttpServlet {
	/* public static void main(String[] args) {
	orderDao g = new orderDao();
		int userID = 2;
		Collection<orders> orders = g.getOrders(userID);
	System.out.print(orders);
}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDao g = new orderDao();
		int userID = Integer.parseInt(request.getParameter("userID"));
		Collection<orders> orders = g.getOrders(userID);
		System.out.print(orders);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/zweb/myorder.jsp").forward(request,
				response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
