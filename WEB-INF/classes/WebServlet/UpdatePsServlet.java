package WebServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import domain.user;


@WebServlet("/UpdatePassword")
public class UpdatePsServlet extends HttpServlet {
	/*public static void main(String[] args) {
		userDao u = new userDao();
		String userName = "娴嬭瘯";
		String oldpass = "123456";
		String newpass = "654321";
		int a = u.updatePass(userName, oldpass, newpass);
		System.out.print(a);
}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		userDao u = new userDao();
		String userName = new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		String oldpass = request.getParameter("oldpw");
		String newpass = request.getParameter("newpw");
		
		int a = u.updatePass(userName, oldpass, newpass);
		System.out.print(a);
		if(a>0){
			request.setAttribute("message", "修改成功！");
			user user=u.login(userName, newpass);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/zweb/message.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("message", "修改失败！");
			request.getRequestDispatcher("/zweb/message.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
	}

}
