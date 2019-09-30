package com.auki.core.models;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import com.adobe.cq.sightly.WCMUsePojo;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Test extends WCMUsePojo {
//	 @Inject 
//	 private String image;
	@Inject 
	private String name;
	@Inject
	 private String dates;
	@Inject
	private String description;
	
	
	
//	public String getImage() {
//		return image;
//	}
//	public void setImage(String image) {
//		this.image = image;
//	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 @Override  
	    public void activate() {  
		    Calendar date  = get("date", Calendar.class);  
		      
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    dates =(formatter.format(date.getTime()));  
	    }
	public String getDates() {
		return dates;
	}
	    
	
	

}
