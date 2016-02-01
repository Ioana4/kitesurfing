package org.iona.kitesurf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Gallery {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Integer displayOrder;

	@OneToOne(cascade = CascadeType.ALL)
	private ImageFile image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public ImageFile getImage() {
		return image;
	}

	public void setImage(ImageFile image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Gallery [id=" + id + ", order=" + displayOrder + "]";
	}
}
