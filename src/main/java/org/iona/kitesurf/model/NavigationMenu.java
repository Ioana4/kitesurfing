package org.iona.kitesurf.model;

import java.util.ArrayList;
import java.util.List;

public class NavigationMenu  {
	private String label;
	private String link;

	private List<NavigationMenu> submenu = new ArrayList<>();

	public NavigationMenu() {
		super();
	}

	public NavigationMenu(String name, String link) {
		super();
		this.label = name;
		this.link = link;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<NavigationMenu> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<NavigationMenu> submenu) {
		this.submenu = submenu;
	}

	public void addSubmenu(NavigationMenu menu) {
		submenu.add(menu);

	}
}
