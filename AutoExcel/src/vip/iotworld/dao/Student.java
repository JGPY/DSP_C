package vip.iotworld.dao;

/*
 * 
 *@author:liubing
 * 
 * */

public class Student {
	
	private String college;
	private String grade;
	private String major;
	private String name;
	private double studentNumber;
	private double phone;
	private String weChat;
	private String email;
	
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(double studentNumber) {
		this.studentNumber = studentNumber;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email =email;
	}
	@Override
	public String toString() {
		return "Student [college=" + college + ", grade=" + grade + ", major=" + major + ", name=" + name
				+ ", studentNumber=" + studentNumber + ", phone=" + phone + ", weChat=" + weChat + ", email=" + email
				+ "]";
	}
}
