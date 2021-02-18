package backjoon;

import java.util.Scanner;
// 별찍기-2
/* 5
 *     *
 *    **
 *   ***
 *  ****
 * *****
 * 분석: 한 줄씩 출력하는 것을 5번씩 반복 -> 반복문 시행
 * 한줄에서는 ' '와  '*'을 입력
 * ' '출력: 5-별의 수 만큼 출력
 * '*'출력: 별의 수만큼 출력
 * 입력: 5 
 * */

public class P2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i =1;i<=num;i++) {
			
			for(int j =1;j<=num-i;j++) {
				System.out.print(' ');
			}
			
			for(int j = 1;j<=i;j++) {
				System.out.print('*');
			}
			
			System.out.println();
		}
		

	}

}
