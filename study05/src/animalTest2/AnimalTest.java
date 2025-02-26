package animalTest2;

import java.util.ArrayList;
import java.util.List;

public class AnimalTest {

	public static void main(String[] args) {
//		Animal ani1 = new Animal();
//		ani1.move();
//		
//		Human man = new Human();
//		man.move();
//		
//		Animal man1 = new Human();
//		man1.move();
// 다형성 : 상속, 형변환, 오버라이드
		
		
		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
		List<Animal> aList = new ArrayList<>();
		aList.add(hAnimal);
		aList.add(tAnimal);
		aList.add(eAnimal);
		
		for(Animal ani:aList) {
			ani.move();
		}
		
			
	}

}
