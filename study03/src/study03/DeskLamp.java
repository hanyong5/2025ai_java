package study03;

public class DeskLamp {
	boolean isOn; // true false
	
	public void turnOn() {
		isOn = true;
	}
	
	public void turnOff() {
		isOn = false;
	}

	public String toString() {
		return "현재상태는 " + (isOn == true? "켜짐" : "꺼짐");
	}
}
