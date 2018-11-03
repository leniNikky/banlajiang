package AdminServlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.goodsDao;
import domain.goods;


public class Updgoods extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		try {
			//0.ʹ��fileupload������ƷͼƬ������Ʒ����Ϣ����map��
			//0.1����map���ϴ����Ʒ��Ϣ
			Map<String,Object> map=new HashMap<String,Object>();
			
			//0.2���������ļ������������ʱ�ļ��Ĵ�С��λ�ã�
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//0.3���������ϴ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//0.4����request
			List<FileItem> list = upload.parseRequest(request);
			
			//0.5����list��ȡÿһ���ļ���
			for (FileItem fi : list) {
				//0.6��ȡname����ֵ
				
				String key = new String(fi.getFieldName().getBytes("ISO-8859-1"),"utf-8");
				/*product_id productName costPrice currentPrice selectName stock hot 
				 * undercarriage p_img p_img1 p_img2 p_img3 mytextarea
				*/
				//0.7�ж��Ƿ�����ͨ���ϴ����
				if (fi.isFormField()) {
					//��ͨ
					map.put(key, fi.getString("utf-8")); // ��װ���ϴ��������Ϣ��map
					
				} else {
					//�ļ�
					//a.��ȡ�ļ�������
					String name = new String(fi.getName().getBytes("ISO-8859-1"),"utf-8");
					
					//b.��ȡ�ļ�����ʵ����
					String realName = UploadUtils.subFileName(name);
					
					//c.��ȡ�ļ����������
					String uuidName = UploadUtils.generateRandonFileName(realName);
					
					//d.��ȡ���Ŀ¼
					String randomDir = UploadUtils.generateRandomDir(uuidName);
					
					//e.��ȡ�ļ����ݣ�������0��
					InputStream is = fi.getInputStream();
					
					//f.���������
					//��ȡimagesĿ¼����ʵ·��
					String imagesPath = getServletContext().getRealPath("/img");
					/*out.println(imagesPath);
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images 
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images 
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images 
					D:\Workspaces\MyEclipse Professional 2014\.metadata\.me_tcat\webapps\snail\images*/
					
					//�������Ŀ¼
					File pathFile = new File(imagesPath,randomDir);
					if (!pathFile.exists()) { // Ŀ¼�����ڣ�����
						pathFile.mkdirs();
					}
					
					String url= Upload.upload(fi, imagesPath);
					
					//j.����Ʒ��·������map��
					map.put(key, url);
				}
				
			}
			
			//1.��װproduct����
			goods goods = new goods();
			System.out.println(map.get("goodsID"));
			goods.setGoodsID(Integer.parseInt((String) map.get("goodsID")));
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
			//2.����
			goodsDao impl = new goodsDao();
			int i=impl.updateGoods(goods);
			
			if(i==1){
				/* request.getRequestDispatcher("/zadmin/main.jsp").forward(request, response);*/
				response.sendRedirect("/banlajiang/zadmin/main.jsp");
			}else{
				request.setAttribute("message", "�޸�ʧ��");
				response.sendRedirect("/banlajiang/zadmin/messgae.jsp");
			}
			
			
			//3.�ض���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new RuntimeException("�����Ʒʧ��");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
