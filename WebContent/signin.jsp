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
String email=request.getParameter("uname");
String password=request.getParameter("upass");
try{
UserDao db=new UserDao();
boolean a=db.checkUser(email,password);
if(a)
{
	//adding username and password in session object
	session.setAttribute("email", email);
	session.setAttribute("pass", password);
	//end session
		response.sendRedirect("profile.jsp");//we are adding profile-done

}
else
{
	out.print("<script>alert('wrong username and password')</script>");
	request.getRequestDispatcher("login.jsp").include(request, response);
}}
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