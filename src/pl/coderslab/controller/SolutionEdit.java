package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.model.DbUtil;
import pl.coderslab.model.Solution;

/**
 * Servlet implementation class SolutionEdit
 */
@WebServlet("/solutionEdit")
public class SolutionEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection conn = null;;
		try {
			conn = DbUtil.getConn();
			Solution solution = SolutionDAO.loadSolutionById(conn, id);
			request.setAttribute("solution", solution);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/solutionEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("8859_2"); //bez tego brak polskich znaków w odebranych z formularza danych!
		int id = Integer.parseInt(request.getParameter("id"));
		String created = request.getParameter("created");
		String updated = request.getParameter("updated");
		String description = request.getParameter("description");
		int exercise_id = Integer.parseInt(request.getParameter("exercise_id"));
		int users_id = Integer.parseInt(request.getParameter("users_id"));
		
		Connection conn = null;
		
		try {
			conn = DbUtil.getConn();
			Solution solution = SolutionDAO.loadSolutionById(conn, id);
			solution.setDescription(description);
			SolutionDAO.saveSolutionToDB(conn, solution);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		response.sendRedirect("solutionDetails?id="+id); 
	}

}
