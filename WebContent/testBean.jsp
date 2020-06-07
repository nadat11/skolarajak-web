<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="vlasnik" class="com.skolarajak.model.Vlasnik" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test bean</title>
</head>
<body>
<!-- set -->
	<%-- <% vlasnik.setIme("Petar"); --%>

	<jsp:setProperty name="vlasnik" property="ime" value="Petar" />
	<%--<%= vlasnik.getIme() --%>
	<!-- get -->
	
	<jsp:getProperty name="vlasnik" property="ime" />
	
</body>
</html>