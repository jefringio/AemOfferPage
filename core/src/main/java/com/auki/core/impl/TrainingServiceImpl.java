package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.services.SecondTrainingService;
import com.auki.services.TrainingService;



@Component (service = TrainingService.class , immediate = true)
public class TrainingServiceImpl implements TrainingService {

	@Reference
	private SecondTrainingService test2;
	
	private String returnString;
	
	public String gettitles() {
		returnString = test2.getValue();
		return  "Jefrin " + returnString;
	}

	

}
