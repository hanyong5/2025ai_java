package study03;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		
		name.add("사과");
		name.add("배");
		name.add("귤");
		name.add("바나나");
		name.add("수박");
		name.add("포도");
		
		System.out.println(name.size());
		System.out.println(name.get(1));
		
		for(int i=0;i<name.size();i++) {
			System.out.println(name.get(i));
		}
		
		for(String fruit:name) {
			System.out.println(fruit);
		}
		
		
	}

}
