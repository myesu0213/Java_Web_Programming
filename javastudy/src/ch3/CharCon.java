package ch3;
/**
 * "answkduf" + "문자열" = "문자열문자열"
 * 문자열 + 숫자( -> 문자열로 자동형변환)
 * @author Admin
 *
 */
public class CharCon {
	public static void main(String[] args) {
		String str1 = "Java" + 8;
		System.out.println(str1);
		String str2 = "Oracle" + 4 + 5;
		System.out.println(str2);
		String str3 = "Oracle" + (4 + 5);
		System.out.println(str3);
		String str4 = 4 + 5 + "apple";
		System.out.println(str4);
		
	}
}
