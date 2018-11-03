package AdminServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import domain.goods;
import domain.user;


public class FindUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao g = new userDao();
		String userName = new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		Collection<user> users = g.findUsers(userName);
		request.setAttribute("users", users);
		/*request.getRequestDispatcher("/zadmin/user_list.jsp").forward(request,
				response);*/
		response.sendRedirect("/banlajiang/zadmin/user_list.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
