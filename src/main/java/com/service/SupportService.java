package com.service;

import com.domain.Support;

public interface SupportService {

	public Support getSupport(Integer id);
	
	public void saveSupport(Support support);
	
}
