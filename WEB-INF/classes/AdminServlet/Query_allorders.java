package AdminServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.orderDao;
import domain.orders;



public class Query_allorders extends HttpServlet {
	/*public static void main(String[] args) {
		orderDao g = new orderDao();
		Collection<orders> orders = g.allOrder();
		
		System.out.println(orders);
	}
       */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDao g = new orderDao();
		Collection<orders> orders = g.allOrder();
		request.setAttribute("orders", orders);
		System.out.println(orders);
		request.getRequestDispatcher("/zadmin/order_list.jsp").forward(request,
				response);
		//response.sendRedirect("/banlajiang/zadmin/order_list.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
