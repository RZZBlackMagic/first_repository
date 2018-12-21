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
	    //������Ƭ
		byte[] png = createPng();
		response.setContentType("image/png");
		response.setContentLength(png.length);
		//����Ϣbody�з�����Ϣ����
		response.getOutputStream().write(png);
	}
	/**
	 * 
	 * ����һ��ͼƬ�����ұ���ΪPNG��ʽ�����ر����Ժ������
	 * @return
	 * @throws IOException 
	 */
	private byte[] createPng() throws IOException{
		BufferedImage img = new BufferedImage(200,80,BufferedImage.TYPE_3BYTE_BGR
				);
		//��ͼƬ�ϻ��ƶ���
		img.setRGB(100, 40, 0xffffff);
		//��ͼƬ����ΪPNG
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] png = out.toByteArray();
		return png;
	}

}
