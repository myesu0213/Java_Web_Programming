package backjoon;

import java.util.Scanner;

// 윤년: 4의 배수이고, 100의 배수가 아니거나 400의 배수
// 		4의 배수: year % 4 == 0
//		100의 배수: year % 100 == 0
//		400의 배수: year % 400 == 0
// 입력: 1 <= 년도 <= 4000
// 출력: 윤년 ->1, x->0

public class P2753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		if(year%4==0 && (year%100!=0 || year%400==0)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		sc.close();

	}

}
