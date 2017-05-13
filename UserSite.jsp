<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import = "ru.unlimit.Users" import = "java.util.HashMap" import = "java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	HashMap<String, Users> users = (HashMap<String, Users>)request.getSession().getAttribute("users"); 
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pOut = response.getWriter();	
		
		
		for (String key: users.keySet()){
				
				pOut.write(key + "\n");	
			
			}
			
			out.close();
		%>
</body>
</html>