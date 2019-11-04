package com.tyss.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Librarian {
	@Id
	@GeneratedValue
	@Column
	private int lId;
	@Column
	private String lName;
	@Column
	private String lEmail;
	@Column
	private String lPassword;
	@Column
	private Long lPhno;
	@Column
	private int lAge;
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlEmail() {
		return lEmail;
	}
	public void setlEmail(String lEmail) {
		this.lEmail = lEmail;
	}
	public String getlPassword() {
		return lPassword;
	}
	public void setlPassword(String lPassword) {
		this.lPassword = lPassword;
	}
	public Long getlPhno() {
		return lPhno;
	}
	public void setlPhno(Long lPhno) {
		this.lPhno = lPhno;
	}
	public int getlAge() {
		return lAge;
	}
	public void setlAge(int lAge) {
		this.lAge = lAge;
	}
	
	
}
