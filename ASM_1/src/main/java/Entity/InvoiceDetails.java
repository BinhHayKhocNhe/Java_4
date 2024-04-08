package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="InvoiceDetails")
public class InvoiceDetails {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name="InvoiceID")
	private int InvoiceID;
	
	@Column(name="ProductID")
	private int ProductID;
	
	@Column(name="Quantity")
	private int Quantity;
	
	@Column(name="Price")
	private double Price;

	public InvoiceDetails() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getInvoiceID() {
		return InvoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		InvoiceID = invoiceID;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
}
