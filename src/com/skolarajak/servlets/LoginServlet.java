package com.skolarajak.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.model.User;
import com.skolarajak.servisi.AdministracijaKorisnika;

/**
 * Servlet implementation class Login servlet za samo citanje korisnika
 */
@WebServlet("/vezba-security/loginServlet.html")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministracijaKorisnika administracijaKorisnika = new AdministracijaKorisnika();

	/**
	 * @see HttpServlet#HttpServlet(), konstruktor servleta
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// trazimo username i password
		// int r = 5; //svaki korisnik dobija svoj request

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		handleExistingUser(request, response, username, password);

	}

	private void handleExistingUser(HttpServletRequest request, HttpServletResponse response, String username,
			String password) throws IOException {
		if (administracijaKorisnika.isRegistered(username)) {
			handleAuthentication(request, response, username, password);
		} else {
			response.sendRedirect("/javaweb/vezba-security/notRegisteredUser.html");
		}
	}

	private void handleAuthentication(HttpServletRequest request, HttpServletResponse response, String username,
			String password) throws IOException {
		if (administracijaKorisnika.isAuthenticated(username, password)) {
			handleUserRole(request, response, username);
		} else {
			response.sendRedirect("/javaweb/vezba-security/wrongPassword.html");
		}
	}

	private void handleUserRole(HttpServletRequest request, HttpServletResponse response, String username)
			throws IOException {
		User user = administracijaKorisnika.getUser(username);

		if (user != null) {
			request.getSession().setAttribute("user", user);
		}
		switch (user.getRole()) {
		case ADMIN : response.sendRedirect("/javaweb/vezba-security/adminHomeServlet.html");
			break;
		case USER : response.sendRedirect("/javaweb/vezba-security/homeServlet.html");
			break;
		default : 	response.sendRedirect("/javaweb/vezba-security/notAuthorized.html");
			break;		
		}
	}

}
