package AdminServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import domain.goods;

public class UpgsDetail extends HttpServlet{
		
	  /*public static void main(String[] args) {
		  goodsDao g = new goodsDao();
			int goodsID = 2;
			goods goods = g.goodsDetails(goodsID);
		System.out.print(goods.getGoodsNo());
	}*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goodsDao g = new goodsDao();
		int goodsID = Integer.parseInt(request.getParameter("goodsID"));
		
		goods goods = g.goodsDetails(goodsID);
		request.setAttribute("goods", goods);
		System.out.print(goods);
		request.getRequestDispatcher("/zadmin/edit_product.jsp").forward(request,
				response);
		//response.sendRedirect("/banlajiang/zadmin/edit_product.jsp");

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


}
