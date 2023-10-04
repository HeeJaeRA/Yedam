package ch5;

public class Array {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] arrays = { 1, 20, 60, 70 };
		
		for (int i = 0; i < arrays.length; i++) {
			System.out.printf("arrays[%d] : %d\n", i, arrays[i]);
		}
		
		for (int i : arrays) System.out.print(i + " ");
		System.out.println();
		
		int[] nums = new int[10];
		
		for (int i = 0; i < 10; i++) {
			nums[i] = i+1;
		}
		
		int sum = 0;
		for (int i : nums) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println();
		System.out.println(sum);
		
		int[][] lists = {
				{10, 20, 30},
				{44, 55, 66},
				{88, 99}
		};
		
		for (int i = 0; i < lists.length; i++) {
			for(int j = 0; j < lists[i].length; j++) {
				System.out.printf("lists[%d][%d] : %d ", i, j, lists[i][j]);
			}
			System.out.println();
		}
		
		int[][] nums2 = new int[3][5];
		
		for(int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums2[i].length; j++) {
				nums2[i][j] = (int) (Math.random() * 51) + 50;
			}
		}
		
		for(int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums2[i].length; j++) {
				System.out.print(nums2[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
