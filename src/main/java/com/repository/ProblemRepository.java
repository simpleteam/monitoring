package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

}
