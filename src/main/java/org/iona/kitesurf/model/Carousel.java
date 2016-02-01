package org.iona.kitesurf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Carousel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String caption;

	@Enumerated
	private Menu menu;

	@OneToOne(cascade = CascadeType.ALL)
	private ImageFile image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ImageFile getImage() {
		return image;
	}

	public void setImage(ImageFile image) {
		this.image = image;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Carousel [id=" + id + ", caption=" + caption + ", menu=" + menu + ", image=" + image + "]";
	}
}
