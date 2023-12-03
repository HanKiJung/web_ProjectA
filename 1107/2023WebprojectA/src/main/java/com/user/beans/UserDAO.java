package com.user.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// Final query set
	final String USER_INSERT = "insert into user(useremail, userpwd, userphone, userbirth, username, usergender)" + "values(?, ?, ?, ?, ?, ?)";
	final String LOGIN_CHECK = "select useremail, userpwd from user where useremail = ? and userpwd = ?";
	
	public void insertMember(UserDTO userData) throws SQLException {
		conn = JDBC.getConnection();
		pstmt = conn.prepareStatement(USER_INSERT);
		pstmt.setString(1, userData.getUser_email());
		pstmt.setString(2, userData.getUser_password());
		pstmt.setString(3, userData.getUser_phoneNumber());
		pstmt.setString(4, userData.getUser_birth());
		pstmt.setString(5, userData.getUser_name());
		pstmt.setString(6, userData.getUser_gender());
		
		pstmt.executeUpdate();
		JDBC.close(pstmt, conn);
	}
	
	public boolean loginCheck(String userEmail, String userPwd) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginCon = false;
        try {
            conn = JDBC.getConnection();
            pstmt = conn.prepareStatement(LOGIN_CHECK);
            pstmt.setString(1, userEmail);
            pstmt.setString(2, userPwd);
            rs = pstmt.executeQuery();
            loginCon = rs.next();
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
        	JDBC.close(pstmt, conn);
        }
        return loginCon;
	}
	
}
