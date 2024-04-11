package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Carts {

	@Id
	@Column(name = "CartID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartID;

	@Column(name = "ID_User")
	private int ID_User;

	@Column(name = "ProductID")
	private int ProductID;

	@Column(name = "Quantity")
	private int Quantity;

	@Column(name = "Price")
	private double Price;

	public Carts() {
	}

	public int getCartID() {
		return CartID;
	}

	public void setCartID(int cartID) {
		CartID = cartID;
	}

	public int getID_User() {
		return ID_User;
	}

	public void setID_User(int iD_User) {
		ID_User = iD_User;
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
