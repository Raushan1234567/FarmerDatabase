package com.dto;

import java.time.LocalDate;

public class Instagram {

	private int id;
	private int Fllowers;
	private int Following;
	private String userid;
	private LocalDate joindate;
	public Instagram(int fllowers, int following, String userid, LocalDate joindate) {
		super();
		Fllowers = fllowers;
		Following = following;
		this.userid = userid;
		this.joindate = joindate;
	}
	public Instagram(int id, int fllowers, int following, String userid, LocalDate joindate) {
		super();
		this.id = id;
		Fllowers = fllowers;
		Following = following;
		this.userid = userid;
		this.joindate = joindate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFllowers() {
		return Fllowers;
	}
	public void setFllowers(int fllowers) {
		Fllowers = fllowers;
	}
	public int getFollowing() {
		return Following;
	}
	public void setFollowing(int following) {
		Following = following;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public LocalDate getJoindate() {
		return joindate;
	}
	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "Instagram [id=" + id + ", Fllowers=" + Fllowers + ", Following=" + Following + ", userid=" + userid
				+ ", joindate=" + joindate + "]";
	}
	
	
	
	
}
