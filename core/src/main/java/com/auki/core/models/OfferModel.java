package com.auki.core.models;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;


import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.auki.services.Offerservice;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OfferModel {

	@Inject
	private Offerservice offerservice;
	private  ArrayList<IndividualOffer> newlist = new ArrayList<>();
	
	@PostConstruct
	protected void init() {
		newlist = offerservice.getOffer();
		
	}
	public ArrayList<IndividualOffer> getNewlist() {
		return newlist;
	}
	
}
	
