package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Products {
	
	@Id
	@Column(name="ProductID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ProductID;

	@Column(name="ProductName")
	private String ProductName;
	
	@Column(name="Price")
	private double Price;
	
	@Column(name="ImageURL")
	private String ImageURL;
	
	@Column(name="Quantity")
	private int Quantity;
	
	@Column(name="CategoryID")
	private String CategoryID;
	
	@Column(name="Sale")
	private float Sale;
	
	@Column(name="Note")
	private String Note;

	public Products() {

	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}

	public float getSale() {
		return Sale;
	}

	public void setSale(float sale) {
		Sale = sale;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

}
