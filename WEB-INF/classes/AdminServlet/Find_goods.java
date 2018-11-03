package AdminServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import domain.goods;


public class Find_goods extends HttpServlet {
		
	/*  public static void main(String[] args) {
		  goodsDao g = new goodsDao();
			String goodsName = "鏉庨敠璁�";
			Collection<goods> findgoods = g.findGoods(goodsName);
			
		System.out.print(findgoods);
	}*/
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		goodsDao g = new goodsDao();
		String goodsName = new String(request.getParameter("goodsName").getBytes("ISO8859-1"),"UTF-8");
		Collection<goods> findgoods = g.findGoods(goodsName);
		request.setAttribute("goods", findgoods);
		System.out.print(findgoods);
		request.getRequestDispatcher("/zadmin/product_list.jsp").forward(request,
				response);
		//response.sendRedirect("/zadmin/product_list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
