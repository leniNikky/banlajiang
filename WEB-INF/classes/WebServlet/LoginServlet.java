package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.orderDao;
import dao.userDao;
import domain.orders;
import domain.user;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	/*public static void main(String[] args) {
		userDao userDao=new userDao();
		String userName = "æµ‹è¯•";
		String userPassword = "123456";
		        user user=userDao.login(userName, userPassword);
	System.out.println(user.getEmail());
}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userDao userDao=new userDao();
		String userName = new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		String userPassword=request.getParameter("userPassword");
		        user user=userDao.login(userName, userPassword);
		        System.out.print(userName+userPassword);
		       		if(user==null) {
		       			request.setAttribute("message", "µÇÂ¼Ê§°Ü£¬ÇëÖØÐÂµÇÂ¼");
		       			request.getRequestDispatcher("./registerandlogin.jsp").forward(request, response);
		       		}
		       		else{
		       			request.getSession().setAttribute("user", user);
		       			request.getSession().setAttribute("userout", "ÍË³ö");
		       			request.setAttribute("usermain", "ÎÒµÄÖ÷Ò³");
		       			request.getRequestDispatcher("./index.jsp").forward(request, response);
		       		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
