package WebServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.orderDao;


public class UpdateStatus extends HttpServlet {
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		orderDao o = new orderDao();
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		String orderstatus = "已收货";
		System.out.print(orderID);
	    int a = o.updateStatus(orderID, orderstatus);
	    if(a==1) {
	    	request.setAttribute("message", "您已确认收货！");
	    	request.getRequestDispatcher("/zweb/message.jsp").forward(request, response);
	    }
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
