package ch3;
/** Overflow(오버플로우) : 어떤 데이터 타입이 저장할 수 있는 범위를 벗어나는 것
 *  -> 오버플로우가 발생하지 않도록 주의
 * @author Admin
 *
 */

public class CheckOverflowExample {
	public static void main(String[] args) {
		int num1 = 1000000;
		int num2 = 1000000;
		
	//	int num3 = num1* num2;
		
		System.out.println(Integer.MAX_VALUE);
		int num3 = 1000000 * 1000000;
		System.out.println(num3);
		int num4 = num1 * num2;
		System.out.println(num4);
		
		// 산술연산을 할 떄 overflow가 발생할 수 있다.
		// 똑같은 것을 다르게 한다.
		// 1. 직접 곱하기를 수행  num 4 = num1 * num2
		// 2. 메소드를 사용
		
		int num5 = safeMuliple(num1,num2);
		if(num5 == 0) {
			System.out.println("error");
		}
	}

	private static int safeMuliple(int num1, int num2) {
		// TODO Auto-generated method stub
		long l = (long)num1 * num2;
		if(l > Integer.MAX_VALUE) {
			return 0;
		}
		else {
			return num1 * num2;
		}
	}
}
