<%@page import="model.Purchase"%>
<%@page import="model.PurchaseDao"%>
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
String pname=request.getParameter("pname");
String pmno=request.getParameter("pmno");


try
{
PurchaseDao db=new PurchaseDao();
Purchase u=new Purchase(pname, pmno);

int a=db.insert(u);
if(a>0)
{
	out.print("<script>alert('data inserted')</script>");

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