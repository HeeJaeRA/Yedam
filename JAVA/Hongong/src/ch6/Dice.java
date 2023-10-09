package ch6;

public class Dice {
	
	private int dice_num1;
	private int dice_num2;
	
	public int getDice_num1() {
		return dice_num1;
	}

	public void setDice_num1(int dice_num1) {
		this.dice_num1 = dice_num1;
	}

	public int getDice_num2() {
		return dice_num2;
	}

	public void setDice_num2(int dice_num2) {
		this.dice_num2 = dice_num2;
	}

	void play() {
		int cnt = 0;
		while (true) {			
			cnt++;
			
			int num1 = getDice_num1();
			num1 = (int) (Math.random() * 6) + 1;
			setDice_num1(num1);
			
			int num2 = getDice_num2();
			num2 = (int) (Math.random() * 6) + 1;
			setDice_num2(num2);
			
			System.out.printf("( %d, %d )  ", num1, num2);

			if (num1 + num2 == 2) {
				System.out.printf("\n( 1, 1 )이 나오는데 걸린 횟수 : %d", cnt);
				break;
			} else if (cnt % 10 == 0) {
				System.out.println();
			}
		}
			
	}
		

}
