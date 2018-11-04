package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.domain.Support;
import com.service.SupportService;

@Controller
@RequestMapping("/support")
public class SupportController {
	
	@Autowired
	private SupportService supportService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showSupport(@PathVariable("id") int id, Model model) {
		Support support = supportService.getSupport(id);
		model.addAttribute("support", support);
		return "supportDetails";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateSupport(@PathVariable("id") int id, @ModelAttribute("support") Support support, BindingResult result, Model model) {
		if(result.hasErrors() == true) {
			System.out.println("fail bind");
			return "supportDetails";
		}
		support.setId(id);
		supportService.saveSupport(support);
		System.out.println("saved");
		System.out.println(support);
		return "supportDetails";
	}
	
}
