package ch04;

public class Prob04_03 {
	public static void main(String[] args) {
		System.out.println(((25*5)+(36-4)-72)/5);
//		int num =3;
//		for(int i=2;i<5;i++) {
//			num = num+ num*i;
//		}
		int num =3;
		int num1 =num*2 + num;
		int num2 =num*3 + num1;
		int num3 =num*4 + num2;
		
		System.out.printf("%d %d %d %d",num, num1,num2,num3);
	}
}
