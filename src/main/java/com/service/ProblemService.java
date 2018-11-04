package com.service;

import java.util.List;

import com.domain.Problem;

public interface ProblemService {

	public List<Problem> getAllProblems();

	public void addDescription(int id, String description);

	public void deleteProblem(int id);

	public boolean makeReport();

}
