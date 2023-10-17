package co.micol.firstmaven.service;

import java.sql.Date;

public class StudentVO {
	// DTO (VO)
	private String studentId;
	private String studentName;
	private String studentPassword;
	private String studentDept;
	private Date studentBirthday;
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentPassword() {
		return studentPassword;
	}
	
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	public String getStudentDept() {
		return studentDept;
	}
	
	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}
	
	public Date getStudentBirthday() {
		return studentBirthday;
	}
	
	public void setStudentBirthday(Date date) {
		this.studentBirthday = date;
	}
	
	@Override
	public String toString() {
		System.out.print(studentId + " : ");
		System.out.print(studentName + " : ");
		System.out.print(studentDept + " : ");
		if (studentPassword != null) {
			System.out.print(studentPassword + " : ");			
		}
		System.out.println(studentBirthday);
		return null;
	}
	
}
