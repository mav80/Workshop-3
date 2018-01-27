package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.User;

//import pl.coderslab.model.User;

public class UserDAO {
	

	
	//dodawanie użytkownika do bazy - używamy na obiekcie klasy User. RÓWNIEŻ UAKTUALNIANIE - część po 'else'
		public static void saveToDB(Connection conn, User user) throws SQLException {
			if (user.getId() == 0) { //jeśli id = 0 to znaczy że tworzymy nowego użytkownika
				String sql = "INSERT INTO users(username, email, password, person_group_id) VALUES (?, ?, ?, ?)";
				String generatedColumns[] = { "ID" }; //dowiadujemy się jakie było ID ostatniego rzędu
				PreparedStatement preparedStatement;
				preparedStatement = conn.prepareStatement(sql, generatedColumns);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getPassword());
				preparedStatement.setInt(4, user.getPerson_group_id());
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					user.setId(rs.getInt(1));
				}
			}else { //jeśli inne niż zero to uaktualniamy
				String sql = "UPDATE users SET username = ?, email = ?, password = ?, person_group_id = ? WHERE id = ?";
				PreparedStatement preparedStatement;
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getPassword());
				preparedStatement.setInt(4, user.getPerson_group_id());
				preparedStatement.setInt(5, user.getId());
				preparedStatement.executeUpdate();
			}
		}	
			
		//wczytywanie użytkownika po ID - metoda statyczna więc używamy już na klasie, nie na obiekcie	
		static public User loadUserById(Connection conn, int id) throws SQLException {
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User loadedUser = new User();
				loadedUser.setId(resultSet.getInt("id"));
				loadedUser.setUsername(resultSet.getString("username"));
				loadedUser.setPassword(resultSet.getString("password"));
				loadedUser.setEmail(resultSet.getString("email"));
				loadedUser.setPerson_group_id(resultSet.getInt("person_group_id"));
				return loadedUser;
			}
			return null;
		}
		
		
		//wczytujemy wszystkich użytkowników
		static public User[] loadAllUsers(Connection conn) throws SQLException {
			ArrayList<User> users = new ArrayList<User>();
			String sql = "SELECT * FROM users";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User loadedUser = new User();
				loadedUser.setId(resultSet.getInt("id"));
				loadedUser.setUsername(resultSet.getString("username"));
				loadedUser.setPassword(resultSet.getString("password"));
				loadedUser.setEmail(resultSet.getString("email"));
				loadedUser.setPerson_group_id(resultSet.getInt("person_group_id"));
				users.add(loadedUser);
			}
			User[] uArray = new User[users.size()];
			uArray = users.toArray(uArray);
			return uArray;
		}
		
		
		//kasujemy użytkownika z bazy - musimy użyć na obiekcie z klasy User
		public static void userDelete(Connection conn, User user) throws SQLException {
			if (user.getId() != 0) {
				String sql = "DELETE FROM users WHERE id = ?";
				PreparedStatement preparedStatement;
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, user.getId());
				preparedStatement.executeUpdate();
				user.setId(0);
			}
		}


		
		
		
		
		
		
		//Zadanie 5.1
		
		// pobranie wszystkich członków danej grupy (dopisz metodę loadAllByGrupId do klasy	User )
		
		
		//wczytywanie wszystkich użytkowników - metoda statyczna więc używamy już na klasie, nie na obiekcie	
		static public User[] loadAllByGrupId(Connection conn, int person_group_id) throws SQLException {
			ArrayList<User> users = new ArrayList<User>();
			String sql = "SELECT * FROM users WHERE person_group_id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, person_group_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User loadedUser = new User();
				loadedUser.setId(resultSet.getInt("id"));
				loadedUser.setUsername(resultSet.getString("username"));
				loadedUser.setPassword(resultSet.getString("password"));
				loadedUser.setEmail(resultSet.getString("email"));
				loadedUser.setPerson_group_id(resultSet.getInt("person_group_id"));
				users.add(loadedUser);
			}
			
			User[] uArray = new User[users.size()];
			uArray = users.toArray(uArray);
			return uArray;

		}
		
		

}
