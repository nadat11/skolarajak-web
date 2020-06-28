<%@ page language="java" import="java.util.List, com.skolarajak.model.Vlasnik" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
<body>
<jsp:include page="menu.jsp" />
<h3>Admin Home Page</h3>
<table border="1">
		<%
			int pageNumber = 1;

		try {
			pageNumber = (Integer)request.getAttribute("pageNumber");
		} catch (NumberFormatException e) {

		}
       // kada posledi stranu uzima atribut isti je naziv, kastuje se jer getAtribute radi sa objektima 
		//preuzeli smo sta je servlet propagirao
	    List<Vlasnik> vlasnici= (List<Vlasnik>)request.getAttribute("listaVlasnika");

		String dataTemplate = "<td>%s</td>";

		if (vlasnici.size() > 0) {
			for (Vlasnik vlasnik : vlasnici) {
				out.write("<tr>");

				out.write(String.format(dataTemplate, vlasnik.getIme()));

				out.write(String.format(dataTemplate, vlasnik.getPrezime()));
				
				out.write(String.format(dataTemplate, vlasnik.getBrojVozackeDozvole()));
	
			 	String brojVozackeDozvole = vlasnik.getBrojVozackeDozvole();
		
				out.write("</tr>");
			}
		} else {
			out.write("<div class='no-result>'Nema rezultata </div>");
		}
		
		%>
		<a class="pages" href="/javaweb/vezba-security/adminHomeServlet.html?p=<%= pageNumber-1 %>"> < </a>
		<div class="pages">strana <%= pageNumber%> </div>
		<a class="pages" href="/javaweb/vezba-security/adminHomeServlet.html?p=<%= pageNumber+1 %>"> > </a>
	</table>
</body>
</html>