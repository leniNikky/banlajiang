package AdminServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.goodsDao;
import dao.orderDao;
import dao.userDao;
import dao.visitedDao;
import domain.goods;



public class WebData extends HttpServlet {
	  public static void main(String[] args) {
		  orderDao orderDao = new orderDao();
		  float totalp = orderDao.totalP();//交易总金额
		
	System.out.print(totalp);
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	userDao userDao = new userDao();
	int usertotal = userDao.userCount();//用户总数
	orderDao orderDao = new orderDao();
	int ordertotal = orderDao.orderCount();//订单总数
	int orderuntotal = orderDao.orderunCount();//未处理订单数
	int orderarltotal = orderDao.orderarlCount();//已处理单数
	int sendtotal = orderDao.sendCount();//已发货单数
	int waittotal = orderDao.waitCount();//待收货单数
	int retotal = orderDao.reCount();//已收货单数
	float totalp = orderDao.totalP();//交易总金额
	goodsDao goodsDao = new goodsDao();
	int goodstotal = goodsDao.goodsCount();//商品总数
	visitedDao visitedDao = new visitedDao();
	int visitedcount = visitedDao.visitedCount();//访问总数
	CommentDao cmd = new CommentDao();
	int cmtotal = cmd.cmCount();
	System.out.println(visitedcount);
	request.setAttribute("usertotal", usertotal);
	request.setAttribute("ordertotal", ordertotal);
	request.setAttribute("orderuntotal", orderuntotal);
	request.setAttribute("orderarltotal", orderarltotal);
	request.setAttribute("sendtotal", sendtotal);
	request.setAttribute("waittotal", waittotal);
	request.setAttribute("retotal", retotal);
	request.setAttribute("totalp", totalp);
	request.setAttribute("goodstotal", goodstotal);
	request.setAttribute("visitedcount", visitedcount);
	request.setAttribute("cmtotal", cmtotal);
	request.setAttribute("notnull", "12");
	request.getRequestDispatcher("/zadmin/main.jsp").forward(request, response);
	//response.sendRedirect("/banlajiang/zadmin/main.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
