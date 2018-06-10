package com.assign1.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timeStamp;
	private String message;
	private String description;

	public ErrorDetails(Date timeStamp, String message, String description) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}
	
	
}
