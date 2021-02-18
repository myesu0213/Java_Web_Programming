package ch04;

/** 구구단 출력 : 2 ~ 9단
 * 2*1 ~2*9
 * 3*1 ~3*9
 * 4*1 ~4*9
 * 5*1 ~5*9
 * 6*1 ~6*9
 * 7*1 ~7*9
 * 8*1 ~8*9
 * 9*1 ~9*9
 * *@author Admin
 *
 */
public class GugudanExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 2;i<10;i++) {
			System.out.println(i+"단");
			int j;
			for(j = 1;j<10;j++) {
				System.out.println(i + " * " +j+" = "+ i*j);
			}
			
			System.out.println();
		}
		//인덱스 관례로는 i,j,k,l,m,n,o,p,....
		
//		
//		int one=2,two=1;
//		while(true) {
//			if(two==10) {
//				if(one==9) {
//					break;
//				}
//				one++;two=1;
//			}
//			System.out.println(one +"*"+two + "="+(one*two));
//			two++;
//		}

	}

}
