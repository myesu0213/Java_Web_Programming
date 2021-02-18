package ch04;

import java.io.IOException;

/*
 * while 반복문: 어떤 조건을 만족하지 않을 때까지 무조건 반복을 수행한다.
 * 	조건을 만족하면 게속 반복 수행
 * 	어떤 조건에서 종료하도록 할 때
 * 
 * 	자동차 -> 속도(speed =0)
 *  메뉴 : 1 ->가속
 *  	2->감속
 *  	3->중지(종료)
 *  반복 실행
 */
public class SpeedExample {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		boolean run = true;
		int speed = 0;
		int keyCode =0;
		while(run) {
			if(keyCode != 13 /* '\n' */ || keyCode != 10 /* '\r' */) {
				System.out.println("--------------------");
				System.out.println("1:가속, 2:감속, 3:중지");
				System.out.println("--------------------");
				System.out.print("선택: ");
			}
			keyCode = System.in.read(); // 읽은 값
			//inputoutput 동작을 하므로 예외가 발생할 수 있으며
			//예외처리를 해주어야 한다.
			if(keyCode == 49) { //가속 ->1
				speed++;
				System.out.println("현재 속도 = "+speed);
			}
			else if(keyCode==50) { //감속 ->2
				speed--;
				System.out.println("현재 속도 = "+speed);
			}
			else if(keyCode==51) {	//중지 ->3
				run = false;
			}
			
		}

	}

}
