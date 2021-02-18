package ch3;

public class TripleOperation2 {
	public static void main(String[] args) {
		int score = 70;
		String grade = (score>70) ? "A" : "B";
		String grade2 = (score>90) ? "A" : (score>80) ? "B" : (score>70) ? "C" : "D";
		System.out.println(grade);
		System.out.println(grade2);
	}
}
