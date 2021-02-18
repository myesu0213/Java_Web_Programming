package ch3;

public class CompareOperatorExample2 {
	public static void main(String[] args) {
		int v2 = 1;
		double v3 = 1.0;
		float v6 = 1.0f;
		
		double v4 = 0.1;
		float v5 = 0.1f;
		
		System.out.println(v2 == v3); //true
		System.out.println(Double.toHexString(v2));
		System.out.println(Double.toHexString(v6));
		System.out.println(v2 == v6);
		System.out.println();
		
		System.out.println(v4 == v5); //false
		System.out.println((float)v4 == v5); //true
		System.out.println((int)(v4*10) == (int)(v5*10)); //true
		System.out.println();
		
		System.out.printf("%s\n",Double.valueOf(v4));
		System.out.printf("%s\n",Double.toHexString(v4));
		System.out.printf("%s\n",Float.toHexString((float)v4));
		System.out.printf("%s\n",Float.valueOf(v5));
		System.out.printf("%s\n",Float.toHexString(v5));
		System.out.printf("%s\n",Double.toHexString(v5));
	}
}
