package day07.ex;

/*
    문제 01 ]
        'A' - 'J' 까지의 문자를 랜덤하게 100개 만들고
        각 문자의 출현 횟수를 기억할 배열을 만들어서 
        횟수 만큼 "*"로 출력해주는 프로그램을 작성하세요.
        
        예 ]
          
          A [5] : *****
          B [20] : ********************
          J [7] : *******
          
          횟수를 기억할 배열을 만든다.
          총 10개
 */

import java.util.Arrays;

public class EX01 {

	public static void main(String[] args) {
		
		// 1. 배열 만들기
		char[] ch = new char[100];
		int[] num = new int[10];
		
		// 2. 문자 랜덤 입력
		for (int i = 0 ; i < ch.length ; i++) {
			int no = (int)(Math.random() * ('J' - 'A' + 1) + 'A');
			char eng = (char) no;
			//ch[i] = eng;

			for (int j = 'A' ; j <= 'J' ; j++ ) {
				if (eng == j) {
					num[j] += 1;
			}
		}


		for (int j = 0 ; j <num.length ; j++) {
			System.out.print(eng + " =>" + num[j] + "번"
					);
		}	
			
		}
			/*
	    	// 2-1. 데이터 확인	
		
		// 3. 횟수 배열 만들기
		
		System.out.println(Arrays.toString(eng));
		
		for (int i = 0 ; i < num.length ; i++) {
			if ((ch[i] - '0') == )
		}
			
			
			
		// 3. 출력
			*/
	}

}
