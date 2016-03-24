package org.iona.kitesurf.admin.controller;

import org.iona.kitesurf.service.HomeService;
import org.iona.kitesurf.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {

	@Autowired
	private HomeService homeService;
	
	@Autowired
	private NavigationService navigationService;
	

	@RequestMapping(value = "/carousel", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView upload(@RequestParam String caption, @RequestParam Long menuId, @RequestParam MultipartFile file) {
		if (!file.isEmpty()) {
			homeService.saveCarousel(caption, menuId, file);
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/#/admin/home?testParam=test");
		modelAndView.getModelMap().addAttribute("messageResponse", "Carousel item a fost salvat cu success");
		
		
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/brand", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateBrand(@RequestParam MultipartFile file){
		
		navigationService.updateBrand(file); 
		
		ModelAndView modelAndView = new ModelAndView("redirect:/#/admin/home?testParam=test");
		return modelAndView;
		
	}
}
