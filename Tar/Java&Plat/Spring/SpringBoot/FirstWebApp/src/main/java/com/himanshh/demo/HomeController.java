package com.himanshh.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		return "home";
	}

}*/

/*
 * @Controller public class HomeController {
 * 
 * @RequestMapping("home") public ModelAndView home(@RequestParam("aname")
 * String myName) {
 * 
 * ModelAndView mv = new ModelAndView();
 * 
 * mv.addObject("name", myName); mv.setViewName("home");
 * 
 * return mv; }
 * 
 * }
 */

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
	}
}
