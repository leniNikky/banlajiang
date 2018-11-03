package WebServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.consignDao;
import dao.userDao;
import domain.consign;
import domain.user;

public class AddConsign extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		consign consign=new consign();
		consignDao impl=new consignDao();
		String consignName = new String(request.getParameter("consignName").getBytes("ISO8859-1"),"UTF-8");
		String consignAddress = new String(request.getParameter("consignAddress").getBytes("ISO8859-1"),"UTF-8");
		String consignPhone=new String(request.getParameter("consignPhone").getBytes("ISO8859-1"),"UTF-8");
		String orderNo=new String(request.getParameter("orderNo").getBytes("ISO8859-1"),"UTF-8");
		int userID = Integer.parseInt(request.getParameter("userID"));
		String totalprice= new String(request.getParameter("totalprice").getBytes("ISO8859-1"),"UTF-8");
		consign.setUserID(userID);
		consign.setConsignAddress(consignAddress);
		consign.setConsignName(consignName);
		consign.setConsignPhone(consignPhone);
	        
		boolean b=impl.insertConsign(consign);
		if(b){
			request.setAttribute("consign", consign);
			request.setAttribute("orederNo", orderNo);
			request.setAttribute("totalprice", totalprice);
			request.getRequestDispatcher("UpdateConsign").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
