package day05;

/*
   구구단 7단을 출력하세요.
   
 */
public class Test07 {

	public static void main(String[] args) {
		int dan = 7;
		
		for(int i = 0 ; i < 9 ; i++) {
			System.out.println(dan + " x " + (i+1) + " = " + (dan * (i + 1)));
		}
		
		System.out.println();
		
		for(int i = 2 ; i <= 9 ; i++) {
			System.out.println(i + " 단");
			for(int j = 1 ; j <= 9 ; j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
		}
		

	}

}
