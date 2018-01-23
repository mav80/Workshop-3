package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {
	
	private Connection conn;
	
	public SolutionDao (Connection connection) {
		this.conn = connection;
		
	}
//	public int create(Solution solution) {
//		
//		if (solution.getId() == 0) {
//			String sql = "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ? )";
//			String generatedColumns[] = { "ID" };
//			PreparedStatement preparedStatement;
//			preparedStatement = conn.prepareStatement(sql, generatedColumns);
//			
//			//preparedStatement.setString(1, this.username);
//			//preparedStatement.setString(2, this.email);
//			//preparedStatement.setString(3, this.password);
//			preparedStatement.executeUpdate();
//			ResultSet rs = preparedStatement.getGeneratedKeys();
//			if (rs.next()) {
//				solution.id = rs.getInt(1);
//			}
//			}
//		
//	}
//	
//	
//	public List<Solution> loadAll(int limit) throws SQLException{
//		
//		static public User[] loadAllUsers(Connection conn) throws SQLException {
//			ArrayList<User> users = new ArrayList<User>();
//			String sql = "SELECT * FROM solution LIMIT ?";
//			PreparedStatement preparedStatement;
//			preparedStatement = conn.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//			User loadedUser = new User();
//			loadedUser.id = resultSet.getInt("id");
//			loadedUser.username = resultSet.getString("username");
//			loadedUser.password = resultSet.getString("password");
//			loadedUser.email = resultSet.getString("email");
//			users.add(loadedUser);}
//
//		
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
