package org.iona.kitesurf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	@OneToMany
	@JoinColumn(name="id")
	private List<ImageFile> photos;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Content> content;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Chapter> subchapters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ImageFile> getPhotos() {
		return photos;
	}

	public void setPhotos(List<ImageFile> photos) {
		this.photos = photos;
	}

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

	public List<Chapter> getSubchapters() {
		return subchapters;
	}

	public void setSubchapters(List<Chapter> subchapters) {
		this.subchapters = subchapters;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", title=" + title + ", content=" + content + ", subchapters=" + subchapters + "]";
	}

}
