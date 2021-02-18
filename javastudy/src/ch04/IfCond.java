package ch04;

public class IfCond {
	public static void main(String[] args) {
		int num2 = 30;
		if(num2 > 10)
			System.out.println("10보다 크다");
		else
			System.out.println("10보다 작다");
		
		String gender = "남자";
		int age = 30;
		
		if(gender.equals("남자")) {
			if(age < 10) {
				System.out.println("10살 미만의 남자");
			}
			else if(age < 20) {
				System.out.println("10대 남자");
			}
			else if(age < 30) {
				System.out.println("20대 남자");
			}
		}
		else if(gender.equals("여자")){
			if(age < 10) {
				System.out.println("10살 미만의 여자");
			}
			else if(age < 20) {
				System.out.println("10대 여자");
			}
			else if(age < 30) {
				System.out.println("20대 여자");
			}
		}
		
		
	}
}
