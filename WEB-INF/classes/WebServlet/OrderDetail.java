package WebServlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.consignDao;
import dao.goodsDao;
import dao.orderDao;
import dao.orderdetailDao;
import dao.shoppingcartDao;
import dao.userDao;
import domain.orders;
import domain.consign;
import domain.goods;
import domain.orderdetail;
import domain.shoppingcart;
import domain.user;

public class OrderDetail extends HttpServlet {
	/*public static void main(String[] args) {
		orderdetail orderdetail=new orderdetail();
		orderdetailDao impl=new orderdetailDao();
		String goodsmg = "123";
		int userID = 1;
		int gtotalCount = 1;
		float gtotalPrice = 2.3f;
		orderdetail.setGoodsmg(goodsmg);
		orderdetail.setUserID(userID);
		orderdetail.setGtotalCount(gtotalCount);
		orderdetail.setGtotalPrice(gtotalPrice);
	       
	        
		boolean b=impl.addOrderDetail(orderdetail);
		    System.out.println(b);
	}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //
		Date time = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String current = sdf.format(time);
		String str =request.getParameter("apiContentStr");
		System.out.println(str);
        String[] temp;
        String delimeter = ",";
        temp = str.split(delimeter);
        int[] a=new int[temp.length];
        for(int i=0;i<temp.length;i++){
        a[i]=Integer.parseInt(temp[i]); 
      
        }
        float totalPrice=0;
        for(int i=0;i<a.length;i++) {
        	int shoppingcartID = a[i];
        	
        	shoppingcartDao g = new shoppingcartDao();	
    		shoppingcart sc = g.shopcart(shoppingcartID);
    		String orderNo = sc.getUserID()+","+current;
    		orderdetail orderdetail = new orderdetail();
    		orderdetailDao orderdetailDao = new orderdetailDao();
    		orderdetail.setUserID(sc.getUserID());
    		orderdetail.setOrderNo(orderNo);
    		orderdetail.setGoodsID(sc.getGoodsID());
    		orderdetail.setGoodsName(sc.getGoodsName());
    		orderdetail.setGoodsImg(sc.getGoodsImg());
    		orderdetail.setGclass(sc.getGclass());
    		orderdetail.setGoodsPrice(sc.getGoodsPrice());
    		orderdetail.setGtotalPrice(sc.getGtotalPrice());
    		orderdetail.setGoodsCount(sc.getGoodsCount());
    		boolean b=orderdetailDao.addOrderDetail(orderdetail);
    		totalPrice = totalPrice + sc.getGtotalPrice();
    		System.out.println(b);
    		if(b) {
    			int dcart=g.deleteGoods(shoppingcartID);
    			Collection<shoppingcart> carts = g.getCarts(sc.getUserID());
    			/*System.out.print(dcart);*/
    			request.setAttribute("carts", carts);
    			request.setAttribute("orderNo", orderNo);
    			consignDao consignDao= new consignDao();
    			consign consign = consignDao.findconsign(sc.getUserID());
    			request.setAttribute("consign", consign);
    		}
        }
        System.out.println(totalPrice);
        request.setAttribute("totalprice", totalPrice);
        request.getRequestDispatcher("consignee.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
