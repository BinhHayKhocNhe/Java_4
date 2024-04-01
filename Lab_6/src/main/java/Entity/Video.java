package Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "Videos")
public class Video {
	@GeneratedValue
	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Poster")
	private String poster;

	@Column(name = "Description")
	private String description;

	@Column(name = "Views")
	private int views = 0;

	@Column(name = "Active")
	private Boolean active = true;

	@Column(name = "Category")
	private String category;

	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites;

	public Video(String id, String title, String poster, String description, int views, Boolean active, String category,
			List<Favorite> favorites) {
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.description = description;
		this.views = views;
		this.active = active;
		this.category = category;
		this.favorites = favorites;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Video() {

	}

}
