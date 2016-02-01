package org.iona.kitesurf.navigation;

import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
public class RoutesController {

	@RequestMapping({
        "/home",
        "/about"
    })
	public String index(){
		return "forward:/index.html";
	}
	

}
