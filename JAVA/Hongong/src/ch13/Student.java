package ch13;

public class Student {
	public int studentNum;
	public String name;
	
	public Student (int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
			return (student.studentNum == studentNum);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return studentNum;
//		return studentNum + name.hashCode();
	}

}
