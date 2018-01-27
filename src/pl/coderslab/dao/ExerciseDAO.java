package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.model.Exercise;

public class ExerciseDAO {
	
	
	//dodawanie ćwiczenia do bazy - używamy na obiekcie klasy Exercise
	public static void addExerciseToDB(Connection conn, Exercise exercise) throws SQLException {
		if (exercise.getId() == 0) { //jeśli id = 0 to znaczy że tworzymy nowe ćwiczenie
			String sql = "INSERT INTO exercise(title, description) VALUES (?, ?)";
			String generatedColumns[] = { "ID" }; //dowiadujemy się jakie było ID ostatniego rzędu
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, exercise.getTitle());
			preparedStatement.setString(2, exercise.getDescription());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				exercise.setId(rs.getInt(1));
			}
		}else { //jeśli inne niż zero to uaktualniamy
			String sql = "UPDATE exercise SET title = ?, description = ? WHERE id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, exercise.getTitle());
			preparedStatement.setString(2, exercise.getDescription());
			preparedStatement.setInt(3, exercise.getId());
			preparedStatement.executeUpdate();
		}
	}	
		
	//wczytywanie ćwiczenia po ID - metoda statyczna więc używamy już na klasie, nie na obiekcie	
	static public Exercise loadExerciseById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM exercise WHERE id = ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Exercise loadedExercise = new Exercise();
			loadedExercise.setId(resultSet.getInt("id"));
			loadedExercise.setTitle(resultSet.getString("title"));
			loadedExercise.setDescription(resultSet.getString("description"));
			return loadedExercise;
		}
		return null;
	}
	
	
	//wczytujemy wszystkie ćwiczenia
	static public Exercise[] loadAllExercises(Connection conn) throws SQLException {
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		String sql = "SELECT * FROM exercise";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Exercise loadedExercise = new Exercise();
			loadedExercise.setId(resultSet.getInt("id"));
			loadedExercise.setTitle(resultSet.getString("title"));
			loadedExercise.setDescription(resultSet.getString("description"));
			exercises.add(loadedExercise);
		}
		Exercise[] lArray = new Exercise[exercises.size()];
		lArray = exercises.toArray(lArray);
		return lArray;
	}
	
	
	//kasujemy ćwiczenie z bazy - musimy użyć na obiekcie z klasy Exercise
	public static void exerciseDelete(Connection conn, Exercise exercise) throws SQLException {
		if (exercise.getId() != 0) {
			String sql = "DELETE FROM exercise WHERE id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, exercise.getId());
			preparedStatement.executeUpdate();
			exercise.setId(0);
		}
	}
	
	

	

	
	//Zadanie program użytkownika 1 - dorobiona przeze mnie metoda która pokazuje do jakich zadań użytkownik dodał rozwiązania
	
	//wczytujemy ćwiczenia do których istnieje rozwiązanie
	static public Exercise[] loadAllSolvedExercises(Connection conn, int users_id) throws SQLException {
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		String sql = "SELECT * FROM exercise LEFT JOIN  solution ON exercise.id=solution.exercise_id WHERE solution.users_id = ? ORDER BY exercise.id ASC"; 
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, users_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Exercise loadedExercise = new Exercise();
			loadedExercise.setId(resultSet.getInt("id"));
			loadedExercise.setTitle(resultSet.getString("title"));
			loadedExercise.setDescription(resultSet.getString("description"));
			exercises.add(loadedExercise);
		}
		Exercise[] lArray = new Exercise[exercises.size()];
		lArray = exercises.toArray(lArray);
		return lArray;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//ponizsze jest w sumie niepotrzebne bo zle zrozumialem tresc zadania
	
	//Zadanie program użytkownika 1 - dorobiona przeze mnie metoda która pokazuje do jakich zadań użytkownik nie dodał rozwiązań
	
	//wczytujemy wszystkie brakujące ćwiczenia
	static public Exercise[] loadAllMissingExercises(Connection conn, int users_id) throws SQLException {
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		String sql = "SELECT * FROM exercise WHERE exercise.id NOT IN (SELECT exercise.id FROM exercise LEFT JOIN  solution ON exercise.id=solution.exercise_id WHERE solution.users_id = ?) ORDER BY exercise.id ASC"; 
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, users_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Exercise loadedExercise = new Exercise();
			loadedExercise.setId(resultSet.getInt("id"));
			loadedExercise.setTitle(resultSet.getString("title"));
			loadedExercise.setDescription(resultSet.getString("description"));
			exercises.add(loadedExercise);
		}
		Exercise[] lArray = new Exercise[exercises.size()];
		lArray = exercises.toArray(lArray);
		return lArray;
	}
	
	

}
