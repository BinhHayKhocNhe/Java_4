package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categories {
	
	@Id
	private String CategoryID;
	
	private String CategoryName;
	private String Note;

	public String getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public Categories() {

	}

}
