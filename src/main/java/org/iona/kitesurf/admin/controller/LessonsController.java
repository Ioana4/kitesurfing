package org.iona.kitesurf.admin.controller;

import org.iona.kitesurf.model.Module;
import org.iona.kitesurf.service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/lessons")
public class LessonsController {
	@Autowired
	private LessonsService lessonService;
	
	@RequestMapping(value = "/module", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveModule(@RequestBody Module module){
		lessonService.save(module);
		return new ModelAndView("redirect:/#/admin/lessons");
	}
}
