package carTest1;

public class CarTest {

	public static void main(String[] args) {
		Car aiCar;
		aiCar = new AiCar();
		
		aiCar.run();
		
		System.out.println("--------------------");
		
		Car mCar;
		mCar = new ManualCar();
		mCar.run();
	}

}
