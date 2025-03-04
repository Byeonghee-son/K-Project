package com.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airport.domain.Top10;
import com.airport.persistence.Top10Repo;

@RestController
public class Top10Controller {
	
	@Autowired
	private Top10Repo top10Repo;
	
	@RequestMapping("/top10s")
	public Iterable<Top10> getTop10s(){
		return top10Repo.findAll();
	}

}
