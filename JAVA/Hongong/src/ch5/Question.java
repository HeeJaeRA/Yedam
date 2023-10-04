package ch5;

public class Question {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		if (args.length != 2) {
			System.out.println("값 부족");
			System.exit(0);
		} 
		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		
		int[] nums = new int[10];
		
		int sum = 0, max = 0, min = 101;
		double avg = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100) + 1;
			
			System.out.print(nums[i] + " ");
			
			sum += nums[i];
						
			if (max < nums[i]) {
				max = nums[i];
			}
			if (min > nums[i]) {
				min = nums[i];
			}
		}
		
		avg = (double) sum / nums.length;
		
		System.out.printf("\n합계: %d 최대값: %d 최소값: %d 평균: %.2f\n", sum, max, min, avg);
		
		int[][] nums2 = {
				{1, 2, 3},
				{1, 2},
				{1},
				{1, 2, 3}
		};
		
		for(int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums2[i].length; j++) {
				System.out.printf("%d ", nums2[i][j]);
			}
			System.out.println();
		}
		
		int[][] num3 = new int[3][10];
		
		int hap = 0;
		
		for (int i = 0; i < num3.length; i++) {
			for (int j = 0; j < num3[i].length; j++) {
				num3[i][j] = (int) (Math.random() * 2);
				System.out.printf("%d ", num3[i][j]);
				hap += num3[i][j];
			}
			System.out.println();
		}
		
		System.out.printf("현재 관객 수는 %2d명\n", hap);
		
		
		int[][] num4 = new int[3][5];
		
		
		for (int i = 0; i < num4.length; i++) {
			int num4Sum = 0;
			for (int j = 0; j < num4[i].length; j++) {
				num4[i][j] = (int) (Math.random() * 51) + 50;
				System.out.printf("%d ", num4[i][j]);
				num4Sum += num4[i][j];
			}
			System.out.println();
			System.out.printf("%d번 학생 평균: %.2f\n\n", i+1, (double) num4Sum / num4[i].length);
		}
		
	}

}
