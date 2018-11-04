package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Problem;
import com.repository.ProblemRepository;
import com.util.ExcelMaker;

@Service
@Transactional
public class ProblemServiceImpl implements ProblemService {

	@Autowired
	private ProblemRepository problemRepository;

	@Autowired
	private ExcelMaker maker;

	@Override
	public List<Problem> getAllProblems() {
		List<Problem> problems = problemRepository.findAll();
		problems.sort((Problem p1, Problem p2) -> p1.getRegion().compareToIgnoreCase(p2.getRegion()));
		return problems;
	}

	@Override
	public void addDescription(int id, String description) {
		Problem problem = problemRepository.getOne(id);
		problem.setDescription(description);
		problemRepository.saveAndFlush(problem);
	}

	@Override
	public void deleteProblem(int id) {
		problemRepository.deleteById(id);
	}

	@Override
	public boolean makeReport() {
		return maker.makeXls(getAllProblems());
	}

}
