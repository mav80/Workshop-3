package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Solution;

public class SolutionDAO {
	
	//dodawanie rozwiązania do bazy - używamy na obiekcie klasy Solution
		public static void saveSolutionToDB(Connection conn, Solution solution) throws SQLException {
			if (solution.getId() == 0) { //jeśli id = 0 to znaczy że tworzymy nowe rozwiązanie
				String sql = "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
				String generatedColumns[] = { "ID" }; //dowiadujemy się jakie było ID ostatniego rzędu
				PreparedStatement preparedStatement;
				preparedStatement = conn.prepareStatement(sql, generatedColumns);
				preparedStatement.setString(1, solution.getCreated()); //solution.getCreated()
				preparedStatement.setString(2, solution.getUpdated()); //this.updated
				preparedStatement.setString(3, solution.getDescription()); //this.description
				preparedStatement.setInt(4, solution.getExercise_id()); //this.exercise_id
				preparedStatement.setInt(5, solution.getUsers_id()); //this.users_id
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					solution.setId(rs.getInt(1)); //this.id = rs.getInt(1)
				}
			}else { //jeśli inne niż zero to uaktualniamy
				String sql = "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, users_id = ? WHERE id = ?";
				PreparedStatement preparedStatement;
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, solution.getCreated());
				preparedStatement.setString(2, solution.getUpdated());
				preparedStatement.setString(3, solution.getDescription());
				preparedStatement.setInt(4, solution.getExercise_id());
				preparedStatement.setInt(5, solution.getUsers_id());
				preparedStatement.setInt(6, solution.getId());
				preparedStatement.executeUpdate();
			}
		}	
			
		//wczytywanie rozwiązania po ID - metoda statyczna więc używamy już na klasie, nie na obiekcie	
		static public Solution loadSolutionById(Connection conn, int id) throws SQLException {
			String sql = "SELECT * FROM solution WHERE id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id")); //loadedSolution.id
				loadedSolution.setCreated(resultSet.getString("created"));//loadedSolution.created
				loadedSolution.setUpdated(resultSet.getString("updated"));//loadedSolution.updated
				loadedSolution.setDescription(resultSet.getString("description"));//loadedSolution.description
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));//loadedSolution.exercise_id
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));//loadedSolution.users_id
				return loadedSolution;
			}
			return null;
		}
		
		
		//wczytujemy wszystkie rozwiązania
		static public Solution[] loadAllSolutions(Connection conn) throws SQLException {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			String sql = "SELECT * FROM solution"; PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id"));
				loadedSolution.setCreated(resultSet.getString("created"));
				loadedSolution.setUpdated(resultSet.getString("updated"));
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				solutions.add(loadedSolution);
			}
			Solution[] sArray = new Solution[solutions.size()];
			sArray = solutions.toArray(sArray);
			return sArray;
		}
		
		
		//wczytujemy wszystkie rozwiązania - przyjmujemy parametr ile ich zwrócić, sortujemy od najnowszego dodanego
		static public Solution[] loadAllSolutions(Connection conn, int howMany) throws SQLException {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			String sql = "SELECT * FROM solution ORDER BY created DESC LIMIT ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, howMany);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id"));
				loadedSolution.setCreated(resultSet.getString("created"));
				loadedSolution.setUpdated(resultSet.getString("updated"));
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				solutions.add(loadedSolution);
			}
			Solution[] sArray = new Solution[solutions.size()];
			sArray = solutions.toArray(sArray);
			return sArray;
		}
		
		
		//kasujemy rozwiązanie z bazy - musimy użyć na obiekcie z klasy Solution
		public static void solutionDelete(Connection conn, Solution solution) throws SQLException {
			if (solution.getId() != 0) {
				String sql = "DELETE FROM solution WHERE id = ?";
				PreparedStatement preparedStatement;
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, solution.getId());
				preparedStatement.executeUpdate();
				solution.setId(0);
			}
		}


		
		
		
		
		
		
		// zadanie 5.1
		
		
		//wczytywanie wszystkich rozwiązań po ID użytkownika - metoda statyczna więc używamy już na klasie, nie na obiekcie	
		static public Solution[] loadAllByUserId(Connection conn, int users_id) throws SQLException {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			String sql = "SELECT * FROM solution WHERE users_id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, users_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id"));
				loadedSolution.setCreated(resultSet.getString("created"));
				loadedSolution.setUpdated(resultSet.getString("updated"));
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				solutions.add(loadedSolution);
			}
			
			Solution[] sArray = new Solution[solutions.size()];
			sArray = solutions.toArray(sArray);
			return sArray;

		}
		
		
		
		
		
		
		// zadanie 5.2
		
		//pobranie wszystkich rozwiązań danego zadania posortowanych od najnowszego do
		//	najstarszego (dopisz metodę loadAllByExerciseId do klasy Solution )
		
		
		//wczytywanie wszystkich rozwiązań o danym ID posortowanych od najnowszego - metoda statyczna więc używamy już na klasie, nie na obiekcie	
		static public Solution[] loadAllByExerciseId(Connection conn, int exercise_id) throws SQLException {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			String sql = "SELECT * FROM solution WHERE exercise_id = ? ORDER BY created ASC";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, exercise_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id"));
				loadedSolution.setCreated(resultSet.getString("created"));
				loadedSolution.setUpdated(resultSet.getString("updated"));
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				solutions.add(loadedSolution);
			}
			
			Solution[] sArray = new Solution[solutions.size()];
			sArray = solutions.toArray(sArray);
			return sArray;

		}
		
		
		
		
		//Zadanie program użytkownika 1 - dorobiona przeze mnie metoda która sprawdza czy rozwiązanie o danym id użytkownika o danym id jest już w bazie
		
		//wczytujemy wszystkie ćwiczenia o podanym id dodane przez użytkownika o podanym id
		static public boolean isSolutionToThisExerciseByThisUserInDatabase(Connection conn, int exercise_id, int users_id) throws SQLException {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			String sql = "SELECT * FROM solution WHERE description IS NOT NULL AND exercise_id = ? AND users_id = ?"; 
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, exercise_id);
			preparedStatement.setInt(2, users_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id"));
				loadedSolution.setCreated(resultSet.getString("created"));
				loadedSolution.setUpdated(resultSet.getString("updated"));
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				solutions.add(loadedSolution);
			}
			Solution[] sArray = new Solution[solutions.size()];
			sArray = solutions.toArray(sArray);
			
			if (sArray.length > 0) {
				return true;
			} else {
				return false;
			}
		
		}
		
		
		// zadanie 5.1
		
		
		//wczytywanie wszystkich rozwiązań po ID użytkownika - metoda statyczna więc używamy już na klasie, nie na obiekcie	
		static public Solution[] loadAllMissingSolutionsByUserId(Connection conn, int users_id) throws SQLException {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			String sql = "SELECT * FROM solution WHERE description IS NULL AND users_id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, users_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id"));
				loadedSolution.setCreated(resultSet.getString("created"));
				loadedSolution.setUpdated(resultSet.getString("updated"));
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				solutions.add(loadedSolution);
			}
			
			Solution[] sArray = new Solution[solutions.size()];
			sArray = solutions.toArray(sArray);
			return sArray;

		}
		
		
		
		//wczytywanie rozwiązania po users_ID i ExerciseId - do tego aby zmiana rozwiązania  przez ucznia modyfikowała zadanie nauczyciela a nie tworzyłą nowe - metoda statyczna więc używamy już na klasie, nie na obiekcie	
		static public Solution loadSolutionByUserIdAndExerciseId(Connection conn, int users_id, int exercise_id) throws SQLException {
			String sql = "SELECT * FROM solution WHERE users_id = ? AND exercise_id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, users_id);
			preparedStatement.setInt(2, exercise_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.setId(resultSet.getInt("id"));
				loadedSolution.setCreated(resultSet.getString("created"));
				loadedSolution.setUpdated(resultSet.getString("updated"));
				loadedSolution.setDescription(resultSet.getString("description"));
				loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
				loadedSolution.setUsers_id(resultSet.getInt("users_id"));
				return loadedSolution;
			}
			return null;
		}

}
