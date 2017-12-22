package by.rudzko.likeit.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -764555741254524099L;
	private int id;
	private String login;
	private String password;
	private String role;
	private int rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (rating != user.rating) return false;
		if (!login.equals(user.login)) return false;
		if (!password.equals(user.password)) return false;
		return role != null ? role.equals(user.role) : user.role == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + login.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + (role != null ? role.hashCode() : 0);
		result = 31 * result + rating;
		return result;
	}
}
