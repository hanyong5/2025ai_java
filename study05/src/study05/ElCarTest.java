package study05;

public class ElCarTest {

	public static void main(String[] args) {
		ElCar obj = new ElCar();
		obj.speed = 10;
		obj.setSpeed(60);
		obj.charge(20);

		
		System.out.println(obj.toString());
	}

}
