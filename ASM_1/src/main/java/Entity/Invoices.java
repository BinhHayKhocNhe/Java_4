package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Invoices")
public class Invoices {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name="UserID")
	private int UserID;
	
	@Column(name="TotalAmount")
	private double TotalAmount;
	
	@Column(name="PhoneNumber")
	private String PhoneNumber;
	
	@Column(name="Address")
	private String Address;

	public Invoices() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
