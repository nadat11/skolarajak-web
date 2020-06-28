package com.skolarajak.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Roles;
import com.skolarajak.model.Vlasnik;
import com.skolarajak.servisi.AdministriranjeVozila;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/vezba-security/adminHomeServlet.html")
public class AdminHomeServlet extends BaseAuthorizationServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHomeServlet() {
		super();
		this.assignRole = Roles.ADMIN;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isAuthorized(request, response)) {
			
			Integer pageNumber = 1;
			try {
			 pageNumber = Integer.parseInt(request.getParameter("p"));
			} catch(NumberFormatException e) {
				pageNumber = 1; //ako nema hvatamo broj nema parametra, pageNumber vratiti 1 stranu
			}
			
			List<Vlasnik> vlasnici = null; // deklaracija liste
			// insatcirana administracijaVozila
			AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();// zove servis i koristi pageNumber
			try {
				vlasnici = administracijaVozila.dajSveVlasnike(pageNumber); // prikazuje sve vlasnike za pageNumber
			} catch (ResultNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			// vraca request
			request.setAttribute("listaVlasnika", vlasnici);
			request.setAttribute("pageNumber", pageNumber);
		
			// roditeljska metoda
		request.getRequestDispatcher("/vezba-security/pages/adminHomePage.jsp").forward(request, response);// jsp
																							// vidi
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
