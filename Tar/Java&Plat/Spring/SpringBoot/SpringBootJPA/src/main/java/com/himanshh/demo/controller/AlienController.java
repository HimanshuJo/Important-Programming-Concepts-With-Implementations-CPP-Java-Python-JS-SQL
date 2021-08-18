package com.himanshh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.himanshh.demo.dao.AlienRepo;
import com.himanshh.demo.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home.jsp");
		return mv;
	}

	@RequestMapping("/all")
	public ModelAndView getAllAliens() {
		ModelAndView mv = new ModelAndView("showAllAlien.jsp");
		Iterable<Alien> alien = repo.findAll();
		mv.addObject(alien);
		return mv;
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}

	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		repo.save(alien);
		return "updateAlien.jsp";
	}

	@RequestMapping("/deleteAlien")
	public String deleteAlien(Alien alien) {
		repo.deleteById(alien.getAid());
		return "deleteAlien.jsp";
	}
}
