package study03;

public class DeskLampTest {

	public static void main(String[] args) {
		DeskLamp myLamp = new DeskLamp();
		
		myLamp.turnOn();
		System.out.println(myLamp.toString());
		
		myLamp.turnOff();
		System.out.println(myLamp);
		
		myLamp.turnOn();
		System.out.println(myLamp.toString());
		
		myLamp.turnOff();
		System.out.println(myLamp);
		
	}

}
