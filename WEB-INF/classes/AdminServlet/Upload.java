package AdminServlet;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.fileupload.FileItem;

import AdminServlet.RandomStr;

public class Upload {

	public static String upload(FileItem fItem, String url) {
		try {
			if (fItem.getFieldName() != null
					&& !"".equals(fItem.getFieldName())) {
				Date d = new Date();

				String filename = RandomStr.get32UUID();
				String name = fItem.getName();
				System.out.println(name);
				String suffix = name.substring(name.lastIndexOf('.'));
				filename += suffix;
				// System.out.println(url);
				// System.out.println(filename);
				url = getFolder(url);
				File file = new File(url, filename);

				fItem.write(file);

				url += "/" + filename;
				// System.out.println(url);
				url = dourl(url);
				return url;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
		return null;
	}

	public static String getFolder(String url) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		url += "/" + formater.format(new Date());
		File file = new File(url);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		return url;
	}

	public static String dourl(String url) {
		int index = url.lastIndexOf("img");
		if (index != -1) {
			url = url.substring(index);
		}
		return url;
	}
}
