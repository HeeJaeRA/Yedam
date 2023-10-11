package ch8;

public class Audio implements RemoteControl {
	
	private int volume;
	
	@Override
	public void turn_on() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turn_off() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("Audio를 끕니다.");		
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
		System.out.printf("현재 Audio 볼륨: %d\n", this.volume);
	}
	

}
