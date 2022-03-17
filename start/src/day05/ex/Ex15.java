package day05.ex;

/*
   문제 15 ]
      구구단을 다음 형식으로 출력하세요.
      
      2 x 1 = 2       3 x 1 = 3        4 x 1 = 4      5 x 1 = 5
      2 x 2 = 4       3 x 2 = 6        4 x 2 = 8
      ...
      2 x 9 = 18      3 x 9 = 27       4 x 9 = 36

    for문 중첩 연습
    
 */
public class Ex15 {

	public static void main(String[] args) {
		
		for (int i = 2 ; i <= 5 ; i++) {
			for (int j = 1 ; j <= 9 ; j++) {
				System.out.println( i + " x " + j + " = " + (i * j));
			}
		}

	}

}
