package ch11;

public class Student {
	
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO 자동 생성된 메소드 스텁
		if (obj instanceof Student) {
			Student student = (Student) obj;
			if (studentNum.equals(student.studentNum)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO 자동 생성된 메소드 스텁
		return studentNum.hashCode();
	}

}
