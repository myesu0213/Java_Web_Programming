package ch3;

/** 단항연산자: 피연산자가 1개
 *  - 부호 연산자(+,-)
 *  + 부호 : -1을 곱한 것과 같다.(부호가 변경된다.)
 *  + -> -
 *  - -> +
 *  
 *  - 증감 연산자: ++(1증가), --(1감소)
 *  
 * @author Admin
 *
 */
public class SignOperation {
	public static void main(String[] args) {
		short s1 = 20;
		short s2 = (short)-s1;	// CPU(integer), 메모리(short)의 타입 차이
								// 2의 보수 발생
								// int, long 아닌 byte, short는 (-)부호를 붙이면 int가 된다.
		short s3 = s1;
		
		int num1 = 20;
		int num2 = num1++;	// ++ 변수 뒤에 있을 때 먼저 대입이 되고 나중에 증가한다.
		
		System.out.println(s2);
		System.out.printf("%d %d \n",num1,num2);
		
		int num3 = ++num2;  // ++ 변수 앞에 있을 때 먼저 증가하고 대입한다.
		System.out.printf("%d %d \n",num2,num3);
		// num--
		// --num
		
		// 논리부정 연산자: !
		boolean flag =true;
		if(!flag) { //[!flag]는 false
			
		}
		
		// 비트 반전 연산자: ~(tilt) : 1의 보수
		// 각 비트를  0 -> 1, 1 -> 0 으로 변경
		byte b3  = 2;
		//byte b3 = ~b3; // int -> CPU에서 동작하는 것은 무조건 int
		int num4 = ~b3;
		
	}
}
