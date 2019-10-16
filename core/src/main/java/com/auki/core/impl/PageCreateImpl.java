package com.auki.core.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


import com.auki.services.PageCreateService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = PageCreateService.class, immediate=true)

public class PageCreateImpl implements PageCreateService {
	 private String user = "";
     
	    private Session session;
	
	    //Inject a Sling ResourceResolverFactory
	    @Reference
	    private ResourceResolverFactory resourceResolverFactory;
	     
	   public String CreatePage(String pageName,String OfferName,String description,String startdate,String enddate,String url) 
	    {
	    String pagePath = "/content/auki/test/offer-landing-page";
	    String templatePath = "/conf/auki/settings/wcm/templates/induvidual-offers";
	    String pageTitle = pageName;
	    Page newPage;
	    PageManager pageManager; 
	     
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
	                  
	        //Invoke the adaptTo method to create a Session 
	      
	    	 session = resourceResolver.adaptTo(Session.class);
	        pageManager = resourceResolver.adaptTo(PageManager.class); 
	        newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
	        
	        if (newPage != null) {
	        	Node newNode = newPage.adaptTo(Node.class);
	        	Node cont = newNode.getNode("jcr:content");
	        	Node offerNode = JcrUtils.getNodeIfExists(cont, "root/offer");
	        	offerNode.setProperty("title", OfferName);
	        	offerNode.setProperty("description", description);
	        	offerNode.setProperty("startValidPeriod", startdate);
	        	offerNode.setProperty("endValidPeriod", enddate);
	        	offerNode.setProperty("fileReference", url);
	        	session.save();
	        }
	        
//	       
//	         
	        return pageName; 
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	     
	    return ""  ; 
	 
	}
	 
	}


