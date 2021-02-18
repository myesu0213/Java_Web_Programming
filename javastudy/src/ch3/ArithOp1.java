package ch3;
/** 이항연산자: 항(피연산자)이 2개
 * 산술 연산자: +, -, *, /, %
 *  피연산자의 타입이 다를 수 있다.
 * @author Admin
 *
 */
public class ArithOp1 {
	public static void main(String[] args) {
		byte b1 = 10;
		short s1 = 20;
		int i1 = b1 + s1;	// CPU에서 모두(b1, s1) int타입이 된다.
		long l1 = 234L;		// int와 구분하기 위해서 뒤에 L 또는 l 붙인다.
		//int i2 = i1/*int*/ + l1 /*long*/; // 에러 발생
		long i2 = i1/*int -> long*/ + l1 /*long*/;
		float f1 = 2.34f;	// double과 구분을 위해 'f' 또는 'F'를 붙인다.
		double d1 = 40.32;
		double d2 = f1 /*float -> double*/ * d1 /*double*/;
		// 평균
		int avg = 171/*int*/ / 2/*int*/;
		double avg2 = 171/*int*/ / 2.0/*double*/;
		System.out.println(avg);
		System.out.println(avg2);
		// 큰 타입으로 변환된다.
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		// float가 long 보다 크기는 작지만 값을 표현할 수 있는 크기가 더 크다.
		// 실수는 오차가 발생할 수 있다. -> double이 float 보다 정확하므로 double을 사용한다.
		// 정수는 int를 사용하되 더 큰값이 요구될 경우 long을 사용
		// 나누기: 어떤 수를 0으로 나누면 안됨. -> 무한대가 되고, 에러 발생
		//System.out.println(4/0); //에러 발생
		System.out.println("출력"); // 실행 불가
		int a = get();
		//System.out.println(10/a);
	}
	
	private static int get() {
		return 0;
	}
}
