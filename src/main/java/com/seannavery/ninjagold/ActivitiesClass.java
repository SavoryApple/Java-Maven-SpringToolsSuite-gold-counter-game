package com.seannavery.ninjagold;

import java.util.ArrayList;

public class ActivitiesClass extends HomeController{

	private ArrayList<String> messages;
	
	public ActivitiesClass() {
		this.messages = new ArrayList<String>();
	}

	public ArrayList<String> getMessages() {
		return messages;
	}



	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}



	public void addMessage(String activity) {
		this.messages.add(activity);
	}
}
