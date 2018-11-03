package AdminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import domain.user;

public class Editroot extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao u = new userDao();
		int userID = Integer.parseInt(request.getParameter("userID"));
		int userroot = Integer.parseInt(request.getParameter("userroot"));
		int a = u.updateRoot(userroot, userID);
		System.out.print(a);
		if(a>0){
			request.setAttribute("root", "修改成功！");
			request.getRequestDispatcher("/zadmin/root.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("root", "修改失败！");
			request.getRequestDispatcher("/zadmin/root.jsp").forward(request, response);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
