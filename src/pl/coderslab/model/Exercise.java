package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Exercise {
	
	private int id;
	private String title;
	private String description;
	
	public Exercise(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public Exercise() {}
	
	
	
	

	public int getId() {
		return id;
	}
	


	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
//	
//	
//	
//	
//	
//	
//	
//	//dodawanie ćwiczenia do bazy - używamy na obiekcie klasy Exercise
//	public void addExerciseToDB(Connection conn) throws SQLException {
//		if (this.id == 0) { //jeśli id = 0 to znaczy że tworzymy nowe ćwiczenie
//			String sql = "INSERT INTO exercise(title, description) VALUES (?, ?)";
//			String generatedColumns[] = { "ID" }; //dowiadujemy się jakie było ID ostatniego rzędu
//			PreparedStatement preparedStatement;
//			preparedStatement = conn.prepareStatement(sql, generatedColumns);
//			preparedStatement.setString(1, this.title);
//			preparedStatement.setString(2, this.description);
//			preparedStatement.executeUpdate();
//			ResultSet rs = preparedStatement.getGeneratedKeys();
//			if (rs.next()) {
//				this.id = rs.getInt(1);
//			}
//		}else { //jeśli inne niż zero to uaktualniamy
//			String sql = "UPDATE exercise SET title = ?, description = ? WHERE id = ?";
//			PreparedStatement preparedStatement;
//			preparedStatement = conn.prepareStatement(sql);
//			preparedStatement.setString(1, this.title);
//			preparedStatement.setString(2, this.description);
//			preparedStatement.setInt(3, this.id);
//			preparedStatement.executeUpdate();
//		}
//	}	
//		
//	//wczytywanie ćwiczenia po ID - metoda statyczna więc używamy już na klasie, nie na obiekcie	
//	static public Exercise loadExerciseById(Connection conn, int id) throws SQLException {
//		String sql = "SELECT * FROM exercise WHERE id = ?";
//		PreparedStatement preparedStatement;
//		preparedStatement = conn.prepareStatement(sql);
//		preparedStatement.setInt(1, id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		if (resultSet.next()) {
//			Exercise loadedExercise = new Exercise();
//			loadedExercise.id = resultSet.getInt("id");
//			loadedExercise.title = resultSet.getString("title");
//			loadedExercise.description = resultSet.getString("description");
//			return loadedExercise;
//		}
//		return null;
//	}
//	
//	
//	//wczytujemy wszystkie ćwiczenia
//	static public Exercise[] loadAllExercises(Connection conn) throws SQLException {
//		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
//		String sql = "SELECT * FROM exercise";
//		PreparedStatement preparedStatement;
//		preparedStatement = conn.prepareStatement(sql);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		while (resultSet.next()) {
//			Exercise loadedExercise = new Exercise();
//			loadedExercise.id = resultSet.getInt("id");
//			loadedExercise.title = resultSet.getString("title");
//			loadedExercise.description = resultSet.getString("description");
//			exercises.add(loadedExercise);
//		}
//		Exercise[] lArray = new Exercise[exercises.size()];
//		lArray = exercises.toArray(lArray);
//		return lArray;
//	}
//	
//	
//	//kasujemy ćwiczenie z bazy - musimy użyć na obiekcie z klasy Exercise
//	public void exerciseDelete(Connection conn) throws SQLException {
//		if (this.id != 0) {
//			String sql = "DELETE FROM exercise WHERE id = ?";
//			PreparedStatement preparedStatement;
//			preparedStatement = conn.prepareStatement(sql);
//			preparedStatement.setInt(1, this.id);
//			preparedStatement.executeUpdate();
//			this.id=0;
//		}
//	}
//	
//	
//	
//	//zadanie 5 - loadAllByUserId - to powinno być w klasie solution, nie exercise, więc tam dodałem
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	//Zadanie program użytkownika 1 - dorobiona przeze mnie metoda która pokazuje do jakich zadań użytkownik dodał rozwiązania
//	
//	//wczytujemy ćwiczenia do których istnieje rozwiązanie
//	static public Exercise[] loadAllSolvedExercises(Connection conn, int users_id) throws SQLException {
//		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
//		String sql = "SELECT * FROM exercise LEFT JOIN  solution ON exercise.id=solution.exercise_id WHERE solution.users_id = ? ORDER BY exercise.id ASC"; 
//		PreparedStatement preparedStatement;
//		preparedStatement = conn.prepareStatement(sql);
//		preparedStatement.setInt(1, users_id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		while (resultSet.next()) {
//			Exercise loadedExercise = new Exercise();
//			loadedExercise.id = resultSet.getInt("id");
//			loadedExercise.title = resultSet.getString("title");
//			loadedExercise.description = resultSet.getString("description");
//			exercises.add(loadedExercise);
//		}
//		Exercise[] lArray = new Exercise[exercises.size()];
//		lArray = exercises.toArray(lArray);
//		return lArray;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	//ponizsze jest w sumie niepotrzebne bo zle zrozumialem tresc zadania
//	
//	//Zadanie program użytkownika 1 - dorobiona przeze mnie metoda która pokazuje do jakich zadań użytkownik nie dodał rozwiązań
//	
//	//wczytujemy wszystkie brakujące ćwiczenia
//	static public Exercise[] loadAllMissingExercises(Connection conn, int users_id) throws SQLException {
//		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
//		String sql = "SELECT * FROM exercise WHERE exercise.id NOT IN (SELECT exercise.id FROM exercise LEFT JOIN  solution ON exercise.id=solution.exercise_id WHERE solution.users_id = ?) ORDER BY exercise.id ASC"; 
//		PreparedStatement preparedStatement;
//		preparedStatement = conn.prepareStatement(sql);
//		preparedStatement.setInt(1, users_id);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		while (resultSet.next()) {
//			Exercise loadedExercise = new Exercise();
//			loadedExercise.id = resultSet.getInt("id");
//			loadedExercise.title = resultSet.getString("title");
//			loadedExercise.description = resultSet.getString("description");
//			exercises.add(loadedExercise);
//		}
//		Exercise[] lArray = new Exercise[exercises.size()];
//		lArray = exercises.toArray(lArray);
//		return lArray;
//	}
//	
//	
//	
//	
//	
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	
//	
//	
//	
	
	
}
