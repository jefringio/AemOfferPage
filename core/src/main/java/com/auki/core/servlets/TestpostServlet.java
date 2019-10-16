package com.auki.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.services.PageCreateService;

@Component(service=Servlet.class,
property={
		Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST,
		"sling.servlet.paths="+ "/bin/check",
		"sling.servlet.extensions=" + "json"
})

public class TestpostServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	
	@Reference
	private PageCreateService pcs;

	@Override
	 protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp)
		      throws ServletException, IOException {
		
		String pageName = req.getParameter("pagename");
		String Offername = req.getParameter("offername");
		String description = req.getParameter("description");
		String startdate = req.getParameter("Startdate");
		String enddate = req.getParameter("Enddate");
		String url = req.getParameter("imagepath");
		
		pcs.CreatePage(pageName,Offername,description,startdate,enddate,url);
		
		JSONObject obj = new JSONObject();
	
		
		try {
			obj.put("name", Offername);
			obj.put("description", description);
			
			obj.put("imagepath", url);
			} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");	
		
		resp.getWriter().write(obj.toString());
	
		}
}