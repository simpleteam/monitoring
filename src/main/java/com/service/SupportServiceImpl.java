package com.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Email;
import com.domain.Phone;
import com.domain.Support;
import com.repository.SupportRepository;

@Service
@Transactional
public class SupportServiceImpl implements SupportService {

	@Autowired
	private SupportRepository supportRepository;
	
	
	@Override
	public Support getSupport(Integer id) {
		Support support = supportRepository.getOne(id);
		if(support.getEmails().size() == 0) {
			Email email = new Email();
			support.setEmails(Stream.of(email).collect(Collectors.toList()));
		}
		if(support.getPhones().size() == 0) {
			Phone phone = new Phone();
			support.setPhones(Stream.of(phone).collect(Collectors.toList()));
		}
		return support;
	}

	@Override
	public void saveSupport(Support support) {
		support.getEmails().forEach(m -> m.setSupport(support));
		support.getPhones().forEach(m -> m.setSupport(support));
		supportRepository.save(support);
	}

}
