package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserDAO;
import pl.coderslab.model.DbUtil;
import pl.coderslab.model.User;

/**
 * Servlet implementation class AdminPanelUsersEdit
 */
@WebServlet("/adminPanel/usersEdit")
public class AdminPanelUsersEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPanelUsersEdit() {
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
			User user = UserDAO.loadUserById(conn, id);
			request.setAttribute("user", user);
			conn.close();
			if(id > -1 && user != null) {
				request.setAttribute("message", "Edytujesz użytkownika o nazwie " + user.getUsername() + ".");
				request.setAttribute("buttonMessage", "Zapisz zmiany");
			} else {
				request.setAttribute("message", "Tworzysz nowego użytkownika.");
				request.setAttribute("buttonMessage", "Stwórz nowego użytkownika");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/usersEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("8859_2"); //bez tego brak polskich znaków w odebranych z formularza danych!
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int person_group_id = Integer.parseInt(request.getParameter("person_group_id"));
		System.out.println("Odebrane dane w POST: id = " + id + " nazwa usera: " + username + ", id grupy: " + person_group_id + ", email: " + email + ", password: " + password);
		
		Connection conn = null;
		
		if(id > -1) {
			try {
				conn = DbUtil.getConn();
				User user = UserDAO.loadUserById(conn, id);
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setPerson_group_id(person_group_id);
				UserDAO.saveToDB(conn, user);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			try {
				conn = DbUtil.getConn();
				User user = new User();
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setPerson_group_id(person_group_id);
				UserDAO.saveToDB(conn, user);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		response.sendRedirect("users"); 
	}

}
