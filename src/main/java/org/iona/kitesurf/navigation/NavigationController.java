package org.iona.kitesurf.navigation;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.iona.kitesurf.model.ImageFile;
import org.iona.kitesurf.model.NavigationMenu;
import org.iona.kitesurf.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/navigation")
public class NavigationController {

	@Autowired
	NavigationService navigationService;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public List<NavigationMenu> getMenuItems() {
		List<NavigationMenu> menu = new ArrayList<>();

		menu.add(new NavigationMenu("Home", "#home"));
		menu.add(new NavigationMenu("About", "#about"));
		NavigationMenu lessonMenu = new NavigationMenu("Lessons", "#lessons");
		lessonMenu.addSubmenu(new NavigationMenu("Free taste", "#freeTaste"));
		lessonMenu.addSubmenu(new NavigationMenu("Introduction", "#introduction"));
		lessonMenu.addSubmenu(new NavigationMenu("Module1", "#module1"));
		lessonMenu.addSubmenu(new NavigationMenu("Module2", "#module2"));
		lessonMenu.addSubmenu(new NavigationMenu("Module3", "#module3"));
		lessonMenu.addSubmenu(new NavigationMenu("Next level", "#next-level"));
		lessonMenu.addSubmenu(new NavigationMenu("FAQ", "#faq"));

		menu.add(lessonMenu);
		menu.add(new NavigationMenu("Gallery", "#gallery"));
		menu.add(new NavigationMenu("Video", "#video"));
		menu.add(new NavigationMenu("Store", "#store"));
		menu.add(new NavigationMenu("Travel", "#travel"));
		menu.add(new NavigationMenu("Contact", "#contact"));

		return menu;
	}

	@RequestMapping(value = "/brand", method = RequestMethod.GET)
	public HttpEntity<InputStreamResource> getBrandImagine() {
		ImageFile brand = navigationService.getBrand();
		InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(brand.getContent()));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Disposition", "attachment;filename=\"" + brand.getName() + "\"");
		headers.setContentLength(brand.getContent().length);
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new HttpEntity<InputStreamResource>(inputStreamResource, headers);
	}
}
