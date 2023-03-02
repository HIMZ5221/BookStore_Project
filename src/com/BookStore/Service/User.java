package com.BookStore.Service;

import java.sql.Date;

public class User {
	
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
	public String toString() { //개인정보페이지
		return "\t\t계정고유번호 : \t" + userNumber + "\n\t\t이름 : \t\t" + userName + "\n\t\t계정ID : \t" + userId
				+ "\n\t\t생일 : \t\t" + userBirth + "\n\t\t전화번호 : \t" + userTel + "\n\t\t나이 : \t\t" + userAge
				+ "\n\t\tMyEmail : \t" + userMail + "\n\t\t가입일 : \t" + hiredate + "\n\t\t보유머니 : \t" + userMoney+"캐쉬";
	}
	public String toStringList() {
		return  "\n\t계정고유번호 : \t" + userNumber + "\t| 이름 : \t" + userName + "\t| 계정ID : \t" + userId
				+ "\n\t전화번호 : \t" + userTel + "\t 나이 : \t" + userAge
				+ "\n\tMyEmail : \t" + userMail + "\t| 가입일 : \t" + hiredate+"캐쉬"+"\t 생일 : \t" + userBirth + "\n\t보유머니 : \t" + userMoney
				;	}

	
	
}
