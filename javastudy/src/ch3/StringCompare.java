package ch3;

public class StringCompare {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = "홍길동"; // 위의 변수와 같은 주소를 가진다.
		
		String str3 = new String("홍길동");
		
		if(str1 == str3){
			System.out.println("같은 주소값을 가진다.");		
		}
		else
			System.out.println("다른 주소값을 가진다.");
		
		if(str1.equals(str3	)) {
			System.out.println("같은 내용");
		}
		else {
			System.out.println("다른 내용");
		}
	}
}
