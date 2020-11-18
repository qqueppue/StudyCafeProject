package com.user.model;

public class seatDTO {
	private int usernum;
	private int seat;
	private String od_time;
	
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String getOd_time() {
		return od_time == null ? "" : od_time.trim();
	}
	public void setOd_time(String od_time) {
		this.od_time = od_time;
	}
	
}
