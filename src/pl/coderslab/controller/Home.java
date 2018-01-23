package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;

/**
 * Servlet implementation class home
 */
//@WebServlet("/")
@WebServlet(urlPatterns = "/", initParams={@WebInitParam(name = "numberSolutions", value = "5") }) //- parametr umieszczamy w deskryptorze wdrożenia (web.xml) ale gdybyśmy robili to w adnotacjach to tak by to wyglądało
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Solution solution = new Solution();
		solution.setDescription("opis");
		solution.setCreated("2018-01-19");
		solution.setExercise_id(1);
		solution.setUpdated("2018-01-20");
		solution.setUsers_id(1);
		request.setAttribute("solution", solution);
		
		String myParam = getInitParameter("numberSolutions");
		System.out.println(myParam);
		request.setAttribute("numberSolutions", myParam);
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response); 

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
