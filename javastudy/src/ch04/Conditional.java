package ch04;

import java.util.Scanner;

/*
 * 제어문: 조건문, 반복문
 * 조건문: if문 , swich문
 * 반복문: for문, while, do-while
 * continue, break
 * goto
 */
public class Conditional {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수: ");
		int score = scanner.nextInt();
		
		if(score >= 90) {
			System.out.println("A 학점");
		}
/*앞의 조건이 불만족 할경우 작동*/else if(score >=80) {
			System.out.println("B 학점");
		}
/*앞의 조건이 불만족 할경우 작동*/else if(score >=70) {
			System.out.println("C 학점");
		}
/*앞의 조건이 불만족 할경우 작동*/else if(score >=60) {
			System.out.println("D 학점");
		}
/*앞의 조건이 불만족 할경우 작동*/else 
			System.out.println("F 학점");
		
		int num1 =20;
		if(num1 % 2 ==0) {
			System.out.println("짝수");
		}
		else
			System.out.println("홀수");
	}
}
