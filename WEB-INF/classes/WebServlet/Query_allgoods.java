package WebServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import domain.goods;

public class Query_allgoods extends HttpServlet{

	/* public static void main(String[] args) {
		goodsDao g = new goodsDao();
		Collection<goods> goods = g.getGoods();
		System.out.print(goods);
	}*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goodsDao g = new goodsDao();
		Collection<goods> goods = g.getGoods();
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("/zweb/allgoods.jsp").forward(request,
				response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


}
