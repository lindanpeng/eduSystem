package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import beanMgr.UserMgr;
import beans.User;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public void login(User user,String code, HttpServletRequest request, HttpServletResponse response) {

		try {
			if (user.getUserid() == null || user.getPassword() == null||request.getSession().getAttribute("rand")==null) {
				response.sendRedirect("/eduSystem/login.jsp");
				return;
			}
			if(!request.getSession().getAttribute("rand").equals(code)){
				request.setAttribute("loginMsg", "验证码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			User user2 = UserMgr.find(user.getUserid());
			if (user.equals(user2)) {
				request.getSession().setAttribute("user", user2);
				request.getSession().setMaxInactiveInterval(900);//session存活时间
				if (user.getLevel() == 1)
					response.sendRedirect("/eduSystem/admin/index.jsp");
				else if (user.getLevel() == 2)
					response.sendRedirect("/eduSystem/teacher/index.jsp");
				else
					response.sendRedirect("/eduSystem/student/index.jsp");
			} else {
				request.setAttribute("loginMsg", "密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/random")
	public void random(HttpServletResponse response,HttpSession session){
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0); 
		int width=70, height=30; 
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
		Graphics g = image.getGraphics(); 
		Random random = new Random(); 
		g.setColor(getRandColor(200,250)); 
		g.fillRect(0, 0, width, height); 
		g.setFont(new Font("Times New Roman",Font.PLAIN,18)); 
		g.setColor(getRandColor(160,200)); 
		for (int i=0;i<155;i++) 
		{ 
		int x = random.nextInt(width); 
		int y = random.nextInt(height); 
		int xl = random.nextInt(12); 
		int yl = random.nextInt(12); 
		g.drawLine(x,y,x+xl,y+yl); 
		} 
		String sRand=""; 
		for (int i=0;i<4;i++){ 
		String rand=String.valueOf(random.nextInt(10)); 
		sRand+=rand; 
		g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110))); 
		g.drawString(rand,13*i+6,16); 
		} 
		session.setAttribute("rand",sRand); 
		g.dispose(); 
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	private Color getRandColor(int fc,int bc) 
	{ 
	Random random = new Random(); 
	if(fc>255) fc=255; 
	if(bc>255) bc=255; 
	int r=fc+random.nextInt(bc-fc); 
	int g=fc+random.nextInt(bc-fc); 
	int b=fc+random.nextInt(bc-fc); 
	return new Color(r,g,b); 
	} 
}