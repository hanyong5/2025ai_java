package carTest1;

public abstract class Car {
	abstract void drive();
	abstract void stop();
	
	void startCar() {
		System.out.println("시동을 킵니다.");
	}
	
	void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	final void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}
	
}
