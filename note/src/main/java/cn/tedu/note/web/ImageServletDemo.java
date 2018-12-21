package cn.tedu.note.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServletDemo
 */
public class ImageServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServletDemo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    //发送照片
		byte[] png = createPng();
		response.setContentType("image/png");
		response.setContentLength(png.length);
		//在消息body中发送消息数据
		response.getOutputStream().write(png);
	}
	/**
	 * 
	 * 创建一个图片，并且编码为PNG格式，返回编码以后的数据
	 * @return
	 * @throws IOException 
	 */
	private byte[] createPng() throws IOException{
		BufferedImage img = new BufferedImage(200,80,BufferedImage.TYPE_3BYTE_BGR
				);
		//在图片上绘制东西
		img.setRGB(100, 40, 0xffffff);
		//将图片编码为PNG
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] png = out.toByteArray();
		return png;
	}

}
