<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List" import = "java.util.ArrayList" import = "java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Гостевая книга</title>
</head>
<body>
	<div id = "mes"></div>
	<form method="post" action="Messages">
		<p><b>Гостевая книга<br></b></p>
		<input type="text" name="message">
		<input type="submit" value="Отправить сообщение" >
		
	</form>
	<script>
		function getFromServlet(){
			var req = new XMLHttpRequest();
			req.onreadystatechange = function(){
				if (req.status === 200){
					var div = document.getElementById("mes");
					div.innerHTML = req.responseText;
				}
			}
			req.open('GET', 'http://localhost:8080/WebApp/Messages', true);			
			req.send();
		}
		setInterval(getFromServlet, 500);
	</script>
</body>
</html>