package WebServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.goodsDao;
import dao.orderdetailDao;

import domain.comments;
import domain.goods;
import domain.orderdetail;

public class goodsDetail extends HttpServlet{
		
	  /*public static void main(String[] args) {
		  goodsDao g = new goodsDao();
			int goodsID = 2;
			goods goods = g.goodsDetails(goodsID);
		System.out.print(goods.getGoodsNo());
	}*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goodsDao g = new goodsDao();
		orderdetailDao o =new orderdetailDao();
		CommentDao c = new CommentDao();
		int goodsID = Integer.parseInt(request.getParameter("goodsID"));
		/*Collection<comments> cms = c.allcm(goodsID);
		System.out.print("œ‡πÿ∆¿º€"+cms);*/
		Collection<orderdetail> gdo = o.getGoodsOrder(goodsID);
	
		 int size=gdo.size();  
		 List<comments> cms = new ArrayList<comments>();
		 //comments[] cms=null;
		orderdetail[] od =  (orderdetail[])gdo.toArray(new orderdetail[size]);
		System.out.println("hahahah"+od.length+"hahahah");
		for(int i=0;i<od.length;i++) {
			String orderNo= od[i].getOrderNo();
			comments cm = c.goodsComment(orderNo);
			System.out.println(cm);
			int j=0;
			if(cm!=null) {
				cms.add(cm);
				j++;
			}
			
			
		}
		goods goods = g.goodsDetails(goodsID);
		request.setAttribute("goods", goods);
		request.setAttribute("cms", cms);
		request.getRequestDispatcher("/zweb/goodsDetail.jsp").forward(request,
				response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


}
