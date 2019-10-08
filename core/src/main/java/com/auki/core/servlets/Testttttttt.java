package com.auki.core.servlets;

	

	import java.io.IOException;

	import javax.servlet.Servlet;
	import javax.servlet.ServletException;

	import org.osgi.framework.Constants;
	import org.apache.sling.api.SlingHttpServletRequest;
	import org.apache.sling.api.SlingHttpServletResponse;
	import org.apache.sling.api.servlets.HttpConstants;
	import org.apache.sling.api.servlets.SlingAllMethodsServlet;

	import org.osgi.service.component.annotations.Component;

	@Component(service=Servlet.class,
	property={
	        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
	        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
	        "sling.servlet.paths="+ "/bin/check",
	        "sling.servlet.extensions=" + "json"
	})
	public class Testttttttt extends SlingAllMethodsServlet {
		 private static final long serialVersionUID = 1L;
			
			 @Override
			    protected void doPost(final SlingHttpServletRequest req,
			          final SlingHttpServletResponse resp) throws ServletException, IOException {
				 String name = req.getParameter("name");
				 
				 
				 resp.setContentType("application/json");
		 			resp.setCharacterEncoding("utf-8");
		 			
		
				resp.getWriter().write(name);
			
		}

	}



