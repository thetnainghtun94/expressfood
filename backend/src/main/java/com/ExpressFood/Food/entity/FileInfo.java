package com.ExpressFood.Food.entity;

public class FileInfo {
	
	  private String name;
	  private String url;
	  
	  public FileInfo() {
		  
	  }

	public FileInfo(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}



}
