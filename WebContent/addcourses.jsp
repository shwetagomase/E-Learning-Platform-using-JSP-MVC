<%@page import="model.Admin"%>
<%@page import="model.AdminDao"%>
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
String cname=request.getParameter("cname");
String cauthor=request.getParameter("cauthor");
String ccertificate=request.getParameter("ccertificate");
String cprice=request.getParameter("cprice");


try{
	AdminDao db=new AdminDao();

    Admin u=new Admin(cname,cauthor,ccertificate,cprice);
int a=db.insert(u);
if(a>0)
{
	out.print("<script>alert('data inserted')</script>");
    //request.getRequestDispatcher("login.jsp").include(request, response);

	}
else
{
	out.print("not inserted");
}
}
catch(Exception e){
	e.printStackTrace();
}

%>
</body>
</html>