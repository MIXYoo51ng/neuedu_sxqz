package com.neuedu.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@WebServlet(urlPatterns="/checkcode.do")
public class CheckCodeServlet extends HttpServlet{

	private static final long serialVersionUID = 2602779377997156544L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应jpeg图片
		resp.setContentType("image/jpeg");
		//创建图片  60 20 为图片大小  图片显示类型
		BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		//创建一个画笔
		Graphics g = image.getGraphics();
		//创建一个随机数工具
		Random r = new Random();
		//设置背景色
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//填充背景色
		g.fillRect(0, 0, 60, 20);
		//设置前景颜色, 文字的颜色
		g.setColor(new Color(0,0,0));
		//生成随机数
//				String number = String.valueOf(r.nextInt(99999));
		//加干扰线
		for (int i = 0; i < 2; i++) {
			g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
		}
		String number = "";
		for (int i = 0; i < 5; i++) {
			number += r.nextInt(10);
		}
		HttpSession session = req.getSession();
		session.setAttribute("code", number);
		//将文字画到画板上
		g.drawString(number, 8, 15);
		//图片生成完之后响应给浏览器
		//获得字节输出流,因为要输出的是图像压缩之后的字节数组,所以,不能用 PrintWriter。
		OutputStream os = resp.getOutputStream();
		//将图片压缩，输出
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
	}
	
}
