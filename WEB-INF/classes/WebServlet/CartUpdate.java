package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.shoppingcartDao;
import domain.shoppingcart;


public class CartUpdate extends HttpServlet {
	/*public static void main(String[] args) {
	int shoppingcartID = 0;
	int goodsCount = 3;
	float goodsPrice = 11.9f;
	shoppingcartDao d=new shoppingcartDao();
	int a=d.updateCart(goodsCount,goodsPrice,shoppingcartID);
    System.out.print(a);
}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int shoppingcartID = Integer.parseInt(new String(request.getParameter("shoppingcartID").getBytes("ISO8859-1"),"UTF-8"));
		int goodsCount = Integer.parseInt(new String(request.getParameter("goodsCount").getBytes("ISO8859-1"),"UTF-8"));
		float goodsPrice = Float.parseFloat(new String(request.getParameter("goodsCount").getBytes("ISO8859-1"),"UTF-8"));
		shoppingcartDao d=new shoppingcartDao();
		System.out.println(shoppingcartID+","+goodsCount+","+goodsPrice);
		int a=d.updateCart(goodsCount,goodsPrice,shoppingcartID);
        int userID = Integer.parseInt(new String(request.getParameter("userID").getBytes("ISO8859-1"),"UTF-8"));
		
		Collection<shoppingcart> carts = d.getCarts(userID);
		System.out.print(shoppingcartID+userID);
		request.setAttribute("carts", carts);
		request.getRequestDispatcher("/zweb/carts.jsp").forward(request,
				response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
