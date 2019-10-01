package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;

import com.auki.services.SecondTrainingService;


@Component (service = SecondTrainingService.class , immediate = true)
public class SecondTrainigImpl implements SecondTrainingService {

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "Second Value";
	}
	
	
}
