package ch8;

public class SmartTv implements RemoteControl, Searchable {
	
	private int volume;
	
	@Override
	public void turn_on() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("스마트 TV를 켭니다");
	}
	
	@Override
	public void turn_off() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("스마트 TV를 끕니다");
	}
	
	@Override
	public void set_volume(int volume) {
		// TODO 자동 생성된 메소드 스텁
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.printf("현재 스마트 TV 볼륨: %d\n", this.volume);
	}
		
	@Override
	public void search(String url) {
		// TODO 자동 생성된 메소드 스텁
		System.out.printf("%s을 검색합니다\n", url);
	}

}
