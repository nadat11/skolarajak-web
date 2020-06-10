<%@ page language="java" import="java.util.List, com.skolarajak.servisi.AdministriranjeVozila, com.skolarajak.model.Vlasnik" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Brisanje vlasnika</title>
	<link rel="stylesheet" type="text/css" href="/javaweb/vezba-baza/style.css">
</head>
<body>

	<%
	String brojVozackeDozvole = "1";
	
	try {
		brojVozackeDozvole = request.getParameter("id");
	} catch(NumberFormatException e) {
		
	}
	
	AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
	administracijaVozila.obrisiVlasnika(brojVozackeDozvole);
	out.write("Podatak je uspešno obrisan!");
	%>
	

</body>
</html>