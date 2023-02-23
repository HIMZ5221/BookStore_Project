package com.BookStore.Service;

import java.sql.Date;

public class User {
//	user_number number(5) Primary Key,
//	user_name varchar2(25) not null unique,
//	user_id varchar2(15) not null unique,
//	user_pw varchar2(15) not null,
//	user_birth date,
//	hiredate date default (sysdate),
//	user_tel number(15),
//	user_age number(3) not null,
//	user_mail varchar2(30) unique,
//	user_money number(10) Default (0)
//	
	private int userNumber;
	private String userName;
	private String userId;
	private String userPw;
	private String userBirth; 
	private String userTel;
	private int userAge;
	private String userMail;
	private int userMoney;
	private Date hiredate;
	
	public User() {
		
	}
	
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public int getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "\t계정고유번호 : \t" + userNumber + "\n\t이름 : \t\t" + userName + "\n\t계정ID : \t\t" + userId
				+ "\n\t생일 : \t\t" + userBirth + "\n\t전화번호 : \t" + userTel + "\n\t나이 : \t\t" + userAge
				+ "\n\tMyEmail : \t" + userMail + "\n\t가입일 : \t\t" + hiredate + "\n\t보유머니 : \t" + userMoney+"캐쉬";
	}


	
	
}
