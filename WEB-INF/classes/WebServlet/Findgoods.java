package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import domain.goods;


public class Findgoods extends HttpServlet {
		
	/*  public static void main(String[] args) {
		  goodsDao g = new goodsDao();
			String goodsName = "李锦记";
			Collection<goods> findgoods = g.findGoods(goodsName);
			
		System.out.print(findgoods);
	}*/
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		goodsDao g = new goodsDao();
		String goodsName = new String(request.getParameter("goodsName").getBytes("ISO8859-1"),"UTF-8");
		Collection<goods> findgoods = g.findGoods(goodsName);
		request.setAttribute("findgoods", findgoods);
		request.getRequestDispatcher("/zweb/findgoods.jsp").forward(request,
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
