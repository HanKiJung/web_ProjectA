package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.beans.UserDAO;
import com.user.beans.UserDTO;


@WebServlet("/Register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter script = response.getWriter();
		
		String userEmail = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		String userPwdCheck = request.getParameter("userpwd_check");
		String userPhonenumber = request.getParameter("userphone");
		String userBirth = request.getParameter("userbirth");
		String userName = request.getParameter("username");
		String userGender = request.getParameter("usergender");
		
		// 비밀번호 , 비밀번호 확인이 일치하는지 확인 => 다르면 뒤로 다시 보내기
		if (!userPwd.equals(userPwdCheck)) {
			script.println("<script  charset='UTF-8'>");
			script.println("alert('비밀번호가 일치하지않습니다.');");
			script.println("history.back();"); 
			script.println("</script>");
			script.close();	
		}
		else {
			// Insert data into UserDTO
			UserDTO dt = new UserDTO();
			dt.setUser_email(userEmail);
			dt.setUser_password(userPwd);
			dt.setUser_phoneNumber(userPhonenumber);
			dt.setUser_birth(userBirth);
			dt.setUser_name(userName);
			dt.setUser_gender(userGender);
			
			// UserDAO Register Process
			UserDAO da = new UserDAO();
			try {
				da.insertMember(dt);
				// Register Success
				script.println("<script  charset='UTF-8'>");
				script.println("alert('회원가입에 성공.');");
				script.println("</script>");
				script.close();
				response.sendRedirect("webproject/login.jsp"); //로그인 성공시 (데이터 베이스에 존재하는 데이터일 경우)
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				script.println("<script  charset='UTF-8'>");
				script.println("alert('회원가입에 실패하였습니다.');");
				script.println("history.back();"); 
				script.println("</script>");
				script.close();	
			}
		}
		
		
		
		
		System.out.println("userEmail : "+userEmail);
		System.out.println("userPwd : "+userPwd);
		System.out.println("userPwdCheck : "+userPwdCheck);
		System.out.println("userPhonenumber : "+userPhonenumber);
		System.out.println("userBirth : "+userBirth);
		System.out.println("userName : "+userName);
		System.out.println("userGender : "+userGender);
		
		
	}
}
