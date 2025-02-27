package carTest1;

public class ManualCar extends Car {

	@Override
	void drive() {
		System.out.println("사람이 운전");
		System.out.println("사람이 핸들조작");
		
	}

	@Override
	void stop() {
		System.out.println("브레이크를 밟아서 정지");
		
	}

}
