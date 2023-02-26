package com.mgnregs.dto;

import java.util.Objects;

public class BDO {
	private int BDO_ID;
	private String username;
	private String password;
	private String email;
	private String phone;
	
	public BDO() {	}
	public BDO(String username, String password, String email, String phone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public BDO(int bDO_ID, String username, String password, String email, String phone) {
		BDO_ID = bDO_ID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	public BDO(int bDO_ID, String username) {
		BDO_ID = bDO_ID;
		this.username = username;
	}
	public int getBDO_ID() {
		return BDO_ID;
	}
	public void setBDO_ID(int bDO_ID) {
		BDO_ID = bDO_ID;
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
		BDO other = (BDO) obj;
		return Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "BDO [BDO_ID=" + BDO_ID + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + "]\n";
	}
	
	
}
