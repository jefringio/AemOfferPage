package com.auki.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


import com.auki.services.PageCreateService;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DynamicOfferModel {
	
	@Inject
	private PageCreateService pageCreateService;
	
	 @PostConstruct
	    protected void init() {
		 
		
	 }

	
}
