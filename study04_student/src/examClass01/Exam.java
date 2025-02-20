package examClass01;

public class Exam {
	private int score;
	private String date;
	
	public Exam(int score, String date) {
		this.score = score;
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return date + "시험 : " + score + "점";
	}
	
	
	
}
