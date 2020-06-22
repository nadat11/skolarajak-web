package com.skolarajak.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolarajak.model.Roles;

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
        this.assignRole=Roles.ADMIN;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if(isAuthorized(request, response)){ ;//roditeljska metoda		
			request.getRequestDispatcher("/vezba-security/pages/adminHomePage.jsp").forward(request,response);//jsp stranu ne otvaramo u browseru ali se vidi 
	}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
}
