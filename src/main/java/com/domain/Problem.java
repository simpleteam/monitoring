package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "problems")
public class Problem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "date")
	private String date;
	@Column(name = "time_down")
	private String timeDown;
	@Column(name = "time_up")
	private String timeUp;
	@Column(name = "court")
	private String court;
	@Column(name = "region")
	private String region;
	@Column(name = "problem")
	private String problem;
	@Column(name = "status")
	private String status;
	@Column(name = "support")
	private String support;
	@Column(name = "description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeDown() {
		return timeDown;
	}

	public void setTimeDown(String timeDown) {
		this.timeDown = timeDown;
	}

	public String getTimeUp() {
		return timeUp;
	}

	public void setTimeUp(String timeUp) {
		this.timeUp = timeUp;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
