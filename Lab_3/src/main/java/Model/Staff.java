package Model;

import java.util.Date;

public class Staff {

	private String fullName, photoFile, country, note;
	private String hobbies[];
	private Date birthday;
	private boolean gender, married;

	public Staff() {

	}

	public Staff(String fullName, String photoFile, String country, String note, String[] hobbies, Date birthday,
			boolean gender, boolean married) {
		super();
		this.fullName = fullName;
		this.photoFile = photoFile;
		this.country = country;
		this.note = note;
		this.hobbies = hobbies;
		this.birthday = birthday;
		this.gender = gender;
		this.married = married;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(String photoFile) {
		this.photoFile = photoFile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

}
