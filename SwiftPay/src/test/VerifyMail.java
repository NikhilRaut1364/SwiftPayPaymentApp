package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VerifyMail extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {  
		
		
				int otp;
				Random rmd=new Random();
				otp=rmd.nextInt(9999);
			    response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			    //String verify=request.getParameter("otp");
			    String name=request.getParameter("name");  
			    String to=request.getParameter("email"); 
			    String phoneno=request.getParameter("phoneno");
			    String subject="OTP Verification";
			    String msg="Hi "+name+" Your OTP is: "+otp;
			    
			    
			    Cookie cookie=new Cookie("name", name+"");
			    Cookie cookie1=new Cookie("otp", otp+"");
			    Cookie cookie2=new Cookie("email", to+"");
			    Cookie cookie3=new Cookie("phoneno", phoneno+"");
			    response.addCookie(cookie);
			    response.addCookie(cookie1);
			    response.addCookie(cookie2);
			    response.addCookie(cookie3);
			    
			    Mailer.send(to, subject, msg);
			    
			    RequestDispatcher rd=request.getRequestDispatcher("Emailverify.jsp");
			    rd.include(request, response);
			    out.close();  
			    }  
}
