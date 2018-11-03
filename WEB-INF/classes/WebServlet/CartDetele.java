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



public class CartDetele extends HttpServlet {
	/*  public static void main(String[] args) {
		  int shoppingcartID = 2;
			shoppingcartDao d=new shoppingcartDao();
			
			int a=d.deleteGoods(shoppingcartID);
		
	System.out.print(a);
}*/
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int shoppingcartID = Integer.parseInt(new String(request.getParameter("shoppingcartID").getBytes("ISO8859-1"),"UTF-8"));
		int goodsCount = Integer.parseInt(new String(request.getParameter("goodsCount").getBytes("ISO8859-1"),"UTF-8"));
		int goodsID = Integer.parseInt(new String(request.getParameter("goodsID").getBytes("ISO8859-1"),"UTF-8"));
		shoppingcartDao d=new shoppingcartDao();
		goodsDao goodsDao = new goodsDao();
		int a=d.deleteGoods(shoppingcartID);
        int userID = Integer.parseInt(new String(request.getParameter("userID").getBytes("ISO8859-1"),"UTF-8"));
        goods ha=goodsDao.deleteCount(goodsID);
		int c = ha.getGoodsCount()+goodsCount;
		int add = goodsDao.addCount(c, goodsID);
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
