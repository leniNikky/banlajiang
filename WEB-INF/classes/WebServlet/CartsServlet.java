package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import dao.shoppingcartDao;
import domain.goods;
import domain.shoppingcart;


@WebServlet("/Carts")
public class CartsServlet extends HttpServlet {
	 /* public static void main(String[] args) {
	 shoppingcartDao s = new shoppingcartDao();
		int userID =2;
		Collection<shoppingcart> carts = s.getCarts(userID);
		
	System.out.print(carts);
}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		shoppingcartDao s = new shoppingcartDao();
		int userID = Integer.parseInt(new String(request.getParameter("userID").getBytes("ISO8859-1"),"UTF-8"));
		
		Collection<shoppingcart> carts = s.getCarts(userID);
		/*System.out.print(carts);*/
		request.setAttribute("carts", carts);
		request.getRequestDispatcher("/zweb/carts.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
