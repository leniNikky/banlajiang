package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.orderDao;
import domain.orders;





public class Addorder extends HttpServlet {
	/*public static void main(String[] args) {
	orders order=new orders();
		orderDao impl=new orderDao();
		String consignName = "浣犲ソ";
		String consigneeAddress = "hhhh";
		String consigneePhone = "123";
		int userID = 2;
		int orderdetailID = 1;
		order.setConsignName(consignName);
		order.setConsigneeAddress(consigneeAddress);
		order.setConsigneePhone(consigneePhone);
		order.setUserID(userID);
		order.setOrderdetailID(orderdetailID);    
		boolean b=impl.insertorder(order);
	    System.out.println(b);
}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orders order=new orders();
		orderDao impl=new orderDao();
		String consignName = new String(request.getParameter("consignName").getBytes("ISO8859-1"),"UTF-8");
		String consigneeAddress = new String(request.getParameter("consignAddress").getBytes("ISO8859-1"),"UTF-8");
		String consigneePhone = new String(request.getParameter("consignPhone").getBytes("ISO8859-1"),"UTF-8");
		int userID = Integer.parseInt(request.getParameter("userID"));
		float totalprice = Float.parseFloat(request.getParameter("totalprice"));
		String orderNo = new String(request.getParameter("orderNo").getBytes("ISO8859-1"),"UTF-8");
		order.setConsignName(consignName);
		order.setConsigneeAddress(consigneeAddress);
		order.setConsigneePhone(consigneePhone);
		order.setUserID(userID);
		order.setOrderNo(orderNo);
		order.setTotalprice(totalprice);
	        System.out.print(consignName);
	        
		boolean b=impl.insertorder(order);
		if(b){
			
			request.setAttribute("message", "下单成功！");
			request.getRequestDispatcher("/zweb/message.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/zweb/consign.jsp").forward(request, response);
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
