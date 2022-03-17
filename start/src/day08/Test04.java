package day08;

import java.util.Arrays;

/*
   정수 5개를 기억할 배열을 만들고 
   데이터를 채워둔 후 
   1번 방에서부터 3번 방까지의 데이터만 
   다른 배열에 깊은 복사를 해보자
	
	이때 복사될 배열은 길이를 10으로 하세요.
 */
public class Test04 {

	public static void main(String[] args) {
		//원본배열 origin
		int[] ori = {10, 20, 30, 40, 50};
		
		//to copy
		int[] copy = new int[10];//모든 데이터가 0으로 채워져 있음
			
		//깊은 복사
		System.arraycopy(ori, 0, copy, 0, 3);
		
		// 배열 내용 출력
		//ori
		System.out.println("ori : " + Arrays.toString(ori));
		//copy
		System.out.println("copy : " + Arrays.toString(copy));
		
	}

}
