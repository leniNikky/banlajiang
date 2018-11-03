package WebServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.orderDao;
import domain.comments;
import domain.orders;


@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	/*public static void main(String[] args) {
	comments comment=new comments();
		CommentDao impl=new CommentDao();
		int userID = 2;
		String orderNo = "hhhh";
		String content = "123";
		comment.setUserID(userID);
		comment.setOrderNo(orderNo);  
		comment.setContent(content);
		boolean b=impl.insertComment(comment);
	    System.out.println(b);
}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		comments comment=new comments();
		CommentDao impl=new CommentDao();
		orderDao o = new orderDao();
		int userID = Integer.parseInt(request.getParameter("userID"));
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		System.out.println(orderID+12);
		orders order = o.orderDetails(orderID);
		
		String orderNo = order.getOrderNo();
		String userName = new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		String content = new String(request.getParameter("content").getBytes("ISO8859-1"),"UTF-8");
		comment.setUserID(userID);
		comment.setUserName(userName);
		comment.setOrderID(orderID);
		comment.setOrderNo(orderNo);  
		comment.setContent(content);
		boolean b=impl.insertComment(comment);
	    System.out.println(b);
	    if(b) {
	    	request.setAttribute("message", "评论发表成功！");
			request.getRequestDispatcher("/zweb/message.jsp").forward(request, response);
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
