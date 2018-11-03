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


public class GoodsClass extends HttpServlet {

	/*public static void main(String[] args) {
		goodsDao g = new goodsDao();
		String gclass = new String(request.getParameter("gclass").getBytes("ISO8859-1"),"UTF-8");
		Collection<goods> goodsClass = g.getGoodsClass(gclass);
		System.out.print(goodsClass);
	}
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		goodsDao g = new goodsDao();
		String gclass = new String(request.getParameter("gclass").getBytes("ISO8859-1"),"UTF-8");
		Collection<goods> goodsClass = g.getGoodsClass(gclass);
		request.setAttribute("goodsClass", goodsClass);
		request.getRequestDispatcher("/zweb/goodsclass.jsp").forward(request,
				response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
