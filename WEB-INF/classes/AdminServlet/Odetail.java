package AdminServlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.consignDao;
import dao.orderdetailDao;
import dao.shoppingcartDao;
import domain.consign;
import domain.orderdetail;
import domain.shoppingcart;


public class Odetail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderdetailDao g = new orderdetailDao();
		String orderNo = new String(request.getParameter("orderNo").getBytes("ISO8859-1"),"UTF-8");
		Collection<orderdetail> orderdetail = g.getOrderdetail(orderNo);
		
		request.setAttribute("orderdetail", orderdetail);
		request.getRequestDispatcher("./order_detail.jsp").forward(request,
				response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
