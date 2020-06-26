package com.skolarajak.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Vlasnik;
import com.skolarajak.servisi.AdministriranjeVozila;

/**
 * Servlet implementation class ListajVlasnike
 */
@WebServlet( "/vezba-security/ListajVlasnike.html")
public class ListajVlasnike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListajVlasnike() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// pageNumber preuzet iz requesta za paginaciju
		Integer pageNumber = Integer.parseInt(request.getParameter("p"));
		List<Vlasnik> vlasnici = null; // deklaracija liste
		// insatcirana administracijaVozila
		AdministriranjeVozila administracijaVozila = new AdministriranjeVozila();
		try {
			vlasnici = administracijaVozila.dajSveVlasnike(pageNumber); // prikazuje sve vlasnike za pageNumber
		} catch (ResultNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		// vraca request
		request.setAttribute("listaVlasnika", vlasnici);
		request.setAttribute("pageNumber", pageNumber);
		request.getSession().setAttribute("username", "test user");
		// prosledjuje stranu na jsp
		request.getRequestDispatcher("/vezba-servleti/listajVlasnikePrikaz.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
