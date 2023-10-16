package 라희재;

public class Student {
	
	int s_num;
	String s_name;
	int s_score;
	
	Student(int s_num, String s_name, int s_score) {
		this.s_num = s_num;
		this.s_name = s_name;
		this.s_score = s_score;
	}

	public int getS_num() {
		return s_num;
	}

	public String getS_name() {
		return s_name;
	}

	public int getS_score() {
		return s_score;
	}

}
