package AdminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.orderDao;
import domain.orders;

public class Updatestatus extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDao orderDao = new orderDao();
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		String orderstatus = new String(request.getParameter("orderstatus").getBytes("ISO8859-1"),"UTF-8");
	    int a = orderDao.updateStatus(orderID, orderstatus);
	    if(a==1) {
	    	request.setAttribute("upsta", "ÐÞ¸Ä³É¹¦£¡");
	    	request.getRequestDispatcher("/zadmin/upsta.jsp").forward(request, response);
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
