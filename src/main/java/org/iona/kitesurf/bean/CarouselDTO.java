package org.iona.kitesurf.bean;

public class CarouselDTO {
	private Long id;
	private String caption;
	private String targetUrl;
	
	
	
	public CarouselDTO(Long id, String caption, String targetUrl) {
		super();
		this.id = id;
		this.caption = caption;
		this.targetUrl = targetUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	@Override
	public String toString() {
		return "CarouselDTO [id=" + id + ", caption=" + caption + ", targetUrl=" + targetUrl + "]";
	}
	
	
	

}
