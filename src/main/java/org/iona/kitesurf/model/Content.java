package org.iona.kitesurf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	@Transient
	private List<String> list;
	
	@Transient
	private List<ImageFile> photo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<ImageFile> getPhoto() {
		return photo;
	}

	public void setPhoto(List<ImageFile> photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", description=" + description + ", list=" + list + "]";
	}
}
