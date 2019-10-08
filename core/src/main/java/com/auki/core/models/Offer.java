package com.auki.core.models;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.day.cq.wcm.api.Page;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Offer {

	@Inject
	private ResourceResolver resourceResolver;
	private  ArrayList<IndividualOffer> newlist = new ArrayList<>();
	
	@PostConstruct
	protected void init() {
		try {
			Resource resource=resourceResolver.getResource("/content/auki/test/offer-landing-page");
			Page homepage = resource.adaptTo(Page.class);
			Iterator<Page> childpage = homepage.listChildren();
			
			while(childpage.hasNext()) {
				String name = childpage.next().getName();
				String link = "/content/auki/test/offer-landing-page/"+ name;
				resource=resourceResolver.getResource("/content/auki/test/offer-landing-page/"+ name+"/jcr:content/root/offer");
				ValueMap values = resource.adaptTo(ValueMap.class);
				String image = values.get("fileReference",String.class);
				String title = values.get("title",String.class);
				String description = values.get("description",String.class);
				String sdate = values.get("startValidPeriod",String.class);
				String edate = values.get("endValidPeriod",String.class);
				
				IndividualOffer newoffer = new IndividualOffer(image,title,description,sdate,edate,link,name);
				newlist.add(newoffer);
				
			}
		}
		catch(Exception e){
			
		}
		
	}
	
	public ArrayList<IndividualOffer> getOfferarraylist(){
		return newlist;
		
	}
	
	
}
