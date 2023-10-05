package ch6;

public class Tv {
	
	int channel;
	int Volume;
	boolean onOff;
	
	Tv (int channel, int Volume, boolean onOff) {
		this.channel = channel;
		this.Volume = Volume;
		this.onOff = onOff;
	}
	
	void print() {
		if (onOff) {
			System.out.printf("tv 채널은 %d, 볼륨은 %d 입니다.\n", this.channel, this.Volume);			
		} else {
			System.out.println("전원이 꺼져있습니다.");
		}
	}

}
