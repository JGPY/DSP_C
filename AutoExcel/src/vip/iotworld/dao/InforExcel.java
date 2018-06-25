package vip.iotworld.dao;

import java.util.ArrayList;

public class InforExcel {
	
	private String titleCH;
	private String titleEN;
	private String teacher;
	private double phone;
	private String email;
	private ArrayList<Student> students;
	
	public String getTitleCH() {
		return titleCH;
	}
	public void setTitleCH(String titleCH) {
		this.titleCH = titleCH;
	}
	public String getTitleEN() {
		return titleEN;
	}
	public void setTitleEN(String titleEN) {
		this.titleEN = titleEN;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Student> getStudent() {
		return students;
	}
	public void setStudent(ArrayList<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "InforExcel [titleCH=" + titleCH + ", titleEN=" + titleEN + ", teacher=" + teacher + ", phone=" + phone
				+ ", email=" + email + ", students=" + students + "]";
	}
	
}
