package com.auki.core.models;


public class IndividualOffer  {
	
	private String fileReference;
	private String title;
	private String description;
	private String startValidPeriod;
	private String endValidPeriod;
	private String links;
	private String name;
	
	
	public IndividualOffer(String fileReference, String title, String description, String startValidPeriod,
			String endValidPeriod, String links, String name) {
		super();
		this.fileReference = fileReference;
		this.title = title;
		this.description = description;
		this.startValidPeriod = startValidPeriod;
		this.endValidPeriod = endValidPeriod;
		this.links = links;
		this.name=name;
	}
	public String getFileReference() {
		return fileReference;
	}
	public void setFileReference(String fileReference) {
		this.fileReference = fileReference;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartValidPeriod() {
		return startValidPeriod;
	}
	public void setStartValidPeriod(String startValidPeriod) {
		this.startValidPeriod = startValidPeriod;
	}
	public String getEndValidPeriod() {
		return endValidPeriod;
	}
	public void setEndValidPeriod(String endValidPeriod) {
		this.endValidPeriod = endValidPeriod;
	}
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
