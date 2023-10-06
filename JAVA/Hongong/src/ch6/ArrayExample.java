package ch6;

public class ArrayExample {
	
	public static void main(String[] args) {
		
		double[] array1 = {1.1, 2, 99, 5.5, 0.1, 0.9};
		double[] array2 = {4.4, 20, -63, 10.8, 9, 0.5};
		
		System.out.printf("첫번째 배열의 최소값 = %.1f\n", min(array1));
		System.out.printf("두번째 배열의 최소값 = %.1f\n", min(array2));
		
	}
	
	public static double min(double[] values) {
		
		double minValue = values[0];
		
		for (int i = 0; i < values.length; i++) {
			if(minValue > values[i]) {
				minValue = values[i];
			}
		}
		return minValue;
	}
	
}
