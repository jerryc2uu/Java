package day05.ex;

/*
  문제 16 ]
   구구단을 다음 형식으로 출력하세요.
   
   2 x 1 = 2       4 x 1 = 4        6 x 1 = 6      8 x 1 = 8
   2 x 2 = 4       4 x 2 = 8        6 x 2 = 12
   ...
   2 x 9 = 18      4 x 9 = 36       6 x 9 = 54     8 x 9 = 72
   
   
   3 x 1 = 3       5 x 1 = 5        7 x 1 = 7      9 x 1 = 9

*/

public class Ex16 {

	public static void main(String[] args) {
		// int no1 = 100; ==> 지역변수
		for (int i = 0 ; i < 2 ; i++) { //==> 카운터 변수도 지역변수다.
			
			for (int j = 0 ; j < 9 ; j++) {
				
				for (int k = 0 ; k < 4 ; k++) {
					
					int dan = 2 * k + 2 + i;
					int gop = j + 1;
					
					//출력
					System.out.println(dan + " x " + gop + " = " + (dan * gop) + "\t");
				}
					
				System.out.println();
				
			}
			
			System.out.println();

		}

	}

}
