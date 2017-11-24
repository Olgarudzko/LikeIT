package by.rudzko.jwd.domain;

public class User {

	private int id;
	private String login;
	private String password;
	private int role;
	private String roleValue;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRoleValue() {
		return roleValue;
	}

	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (role != user.role) return false;
		if (rating != user.rating) return false;
		if (!login.equals(user.login)) return false;
		if (!password.equals(user.password)) return false;
		return roleValue != null ? roleValue.equals(user.roleValue) : user.roleValue == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + login.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + role;
		result = 31 * result + (roleValue != null ? roleValue.hashCode() : 0);
		result = 31 * result + rating;
		return result;
	}
}
