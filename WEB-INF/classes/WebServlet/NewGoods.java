package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import dao.visitedDao;
import domain.goods;

public class NewGoods extends HttpServlet{

	/* public static void main(String[] args) {
		goodsDao g = new goodsDao();
		Collection<goods> goods = g.getNewGoods();
		System.out.print(goods);
	}*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goodsDao g = new goodsDao();
		Collection<goods> newgoods = g.getNewGoods();
		request.setAttribute("newgoods", newgoods);
		Collection<goods> cheapgoods = g.getCheapGoods();
		request.setAttribute("newgoods", newgoods);
		request.setAttribute("cheapgoods", cheapgoods);
		request.setAttribute("notnull", "notnull");
		visitedDao visitedDao = new visitedDao();
		int visitedcount = visitedDao.visitedCount();
		
		 ServletContext application=this.getServletContext();
		          Integer count=(Integer) application.getAttribute("count");
		         if(count==null) 
		         {
		             count=1+visitedcount;
		             application.setAttribute("count",count);
		         }
		        else 
		             application.setAttribute("count",++count);
		int vc = visitedDao.updateCount(count);
		System.out.print(count);
		request.getRequestDispatcher("./index.jsp").forward(request,
				response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


}
