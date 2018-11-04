package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.domain.Problem;
import com.service.ProblemService;

@Controller
@RequestMapping("/")
public class ProblemController {

	private static final Logger LOG = LoggerFactory.getLogger(ProblemController.class);
	
	@Autowired
	private ProblemService problemService;

	@RequestMapping(method = RequestMethod.GET)
	public String getStatistic(Model model) {
		List<Problem> problems = problemService.getAllProblems();
		model.addAttribute("problems", problems);
		return "index";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteNode(@PathVariable("id") int id) {
		problemService.deleteProblem(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	@ResponseStatus(value = HttpStatus.OK)
	public void addDesc(@RequestParam("description") String description, @RequestParam("id") int id) {
		problemService.addDescription(id, description);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/report")
	public ResponseEntity createReport() {
		boolean result = problemService.makeReport();
		
		if(result) {
			return new ResponseEntity(HttpStatus.CREATED);
		}
		
		LOG.error("can't create report ");
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
