<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=request.getAttribute("message") %>

<%if(request.getAttribute("employees")!=null)
{%>

<table border="2">


<%
out.println("<tr>");
out.println("<td>Name</td>");
out.println("<td>Kin_Id</td>");
out.println("<td>Email_Id</td>");
out.println("<td>Department_Id</td>");
out.println("<td>Project_Id</td>");
out.println("<td>Role_Id</td>");
out.println("<td>Phone_No</td>");
out.println("<td>Date Of Birth</td>");
out.println("</tr>");


ArrayList<String[]> receivedlist = (ArrayList<String[]>)request.getAttribute("employees");
for(String[] s : receivedlist)
{
	out.println("<tr>");
	out.println("<td>"+s[0]+"</td>");
	out.println("<td>"+s[1]+"</td>");
	out.println("<td>"+s[2]+"</td>");
	out.println("<td>"+s[3]+"</td>");
	out.println("<td>"+s[4]+"</td>");
	out.println("<td>"+s[5]+"</td>");
	out.println("<td>"+s[6]+"</td>");
	out.println("<td>"+s[7]+"</td>");
	out.println("</tr>");
}
%>
</table>
<%} %>



</body>
</html>