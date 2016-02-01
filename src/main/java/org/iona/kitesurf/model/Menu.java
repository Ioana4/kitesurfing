package org.iona.kitesurf.model;

public enum Menu {
	HOME(0L,"#home"),
	ABOUT(1L,"#about"),
	LESSONS(2L, "#lessons"),
	GALLERY(3L,"#gallery"),
	VIDEO(4L,"#video"),
	STORE(5L,"#store"),
	TRAVEL(6L,"#travel"),
	CONTACT(7L, "#contact");
	
	private Menu(Long id, String targetUrl) {
		this.id = id;
		this.targetUrl = targetUrl;
	}

	private Long id;
	
	private String targetUrl;

	public Long getId() {
		return id;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public static Menu findById(Long menuId) {
		for(Menu menu : values()){
			if(menu.getId() == menuId){
				return menu;
			}
		}
		return null;
	}	
}
