package ch8;

public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		RemoteControl rc_tv = new Tv();
		RemoteControl rc_ad = new Audio();
		
		RemoteControl rc_stv = new SmartTv();
		Searchable sc_stv = new SmartTv();
							
		rc_tv.turn_on();
		rc_tv.turn_off();
		rc_tv.set_volume(5);
		
		System.out.println();
		
		rc_ad.turn_on();
		rc_ad.turn_off();
		rc_ad.set_volume(7);
		
		System.out.println();
		
		rc_stv.turn_on();
		rc_stv.turn_off();
		rc_stv.set_volume(10);
		sc_stv.search("url");

	}

}
