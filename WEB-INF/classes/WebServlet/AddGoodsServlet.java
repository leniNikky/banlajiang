package WebServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import dao.shoppingcartDao;
import dao.userDao;
import domain.goods;
import domain.shoppingcart;
import domain.user;



public class AddGoodsServlet extends HttpServlet {
	/*public static void main(String[] args) {
	shoppingcart shoppingcart=new shoppingcart();
		shoppingcartDao impl=new shoppingcartDao();
		int userID = 2;
		int goodID = 2;
		String goodsName = ";123";
		String goodsImg = "123";
		String gclass = "香辣";
		float goodsPrice=12.8f;
		int  goodsCount=2;
		shoppingcart.setUserID(userID);
		shoppingcart.setGoodsID(goodID);
		shoppingcart.setGoodsName(goodsName);
		shoppingcart.setGoodsPrice(goodsPrice);
		shoppingcart.setGoodsCount(goodsCount);
		shoppingcart.setGoodsImg(goodsImg);
		shoppingcart.setGclass(gclass);
	     
	        
		boolean b=impl.addGoods(shoppingcart);
	System.out.println(b);
}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		shoppingcart shoppingcart=new shoppingcart();
		shoppingcartDao impl=new shoppingcartDao();
		goodsDao goodsDao = new goodsDao();
		int userID = Integer.parseInt(request.getParameter("userID"));
		int goodID = Integer.parseInt(request.getParameter("goodsID"));
		String goodsName = new String(request.getParameter("goodsName").getBytes("ISO8859-1"),"UTF-8");
		String goodsImg = new String(request.getParameter("goodsimg").getBytes("ISO8859-1"),"UTF-8");
		String gclass = new String(request.getParameter("gclass").getBytes("ISO8859-1"),"UTF-8");
		float goodsPrice=Float.parseFloat(request.getParameter("goodsPrice"));
		int  goodsCount=Integer.parseInt(request.getParameter("goodsCount"));
		
		shoppingcart.setUserID(userID);
		shoppingcart.setGoodsID(goodID);
		shoppingcart.setGoodsName(goodsName);
		shoppingcart.setGoodsPrice(goodsPrice);
		shoppingcart.setGoodsCount(goodsCount);
		shoppingcart.setGclass(gclass);
		shoppingcart.setGoodsImg(goodsImg);
	       
	        
		boolean b=impl.addGoods(shoppingcart);
		if(b){
			goods ha=goodsDao.deleteCount(goodID);
			int c = ha.getGoodsCount()-goodsCount;
			int a = goodsDao.addCount(c, goodID);
			if(a==1) {
			request.getRequestDispatcher("/zweb/index.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("/zweb/index.jsp").forward(request, response);
			
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
