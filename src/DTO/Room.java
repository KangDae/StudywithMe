package DTO;

import java.util.ArrayList;

import Server.ServerHandler;

public class Room {
	private int rID;
	private String title;
	private String userCount;
	private String masterName;
	private String subject;
	
	public ArrayList<ServerHandler> roomInUserList;
	
	public Room() {
		this.rID = 0;
		this.title = "";
		this.userCount = "";
		this.masterName = "";
		this.subject = "";	
		roomInUserList = new ArrayList<ServerHandler>();
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserCount() {
		return userCount;
	}

	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public ArrayList<ServerHandler> getRoomInUserList() {
		return roomInUserList;
	}

	public void setRoomInUserList(ArrayList<ServerHandler> roomInUserList) {
		this.roomInUserList = roomInUserList;
	}

	@Override
	public String toString() {
		return "Room [rID=" + rID + ", title=" + title + ", userCount=" + userCount
				+ ", masterName=" + masterName + ", subject=" + subject + "]";
	}
}
