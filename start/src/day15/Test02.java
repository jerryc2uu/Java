package day15;

import java.util.*;

public class Test02 {

	public Test02() {
		Random rd = new Random();
		System.out.println(rd.nextInt());// 무슨 의미?? Random 타입 객체 내의 nextInt() 호출
		
		Random rd1 = new Random(10); // 꺼낼 위치(seed)를 정해놨기 때문에 매번 같은 숫자만 순차적으로 뽑아온다.

		/*
		   난수표에서 10번 위치부터 난수를 뽑아라
		   seed를 알려주면서 가져오기 때문에 항상 나오는 순서가 동일
		 */
		   
		
		for(int i = 0 ; i < 10 ; i++) {
			int no = rd1.nextInt(100); // 0 ~ 100 사이의 난수를 발생시키라
			
			//출력
			System.out.print(no + " ");
			//13 80 93 90 46 56 97 88 81 14 
			//표에는 각 셀마다 이미 숫자가 정해져 있다. 이 표에서 숫자를 하나씩 꺼내는 것
			
		}
	}

	public static void main(String[] args) {
		new Test02();
	}

}
