package ch04;
/** 반복문: 조건을 만족하면 계속 반복 실행
 *  - while
 *  - do-while
 *  - for
 * @author Admin
 *
 */

public class LoopExample {
	public static void main(String[] args) {
		// 1~ 10 까지의 수를 더한 값을 출력하기
		int num = 0; // 누적치를 저장하는 변수
		for(int i = 1 /*초기값*/; i<=10 /*종료조건*/; i++ /*증감식*/ )
			num+=i;
		System.out.println(num);
	}
}
