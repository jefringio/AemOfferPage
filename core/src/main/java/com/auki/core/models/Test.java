package com.auki.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

import com.auki.services.TrainingService;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Test {
//	 @Inject 
//	 private String image;
	
	@Inject
	private ResourceResolver resourceResolver;
	
	@Inject 
	private Resource name;
	
	@Inject
	 private String dates;
	
	@Inject
	private String description;

	@Inject
	private TrainingService train;

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Resource getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	
	
	@PostConstruct
	protected void init() {
		
//		description = train.gettitles();
		Resource resource=resourceResolver.getResource("/content/auki/test/offer-landing-page/offer-1/jcr:content/root/offer");
		name=resource;
		
	}
	

}
