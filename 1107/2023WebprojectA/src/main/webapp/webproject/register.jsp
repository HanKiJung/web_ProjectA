<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../css/register.css" >
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="backDiv">
		<img id="backImg" src="../publicResource/background.png" alt="backgroundImage"/>
	</div>
	
	
	<div class="ContentContainer">
	
		<!-- Register Title -->
		<div id="Registerline">
			Register
		</div>
		
		<!-- Input Container -->
		<form action="/2023WebprojectA/Register.do" class="inputContainer" method="post">
			<div class="inputGroup">
				<div class="labelContainer">
				이메일
				</div>
				<input type="text" name="userid" placeholder="이메일을 입력해주세요">
			</div>
			
			<div class="inputGroup">
				<div class="labelContainer">
				비밀번호
				</div>
				<input type="text" name="userpwd" placeholder="특수문자 1개이상 대문자 1개이상으로 조합해주세요">
			</div>
			
			<div class="inputGroup">
				<div class="labelContainer">
				비밀번호 확인
				</div>
				<input type="text" name="userpwd_check" placeholder="비밀번호를 재입력해주세요">
			</div>
			
			<div class="inputGroup">
				<div class="labelContainer">
				연락처
				</div>
				<input type="text" name="userphone" placeholder="연락처">
			</div>
			<div class="inputGroup">
				<div class="labelContainer">
				생년월일
				</div>
				<input type="text" name="userbirth" placeholder="생년월일">
			</div>
			
				<div class="inputGroup">
				<div class="labelContainer">
				이름
				</div>
				<input type="text" name="username" placeholder="이름을 입력해주세요">
			</div>
			
			<div class="inputGroup">
				<div class="labelContainer">
				성별
				</div>
				<div id="radioContainer">
					<label><input type="radio" name="usergender" value ="man" checked>남자</label>
					<label><input type="radio" name="usergender" value="wamon">여자</label>
				</div>	
			</div>
			<input id = "Registery" type="submit" value="회원가입">
		</form>
	</div>
	
	
</body>
</html>