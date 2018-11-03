package AdminServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.orderDao;
import domain.goods;
import domain.orders;

public class FindOrder extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDao orderDao = new orderDao();
		String ordermsg =  new String(request.getParameter("ordermsg").getBytes("ISO8859-1"),"UTF-8");
		String msg =  new String(request.getParameter("msg").getBytes("ISO8859-1"),"UTF-8");
		
		Collection<orders> findorders = orderDao.findGoods(ordermsg,msg);
		//request.setAttribute("orders", findorders);
		request.setAttribute("orders", findorders);
		//System.out.println(findorders);
		request.getRequestDispatcher("/zadmin/order_list.jsp").forward(request,
				response);
		//response.sendRedirect("/zadmin/order_list.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
