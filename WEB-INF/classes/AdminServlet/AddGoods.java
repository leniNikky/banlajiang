package AdminServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import AdminServlet.UploadUtils;

import dao.goodsDao;
import domain.goods;

public class AddGoods extends HttpServlet {
	/*public static void main(String[] args) {
	goodsDao goodsDao = new goodsDao();
		goods goods = new goods();
		int goodsNo = 1;
		String goodsName = "浣犲ソ";
		String goodsIntr = "浣犲ソ";
		float goodsPrice = 12.5f;
		int goodsCount = 300;
		String gclass = "浣犲ソ";
		String goodsimg = "浣犲ソ";
		String pictext = "浣犲ソ";
		String gimg1 = "浣犲ソ";
		String gimg2 = "浣犲ソ";
		String gimg3 = "浣犲ソ";
		goods.setGoodsNo(goodsNo);
		goods.setGoodsName(goodsName);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsCount(goodsCount);
		goods.setGoodsIntr(goodsIntr);
		goods.setGclass(gclass);
		goods.setGoodsimg(goodsimg);
		goods.setPictext(pictext);
		goods.setGimg1(gimg1);
		goods.setGimg2(gimg2);
		goods.setGimg3(gimg3);
		boolean b=goodsDao.insertGoods(goods);
	System.out.println(b);
}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		try {
			//0.使用fileupload保存商品图片并将商品的信息放入map中
			//0.1创建map集合存放商品信息
			Map<String,Object> map=new HashMap<String,Object>();
			
			//0.2创建磁盘文件项工厂（设置临时文件的大小和位置）
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//0.3创建核心上传对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//0.4解析request
			List<FileItem> list = upload.parseRequest(request);
			
			//0.5遍历list获取每一个文件项
			for (FileItem fi : list) {
				//0.6获取name属性值
				
				String key = new String(fi.getFieldName().getBytes("ISO-8859-1"),"utf-8");
				/*product_id productName costPrice currentPrice selectName stock hot 
				 * undercarriage p_img p_img1 p_img2 p_img3 mytextarea
				*/
				//0.7判断是否是普通的上传组件
				if (fi.isFormField()) {
					//普通
					map.put(key, fi.getString("utf-8")); // 封装非上传项组件信息到map
					
				} else {
					//文件
					//a.获取文件的名称
					String name = new String(fi.getName().getBytes("ISO-8859-1"),"utf-8");
					
					//b.获取文件的真实名称
					String realName = UploadUtils.subFileName(name);
					
					//c.获取文件的随机名称
					String uuidName = UploadUtils.generateRandonFileName(realName);
					
					//d.获取随机目录
					String randomDir = UploadUtils.generateRandomDir(uuidName);
					
					//e.获取文件内容（输入流0）
					InputStream is = fi.getInputStream();
					
					//f.创建输出流
					//获取images目录的真实路径
					String imagesPath = getServletContext().getRealPath("/img");
					/*out.println(imagesPath);
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images 
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images 
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images 
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images*/
					
					//创建随机目录
					File pathFile = new File(imagesPath,randomDir);
					if (!pathFile.exists()) { // 目录不存在，创建
						pathFile.mkdirs();
					}
					
					String url= Upload.upload(fi, imagesPath);
					
					//j.将商品的路径放入map中
					map.put(key, url);
				}
				
			}
			
			//1.封装product对象
			goods goods = new goods();
			System.out.println(map.get("goodsNo"));
			goods.setGoodsNo(Integer.parseInt((String) map.get("goodsNo")));
			goods.setGoodsName((String)map.get("goodsName"));
			goods.setGoodsPrice(Float.parseFloat((String)map.get("goodsPrice")));
			goods.setGclass((String)map.get("gclass"));
			goods.setGoodsIntr((String)map.get("goodsIntr"));
			goods.setGimg1((String)map.get("gimg1"));
			goods.setGimg2((String)map.get("gimg2"));
			goods.setGimg3((String)map.get("gimg3"));
			goods.setPictext((String)map.get("pictext"));
			goods.setGoodsimg((String)map.get("goodsimg"));
			goods.setGoodsCount(Integer.parseInt((String) map.get("goodsCount")));
			//2.调用
			goodsDao impl = new goodsDao();
			boolean i=impl.insertGoods(goods);
			
			if(i){
				request.getRequestDispatcher("/zadmin/main.jsp").forward(request,
						response);
			}else{
				request.getRequestDispatcher("/zadmin/adminIndex.jsp").forward(request,
						response);
				
			}
			
			
			//3.重定向
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new RuntimeException("添加商品失败");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
