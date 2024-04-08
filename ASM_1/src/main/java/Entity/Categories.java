package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Categories {
	
	@Id
	@Column(name="CategoryID")
	private String CategoryID;
	
	@Column(name="CategoryName")
	private String CategoryName;
	
	@Column(name="Note")
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
