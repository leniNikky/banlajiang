package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.orderdetailDao;
import domain.orderdetail;



public class MyOdetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderdetailDao g = new orderdetailDao();
		String orderNo = new String(request.getParameter("orderNo").getBytes("ISO8859-1"),"UTF-8");
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		String orderstatus = new String(request.getParameter("orderstatus").getBytes("ISO8859-1"),"UTF-8");
		System.out.print(orderstatus);
		Collection<orderdetail> orderdetail = g.getOrderdetail(orderNo);
		request.setAttribute("orderdetail", orderdetail);
		request.setAttribute("orderstatus", orderstatus);
		request.setAttribute("orderID", orderID);
		request.getRequestDispatcher("./myorderdetail.jsp").forward(request,
				response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
