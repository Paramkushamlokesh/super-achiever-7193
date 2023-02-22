package com.mgnregs.dto;

import java.util.Objects;

public class GPM {
	private int GPM_ID;
	private String username;
	private String password;
	private String email;
	private String phone;
	public GPM(String username, String password, String email, String phone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public GPM(int gPM_ID, String username, String password, String email, String phone) {
		GPM_ID = gPM_ID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	public int getGPM_ID() {
		return GPM_ID;
	}
	public void setGPM_ID(int gPM_ID) {
		GPM_ID = gPM_ID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GPM other = (GPM) obj;
		return Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "GPM [GPM_ID=" + GPM_ID + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + "]\n";
	}
	
}
