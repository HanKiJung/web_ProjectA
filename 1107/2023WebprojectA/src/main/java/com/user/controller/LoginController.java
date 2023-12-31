package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.beans.UserDAO;


@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter script = response.getWriter();
		
		String user_id = request.getParameter("userEmail");
		String user_password = request.getParameter("userPassword");
		
		UserDAO rd = new UserDAO();
		boolean loginCheck = rd.loginCheck(user_id, user_password);
		
		if(loginCheck){
			    request.getSession().setAttribute("idKey",user_id);
			    request.getSession().setAttribute("success","success");
			    script.println("<script  charset='UTF-8'>");
	    		script.println("alert('로그인에 성공하셧습니다.');");
	    		script.println("</script>");
	    		response.sendRedirect("webproject/index.jsp"); //로그인 성공시 (데이터 베이스에 존재하는 데이터일 경우)
	    		script.close();
	    		
		   }else{
		        script.println("<script  charset='UTF-8'>");
	    		script.println("alert('다시 로그인해주세요.');");
	    		script.println("history.back();"); 
	    		script.println("</script>");
	    		script.close();
		   }
	}

}
