package com.neuedu.controller_ss;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUpController {

	@RequestMapping("fileup.do")
	public String fileup(@RequestParam("file")MultipartFile f,HttpServletRequest request,String username){
		System.out.println(username);
		//获取服务器路径
		String pathroot = request.getServletContext().getRealPath("");
		//定义文件路径
		String path = null;
		//如果存在文件域
		if (!f.isEmpty()) {
			//以uuid做为文件名
			String prefix = UUID.randomUUID().toString().replaceAll("-", "");
			//获取文件类型
			String contentType = f.getContentType();
			//定义文件后缀
			String suffix = contentType.substring(contentType.indexOf("/") + 1);
			//拼接路径
			path = "/upload/" + prefix + "." + suffix;
			try {
				//写出文件
				f.transferTo(new File(pathroot + path));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(path);
		return null;
	}
	
}
