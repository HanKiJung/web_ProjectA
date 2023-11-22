<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../css/login.css" >

</head>
<body>
	

    <div class="login" >
    	<div class="flexContainer">
	   		<div class="logoContainer">
	   			<img id="backImg" src="../publicResource/logo.png" alt="backgroundImage"/>
	   		</div>
	   		
	   		<div class="loginLabel">
	   		Login
	   		</div>
	   		
			<form id = "formStyle" method="post" action=" " id="login-form" >	
				<input type="text" name="userName" placeholder="Email">
				<input type="password" name="userPassword" placeholder="Password">
				  
				<div id = "Regilogin">
					<input id="loginBtn" type="submit" value="로그인">
					
					<div class="subBtnContainer">
						<a id="registerBtn" href="register.jsp">회원가입</a>
						
						<div id ="checkBoxContainer">
							<input class="keepId" type="checkbox" id="remember-check" name = "idsave" value="아이디저장">
							<span>아이디저장</span>
						</div>
					</div>
				</div>
			</form>
    	</div>
    	
       
    </div>
</body>
</html>