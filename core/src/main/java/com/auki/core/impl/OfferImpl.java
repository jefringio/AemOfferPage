package com.auki.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;


import com.auki.core.models.IndividualOffer;
import com.auki.services.Offerservice;
import com.day.cq.wcm.api.Page;


	
	@Component(service = Offerservice.class, immediate=true)
	////////
	@Designate(ocd = OfferImpl.Config.class)
	/////////
	public class OfferImpl implements Offerservice {
///////
		@ObjectClassDefinition(name = "Test config" , description = "Test config properties")
		public static @interface Config{
			
			@AttributeDefinition(name = "path value")
			String path_value() default "/content/auki/test/offer-landing-page";
			
//			@AttributeDefinition(name = "max offer")
//			int max_offer() default 4;
		}
/////////
		@Reference
		private ResourceResolverFactory resourceResolverFactory; 
//////		
		private String pathValue;
//		private int maxOffer;
	
		@Activate
		protected void activate(final Config config) {
			this.pathValue= config.path_value();
//			this.maxOffer= config.max_offer();
		}
		
		
///////	
	   
		public ArrayList<IndividualOffer> getOffer()  {
			int count=0;
			 ArrayList<IndividualOffer> offerList = new ArrayList<>();
			 
			final Map<String, Object> params = new HashMap<>();
			params.put(ResourceResolverFactory.SUBSERVICE, "testing");
			ResourceResolver resourceResolver = null;
			
			try {
				resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Resource resource=resourceResolver.getResource(pathValue);
				Page homepage = resource.adaptTo(Page.class);
				Iterator<Page> childpage = homepage.listChildren();
				
				while(childpage.hasNext() ) {
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
					offerList.add(newoffer);
					count++;
				}
				
			}
			catch(Exception e){
				
			}
			
		return offerList;
	    }
}
		
