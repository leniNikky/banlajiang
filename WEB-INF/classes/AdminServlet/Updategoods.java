package AdminServlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDao;
import dao.userDao;
import domain.goods;
import domain.user;

public class Updategoods extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("GBK"); 
		long size = 5 * 1024 * 1024;//允许上传最大值为5MB 
		String fileType = "jpg,gif,JPG";//允许上传文件类型 
		String imgName = null;//图片名称 
		byte[] data = null;//数据 
		String filePath = "";//文件路径 

		//得到服务器目录webroot下的ImageFiles目录的完整路径 
		String path = super.getServletContext().getRealPath("/img"); 

		System.out.println(path);

		SmartUpload su = new SmartUpload(); 
		//初始化 
		su.initialize(pageContext); 
		su.setMaxFileSize(size); 
		su.setAllowedFilesList(fileType); 
		su.setCharSet("GBK");
		//上载文件 
		su.upload(); 
		System.out.println(su.getSize());
		su.getRequest();
		//循环取得所有上载的文件 
		Files files = su.getFiles(); 
		if (files != null) { 
		//如果文件路径不存在则生成路径 
		java.io.File fileDir = new java.io.File(path); 
		System.out.println("存在");
		if (!fileDir.exists()) { 
		fileDir.mkdirs(); 
		System.out.println("不存在");
		} 

		System.out.println(files.getCount());
		//取出文件 
		for (int i = 0; i < files.getCount(); i++)
		 { 
		 com.jspsmart.upload.File file = files.getFile(i);
		 if (file.isMissing()) continue; 
		 if ("selPicture".equals(file.getFieldName())) { 
		 String type = file.getFilePathName(); 
		 type = type.substring(type.lastIndexOf(".")); 
		 imgName = UUID.randomUUID().toString();//生成uuid作为图片的名称 
		 imgName += type; 
		 filePath = path + "/" + imgName; 

		 //保存到指定文件 
		 file.saveAs(filePath); 

		
		} */

		goodsDao goodsDao=new goodsDao();
		goods goods= new goods();
		String goodsName = new String(request.getParameter("goodsName").getBytes("ISO8859-1"),"UTF-8");
		String goodsIntr = new String(request.getParameter("goodsIntr").getBytes("ISO8859-1"),"UTF-8");
		String gclass = new String(request.getParameter("gclass").getBytes("ISO8859-1"),"UTF-8");
		String goodsimg ="./img/"+ new String(request.getParameter("goodsimg").getBytes("ISO8859-1"),"UTF-8");
		String pictext ="./img/"+ new String(request.getParameter("pictext").getBytes("ISO8859-1"),"UTF-8");
		String gimg1 ="./img/"+ new String(request.getParameter("gimg1").getBytes("ISO8859-1"),"UTF-8");
		String gimg2 ="./img/"+ new String(request.getParameter("gimg2").getBytes("ISO8859-1"),"UTF-8");
		String gimg3 ="./img/"+ new String(request.getParameter("gimg3").getBytes("ISO8859-1"),"UTF-8");
		int goodsID = Integer.parseInt(request.getParameter("goodsID"));
		int goodsCount = Integer.parseInt(request.getParameter("goodsCount"));
		float goodsPrice = Float.parseFloat(request.getParameter("goodsPrice"));
			goods.setGclass(gclass);
			goods.setGimg1(gimg1);
			goods.setGimg2(gimg2);
			goods.setGimg3(gimg3);
			goods.setGoodsCount(goodsCount);
			goods.setGoodsID(goodsID);
			goods.setGoodsimg(goodsimg);
			goods.setGoodsIntr(goodsIntr);
			goods.setGoodsName(goodsName);
			goods.setGoodsPrice(goodsPrice);
			goods.setPictext(pictext);
			int u=goodsDao.updateGoods(goods);
			if(u>0){
				request.setAttribute("message", "修改成功！");
				request.getRequestDispatcher("/zadmin/message.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "修改失败！");
				request.getRequestDispatcher("/zadmin/message.jsp").forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
