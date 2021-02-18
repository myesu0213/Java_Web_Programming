package sec02.exam01_byte;
public class GarbageValueExample {
	public static void main(String[] args) {
		byte var1 = 125;
		int var2 = 125;
		for(int i=0; i<5; i++) {	// i : 0,1,2,3,4 반복 수행
			var1++;	// 125(i=0), 126, 127, -128, -127
			var2++;	// 125(i=0), 126, 127, 128, 129
			System.out.println("var1: " + var1 + "\t" + "var2: " + var2);
			// 126, 127, -128, -127, -126
			// 126, 127, 128, 129, 130
		}
	}
}
