<%@ page language="java"
	import="java.util.List, com.skolarajak.servisi.AdministriranjeVozila, com.skolarajak.model.Vlasnik"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean scope= "session" id="vlasnik" class="com.skolarajak.model.Vlasnik"></jsp:useBean>  
<jsp:setProperty property="*" name="vlasnik"/> 
<%
AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
administracijaVozila.unesiVlasnika(vlasnik);
out.write("<h2>Unos uspesan</h2>");


%>

</body>
</html>