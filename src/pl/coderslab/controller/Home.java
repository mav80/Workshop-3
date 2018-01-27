package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.model.DbUtil;
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
		
		String numberSolutions = getInitParameter("numberSolutions");
//		System.out.println(numberSolutions);
		request.setAttribute("numberSolutions", numberSolutions);
		
	
		Connection conn = null;;
		try {
			conn = DbUtil.getConn();
			Solution[] solutions = SolutionDAO.loadAllSolutions(conn, Integer.parseInt(numberSolutions));
			request.setAttribute("solutions", solutions);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
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
