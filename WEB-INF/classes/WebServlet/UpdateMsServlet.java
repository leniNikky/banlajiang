package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import domain.user;


@WebServlet("/UpdateMessage")
public class UpdateMsServlet extends HttpServlet {
	/*public static void main(String[] args) {
		userDao userDao=new userDao();
		user user= new user();
		String userName = "娴嬭瘯";
		String phone="654321";
		String email="123@qq.com";
			user.setUserName(userName);
			user.setEmail(email);
			user.setPhone(phone);
			int u=userDao.updateUser(user);
			System.out.println(u);
}*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userDao userDao=new userDao();
		user user= new user();
		String userName = new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		String userPassword=request.getParameter("userPassword");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
			user.setUserName(userName);
			user.setEmail(email);
			user.setPhone(phone);
			int u=userDao.updateUser(user);
			if(u>0){
				request.setAttribute("message", "修改成功！");
				user us=userDao.login(userName, userPassword);
				request.getSession().setAttribute("user", us);
				request.getRequestDispatcher("/zweb/message.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "修改失败！");
				request.getRequestDispatcher("/zweb/message.jsp").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
