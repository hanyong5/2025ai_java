package study03;

public class HeroTest {

	public static void main(String[] args) {
		Hero hero1 = new Hero("아이언맨", "하이테크 슈트", 90, 80);
		Hero hero2 = new Hero("토르","번개 조종",95,85);
		Hero hero3 = new Hero("헐크","주먹",100,75);
		Hero hero4 = new Hero("스파이더맨","거미줄",70,65);
		
		hero1.showHeroInfo();

//		System.out.println(hero1);
//		System.out.println(hero2);
//		System.out.println(hero3);
//		System.out.println(hero4);
	}

}
