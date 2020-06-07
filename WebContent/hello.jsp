<%@ page import="java.util.Date, java.util.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	errorPage="myerrorpage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>hello from jsp</title>
</head>
<body>
	<%@ include file="header.html"%>
	<!-- include dirketiva staticka  -->
	<jsp:include page="printdate.jsp" />
	<!--include ackija staticka   -->

	<%
		Long ms = System.currentTimeMillis(); //java kod
		out.write(ms.toString());
		if (ms % 2 == 0) {
	%>
	
	<%--  html ili jsp kod --%>
	<jsp:forward page="prikaz.jsp"> 
		<jsp:param name="name" value="<%=ms%>" />
	</jsp:forward>
	<%
		}
	%>

	<!-- Declaration -->
	<%!int data = 50;%>
	<!-- Execution -->
	<%
		//Petlja
	for (int i = 0; i < 10; i++) {
		out.write("<b>" + i + "</b> broj <br/>");
		//throw new Exception();
	}
	%>

	<!-- Evaluation -->
	<%-- declaration tag --%>
	<%="Value of the variable is:" + data--%>
	<br />
	<%=new Date()%>
</body>
</html>