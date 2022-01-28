package com.telusko.springmvcboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import com.telusko.springmvcboot.model.Alien;


@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}

		
	@RequestMapping("addAlien")
	public String add(@ModelAttribute Alien a) {
			repo.save(a);
			return "result";

	}
	
	@GetMapping("getAlien")
	public String getAliens(@RequestParam int id, Model m) {
		m.addAttribute("result",repo.getOne(id));
		return "show";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		m.addAttribute("result",repo.findAll());
		return "show";
	}
	
}
