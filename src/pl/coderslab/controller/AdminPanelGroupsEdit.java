package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserGroupDAO;
import pl.coderslab.model.DbUtil;
import pl.coderslab.model.UserGroup;

/**
 * Servlet implementation class AdminPanelGroupsEdit
 */
@WebServlet("/adminPanel/groupsEdit")
public class AdminPanelGroupsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPanelGroupsEdit() {
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
			UserGroup group = UserGroupDAO.loadGroupById(conn, id);
			conn.close();
			request.setAttribute("group", group);
			if(id > -1 && group != null) {
				request.setAttribute("message", "Edytujesz grupę o nazwie " + group.getGroupName() + ".");
				request.setAttribute("buttonMessage", "Zapisz zmiany");
			} else {
				request.setAttribute("message", "Tworzysz nową grupę.");
				request.setAttribute("buttonMessage", "Stwórz nową grupę");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/groupsEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("8859_2"); //bez tego brak polskich znaków w odebranych z formularza danych!
		int id = Integer.parseInt(request.getParameter("id"));
		String groupName = request.getParameter("groupName");
		//System.out.println("Odebrane dane: id = " + id + " nazwa grupy: " + groupName);
		
		Connection conn = null;
		
		if(id > -1) {
			try {
				conn = DbUtil.getConn();
				UserGroup group = UserGroupDAO.loadGroupById(conn, id);
				group.setGroupName(groupName);
				UserGroupDAO.addGroupToDB(conn, group);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			try {
				conn = DbUtil.getConn();
				UserGroup group = new UserGroup();
				group.setGroupName(groupName);
				UserGroupDAO.addGroupToDB(conn, group);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		response.sendRedirect("groups"); 
	}

}
