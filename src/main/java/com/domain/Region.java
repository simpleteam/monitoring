package com.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@ManyToMany
	@JoinTable(name = "region_support", joinColumns = { @JoinColumn(name = "region_id") }, inverseJoinColumns = {
			@JoinColumn(name = "support_id") })
	private List<Support> supports;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Support> getSupports() {
		return supports;
	}

	public void setSupports(List<Support> support) {
		this.supports = support;
	}

}
