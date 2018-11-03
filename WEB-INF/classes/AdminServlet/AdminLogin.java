package AdminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import domain.user;


public class AdminLogin extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao userDao=new userDao();
		String userName = new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		String userPassword=request.getParameter("userPassword");
		        user user=userDao.login(userName, userPassword);
		        System.out.print(user.getUserroot());
		       
		       		if(user.getUserroot()==0||user == null) {
		       			
		       			request.setAttribute("faillogin", "你没有管理员权限");
		       			request.getRequestDispatcher("/zadmin/faillogin.jsp").forward(request, response);
		       		}
		       		else {
		       			request.setAttribute("haha", "12121");
		       			request.getSession().setAttribute("admin", user);
		       			request.getSession().setAttribute("adminout", "退出");
		       			request.getRequestDispatcher("/zadmin/adminIndex.jsp").forward(request, response);
		       			//response.sendRedirect("http://47.106.149.153:8080/banlajiang/zadmin/adminIndex.jsp");
		       			//request.getRequestDispatcher("/zadmin/adminIndex.jsp").forward(request, response);
		       		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
