package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExerciseDAO;
import pl.coderslab.model.DbUtil;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;

/**
 * Servlet implementation class AdminPanelUsersEdit
 */
@WebServlet("/adminPanel/exercisesEdit")
public class AdminPanelExercisesEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPanelExercisesEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection conn = null;
		try {
			conn = DbUtil.getConn();
			Exercise exercise = ExerciseDAO.loadExerciseById(conn, id);
			request.setAttribute("exercise", exercise);
			conn.close();
			if(id > -1 && exercise != null) {
				request.setAttribute("message", "Edytujesz zadanie o nazwie " + exercise.getDescription() + ".");
				request.setAttribute("buttonMessage", "Zapisz zmiany");
			} else {
				request.setAttribute("message", "Tworzysz nowe zadanie.");
				request.setAttribute("buttonMessage", "Stwórz nowe zadanie");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/exercisesEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("8859_2"); //bez tego brak polskich znaków w odebranych z formularza danych!
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		System.out.println("Odebrane dane w POST: id = " + id + " nazwa zadania: " + title + ", opis zadania: " + description);
		
		Connection conn = null;
		
		if(id > -1) {
			try {
				conn = DbUtil.getConn();
				Exercise exercise = ExerciseDAO.loadExerciseById(conn, id);
				exercise.setDescription(description);
				//exercise.setDescription("ąćę test polskich znaków łśńźż");
				exercise.setTitle(title);
				ExerciseDAO.addExerciseToDB(conn, exercise);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			try {
				conn = DbUtil.getConn();
				Exercise exercise = new Exercise();
				exercise.setDescription(description);
				exercise.setTitle(title);
				ExerciseDAO.addExerciseToDB(conn, exercise);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		response.sendRedirect("exercises"); 
	}

}
