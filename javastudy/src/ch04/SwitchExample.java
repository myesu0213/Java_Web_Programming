package ch04;

import java.util.Scanner;

public class SwitchExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메뉴: 1.더하기 , 2.빼기 , 3.곱하기 , 4.나누기");
		int menu = sc.nextInt();
		switch(menu) { // 조건 안 의 타입 int, byte, short, long
		case 1:
			System.out.println("더하기 수행");
			break;
		case 2:
			System.out.println("빼기 수행");
			break;
		case 3:
			System.out.println("곱하기 수행");
			break;
		case 4:
			System.out.println("나누기 수행");
			break;
		default:
			System.out.println("없음");
			break;
		}
	}
}
