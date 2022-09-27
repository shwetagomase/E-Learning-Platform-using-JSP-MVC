<%@page import="model.Mentor"%>
<%@page import="model.MentorDao"%>
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

String mname=request.getParameter("mname");
String memail=request.getParameter("memail");
String maddress=request.getParameter("maddress");
String mno=request.getParameter("mno");

try{
MentorDao db= new MentorDao();
Mentor u=new Mentor(mname, memail, maddress, mno);    
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