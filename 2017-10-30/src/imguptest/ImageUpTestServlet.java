package imguptest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(urlPatterns="/imguptest.do")
public class ImageUpTestServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(req.getParameter("username"));
//		System.out.println(req.getParameter("image"));
//		InputStream in = req.getInputStream();
//		byte[] by = new byte[1024];
//		String str = "";
//		while((in.read(by)) != -1){
//			str += new String(by);
//		}
//		System.out.println(str);
		
		//step1创建一个工厂类的实例,该实例
		//为解析器提供了缺省的配置。
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建一个请求解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//使用解析器解析请求
		//解析之后,会将表单中的数据转换成一个个
		//FileItem 对象。一个表单域中的数据对应于一个
		//FileItem对象。
		List<FileItem> items = null;
		try {
			items = sfu.parseRequest(req);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		//遍历items集合
		for(int i=0;i<items.size();i++){
			FileItem item = items.get(i);
			//读表单域中的数据时,要区分表单域的类型
			if(item.isFormField()){
				//getFieldName()是获得此表单项的键
				//getString()获得值
				String key = item.getFieldName();
				String value = item.getString();
				System.out.println("key:"+key);
				System.out.println("value:"+value);
			}else{
				//文件上传表单域
				ServletContext application = getServletContext();
				String path = application.getRealPath("upload");
				//获得文件名
				String fileName = item.getName();
				//文件前缀
//				String prefix = System.currentTimeMillis()+"";
				String prefix = UUID.randomUUID().toString().replaceAll("-", "");
				//文件后缀
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				File file = new File(path + "\\" + prefix + suffix);
				System.out.println(file);
				try {
					item.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
