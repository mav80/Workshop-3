package pl.coderslab.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class SolutionOrgObsolete {
	private int id;
	private Date created;
	private Date updated;
	private String description;
	private int exercise_id;
	private int users_id;
	
	
	public SolutionOrgObsolete() {}

	public SolutionOrgObsolete(int id, Date created, Date updated, String description, int exercise_id,
			int users_id) {
		super();
		this.id = id;
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.exercise_id = exercise_id;
		this.users_id = users_id;
	}


	
	
	
//	public int getExercise_id() {
//		return exercise_id;
//	}
//	public void setExercise_id(int exercise_id) {
//		this.exercise_id = exercise_id;
//	}
//	public int getUsers_id() {
//		return users_id;
//	}
//	public void setUsers_id(int user_id) {
//		this.users_id = user_id;
//	}
//	public int getId() {
//		return id;
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	
	
	

}
