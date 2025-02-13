package study03;

public class Pizza {
	int size;
	String type;
	
	
	public Pizza(int s, String t) {
		size = s;
		type = t;
	}

	// default contructor
	public Pizza() {}
	
	public String toString() {
		return "피자의 크기는 : " + size + "이고, 피자의 이름은 " + type + "입니다.";
	}
}
