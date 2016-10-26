<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
String getHello(String name){
	return "Hi,"+name+"!";
}
%>
<% Date now=new Date(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- 这是注释，但客户端可以查看到 -->
<%--这也是注释，但客户端不能查看到 --%>

<body>
<h1 align="center">jsp页面构成</h1>
<%=getHello("朋友") %>,
现在是,<%=now %>
<br>
<jsp:include page="Welcome.jsp" flush="true">
<jsp:param name="str" value="参数"/>
</jsp:include>

</body>
</html>