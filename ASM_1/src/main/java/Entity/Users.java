package Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Users")
//, uniqueConstraints = { @UniqueConstraint(columnNames = { "Username" }),
//		@UniqueConstraint(columnNames = { "Email" }), @UniqueConstraint(columnNames = { "Phone" }) }
public class Users {

	@Id
	@Column(name = "ID_User")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_User;

	@Column(name = "Username")
	private String Username;

	@Column(name = "Password")
	private String Password;

	@Column(name = "Fullname")
	private String Fullname;

	@Column(name = "Email")
	private String Email;

	@Column(name = "Phone")
	private String Phone;

	@Column(name = "Gender")
	private boolean Gender;

	@Column(name = "Birthday")
	@Temporal(TemporalType.DATE)
	private Date Birthday = new Date();;

	@Column(name = "Role")
	private String Role;

	public Users() {

	}

	public int getID_User() {
		return ID_User;
	}

	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public boolean isGender() {
		return Gender;
	}

	public void setGender(boolean gender) {
		Gender = gender;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Users(String username, String password, String fullname, String email, String phone, boolean gender,
			Date birthday, String role) {
		Username = username;
		Password = password;
		Fullname = fullname;
		Email = email;
		Phone = phone;
		Gender = gender;
		Birthday = birthday;
		Role = role;
	}

}
