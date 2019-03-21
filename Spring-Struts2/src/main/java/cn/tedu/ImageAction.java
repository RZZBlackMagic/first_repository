package cn.tedu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ImageAction {

	private InputStream image;
	
	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public String execute() throws IOException{
		BufferedImage bf = new BufferedImage(10,60,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = bf.createGraphics();
		g.setColor(Color.white);
		g.drawString("hello world",10,20);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(bf, "png", out);
		out.close();
		byte[] data = out.toByteArray();
		image = new ByteArrayInputStream(data);
		return "success";
	}
}
