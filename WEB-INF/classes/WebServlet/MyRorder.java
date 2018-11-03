package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.orderDao;
import domain.comments;
import domain.orders;

public class MyRorder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDao o = new orderDao();
		CommentDao c = new CommentDao();
		
		int userID = Integer.parseInt(request.getParameter("userID"));
			Collection<orders> orders = o.getROrders(userID);
			//System.out.print(orders);
			Collection<comments> mycomments = c.myCm(userID);
			System.out.print(mycomments);
			request.setAttribute("orders", orders);
			request.setAttribute("mycomments", mycomments);
			request.getRequestDispatcher("./user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
