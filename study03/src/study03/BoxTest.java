package study03;

public class BoxTest {

	public static void main(String[] args) {
		
		Box box = new Box();
		
		box.width = 100;
		box.height = 100;
		box.length = 5;
		
//		double count = box.getVolume();
		
		System.out.println("상자의 가로,세로,높이는 "+box.width+", "+box.height+", "+box.length+" 입니다.");
		System.out.println("상자의 부피는 "+ box.getVolume() +"입니다.");
	}

}
