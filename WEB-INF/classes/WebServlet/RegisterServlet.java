package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import dao.userDao;
import domain.goods;
import domain.user;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	/*public static void main(String[] args) {
		user user=new user();
		userDao impl=new userDao();
		String userName = "娴嬭瘯";
		String userPassword = "123456";
		String phone = "123456";
		String email="123@163.com";
			user.setUserName(userName);
	        user.setUserPassword(userPassword);
	        user.setPhone(phone);
	        user.setEmail(email);
		boolean b=impl.insertUser(user);
		System.out.println(b);
}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		user user=new user();
		userDao impl=new userDao();
		String userName = new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		String userPassword = request.getParameter("userPassword");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		int u = impl.check(userName);
		if(u==0) {
			user.setUserName(userName);
	        user.setUserPassword(userPassword);
	        user.setPhone(phone);
	        user.setEmail(email);
	        System.out.print(userName);
	        
		boolean b=impl.insertUser(user);
		if(b){
			
			request.setAttribute("message", "注册成功！");
			request.getRequestDispatcher("/zweb/registersf.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "注册失败！");
			request.getRequestDispatcher("/zweb/registersf.jsp").forward(request, response);
			
	}
		}else {
			request.setAttribute("message", "该用户名已存在，请重新注册！");
			request.getRequestDispatcher("/zweb/registersf.jsp").forward(request, response);
		}
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
