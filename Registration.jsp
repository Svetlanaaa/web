<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация</title>
</head>

<body>
<form onSubmit = "validate()" method="post" action="MyServlet">
		<p><b>Регистрация<br></b></p>
		Логин<input type="text" name="login" id="username">
		Пароль<input type="password" name="pas" id="passwrd">
		Роль<select name="role">
 			<option value="admin">Админ</option>
  			<option value="justUser">Пользователь</option>
		</select>
		<br>
		<input type="submit" value="Отправить"> 
	</form>
</body>
<script>
function validate(){
	userName = document.getElementById("username");
	if (/^[a-z0-9]{3,}$/i.test(userName.value) == false){
		alert('Ошибка! Логин может содержать только латиницу и цифры. Длина - не менее 3х символов');
		this.event.stopPropagation(true);
		this.event.preventDefault();
		return false;
	}
	
	userPassword = document.getElementById("passwrd");
	if ((/^[a-z0-9]{6,}$/i.test(userPassword.value) == false) || (/[a-z]/i.test(userPassword.value)== false) ||  (/\d/.test(userPassword.value)== false)){
		alert('Ошибка! Пароль должен содержать латиницу и цифры. Длина - не менее 6 символов');
		this.event.stopPropagation(true);
		this.event.preventDefault();
		return false;
	}
	
}
</script>
</html>