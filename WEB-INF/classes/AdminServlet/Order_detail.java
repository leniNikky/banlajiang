package AdminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.orderDao;
import domain.orders;


public class Order_detail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDao orderDao = new orderDao();
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		
		orders order = orderDao.orderDetails(orderID);
		
		if(order != null) {
		request.setAttribute("orderd", order);
		request.getRequestDispatcher("Odetail?orderNo="+order.getOrderNo()).forward(request,
				response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
