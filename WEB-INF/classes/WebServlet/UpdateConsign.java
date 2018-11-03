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

public class UpdateConsign extends HttpServlet {
	/*public static void main(String[] args) {
		consignDao c=new consignDao();
		consign consign= new consign();
		String consignName ="12";
		String consignAddress="12";
		String consignPhone="12";
		int userID = 2;
		consign.setUserID(userID);
		consign.setConsignName(consignName);
		consign.setConsignAddress(consignAddress);
		consign.setConsignPhone(consignPhone);
			int u=c.updateConsign(consign);
		System.out.println(u);
}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		consignDao c=new consignDao();
		consign consign= new consign();
		String consignName = new String(request.getParameter("consignName").getBytes("ISO8859-1"),"UTF-8");
		String consignAddress= new String(request.getParameter("consignAddress").getBytes("ISO8859-1"),"UTF-8");
		String consignPhone= new String(request.getParameter("consignPhone").getBytes("ISO8859-1"),"UTF-8");
		String totalprice= new String(request.getParameter("totalprice").getBytes("ISO8859-1"),"UTF-8");
		String orderNo= new String(request.getParameter("orderNo").getBytes("ISO8859-1"),"UTF-8");
		int userID = Integer.parseInt(request.getParameter("userID"));
		
		consign.setUserID(userID);
		consign.setConsignName(consignName);
		consign.setConsignAddress(consignAddress);
		consign.setConsignPhone(consignPhone);
			int u=c.updateConsign(consign);
			if(u>0){
				request.setAttribute("totalprice",totalprice);
				request.setAttribute("orderNo",orderNo);
				request.setAttribute("consign",consign);
				request.getRequestDispatcher("/zweb/consignee.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/zweb/consignee.jsp").forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
