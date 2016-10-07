package com.tarena.action.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.action.BaseController;
@Controller
@RequestMapping("/user")
public class imageCodeController extends BaseController{
	@RequestMapping("/imageCode.do")
	public void imageCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BufferedImage image=new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillRect(0,0,100,30);
		String number=getNumber(5);
		HttpSession session=request.getSession();
		session.setAttribute("code",number);
		g.setColor(new Color(0,0,0));
		g.setFont(new Font(null,Font.BOLD,24));
		g.drawString(number,5,25);
		for(int i=0;i<8;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(100),r.nextInt(30),r.nextInt(100),r.nextInt(30));
		}
		response.setContentType("image/jpeg");
		OutputStream ops=response.getOutputStream();
		ImageIO.write(image,"jpeg",ops);
		ops.close();
	} 
	public String getNumber(int size){
	    	String str="ABCDEFGHIJKLMNOPQSRTUVWXYZ0123456789";
	    	String number="";
	    	Random r=new Random();
	    	for(int i=0;i<size;i++){
	    		number+=str.charAt(r.nextInt(str.length()));
	    	}
	    	return number;
	 }
}
