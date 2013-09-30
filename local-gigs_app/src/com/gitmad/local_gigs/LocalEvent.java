package com.gitmad.local_gigs;

public class LocalEvent {

	private String title;
	private String description;
	private String startDate;
	private String endDate;
	
	public LocalEvent(String title, String description, String startDate, String endDate)
	{
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStartDate()
	{
		return this.startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	
	public String getEndDate()
	{
		return this.endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

}
