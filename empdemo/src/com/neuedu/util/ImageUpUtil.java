package com.neuedu.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUpUtil {
	
	public static Map<String, String> imageup(HttpServletRequest req,HttpServletResponse resp){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = null;
		Map<String, String> param = new HashMap<String, String>();
		try {
			items = sfu.parseRequest(req);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		for(int i=0;i<items.size();i++){
			FileItem item = items.get(i);
			if(item.isFormField()){
				String key = item.getFieldName();
				String value = null;
				try {
					value = new String(item.get(),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				param.put(key, value);
			}else{
				ServletContext application = req.getServletContext();
				String path = application.getRealPath("upload");
				String fileName = item.getName();
				String prefix = UUID.randomUUID().toString().replaceAll("-", "");
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				File file = new File(path + "\\" + prefix + suffix);
				try {
					item.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				param.put("headimagepath", file.toString().substring(file.toString().lastIndexOf("upload")));
			}
		}
		return param;
	}
	
}
