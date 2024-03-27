package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "Password")
	private String password;

	@Column(name = "Fullname")

	private String fullname;

	@Column(name = "Email")

	private String email;

	@Column(name = "Role")
	private Boolean role;

	public User() {

	}

	public User(String id, String password, String fullname, String email, Boolean role) {
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

}
