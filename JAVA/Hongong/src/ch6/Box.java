package ch6;

public class Box {
	
	int width;
	int height;
	int length;
	
	Box(int width, int height, int length) {
		this.width = width;
		this.height = height;
		this.length = length;
	}
	
	double volume() {
		double result = (double) this.width * this.height * this.length;
		return result;
	}
}
