<%@page import="model.User"%>
<%@page import="model.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String name=request.getParameter("name");
String email=request.getParameter("email");
String password=request.getParameter("pass");

try{
UserDao db=new UserDao();

if(db.checkEmail(email))
{
   request.getRequestDispatcher("index.jsp").include(request, response);
	out.print("<script>alert('email already registered')</script>");
}
else
{
User u=new User(name,email,password);
int a=db.insert(u);
if(a>0)
{
	out.print("data inserted");
}
else
{
	out.print("not inserted");
}
}
}
catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>
<!--
to Do 
1.no duplicate email register
2.css padding or margin reduce
-->