package ch9;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener());
		btn.touch();

		btn.setOnClickListener(new MessageListener());
		btn.touch();

	}

}
