package day13.ex;

import java.util.Arrays;

public class Ex01 {
/*
   String[] arr= {"123", "456", "789", ...}; 가 있는 경우
   이 배열이 기억하는 숫자 형태의 문자열을 정수로 바꾼 
   데이터들의 합과 평균을 구하는 프로그램을 작성하라
   
   단, 발생할 수 있는 예외를 가정하여 모두 처리하라.
   	
   	1. 배열의 범위를 벗어나서 사용하는 경우 indexoutof
   	2. 숫자로 변환이 불가능한 경우 NUMBERFORMATEXCEPTION
   	3. 평균을 계산하는데 0으로 나누는 경우 ArithmeticException
   	4. 그 외의 모든 예외  Exception
   	
 */
	public Ex01() {
		
		String[] arr = new String[]{"123", "456", "789", "101112", "십삼십사15"};
		
		int[] cal = new int[arr.length];	// arr배열의 크기만큼의 계산용 배열 생성
		
		int no = 0;	// 정수 변환용 변수
		
		for(int i = 0 ; i< arr.length + 1 ; i++) {
			System.out.println("\t배열의 "+(i+1)+"번째를 탐색 중입니다.");
			System.out.println();
			
			try {
				no = Integer.parseInt(arr[i]);	// 변환
				cal[i] = no;	// 변환이 성공하면 cal 배열에 넣기
				
			} catch(IndexOutOfBoundsException e) {	// 배열 인덱스 밖으로 나간 경우
				
				System.out.println("# 배열 인덱스 외부로 나갔습니다.");
				System.out.println();
				//continue;
				
			} catch(RuntimeException e) {	// 숫자 변환 불가능한 경우
				System.out.println();
				System.out.println();
				//continue;
			}
		}
		int check = 0;	// 평균 나눠야할 값 체크해주는 변수 = 0보다클때(정수 값이 입력된 부분)만 +1
		int sum = 0;	// 총합
		for(int n : cal) {
			if(n > 0) check++;
			sum += n;
		}
		
		double avg = 0.0;
		try {
			avg = sum / (double)check;
		}catch(ArithmeticException e) {	// 0으로 나눴을 때
			System.out.println("## 0으로 나누는 것은 불가능합니다.");
		}
		
		System.out.println("입력된 배열 : "+ Arrays.toString(arr));
		System.out.println("정수만 추출한 배열 : "+Arrays.toString(cal));
		System.out.println("입력한 정수 개수 : "+check);
		System.out.println("배열의 합계 : "+sum);
		System.out.println("배열의 평균 : "+avg);
	
		
		
		 
			
				
				
			
			
			
			
		
			
		
		}
		
	

	public static void main(String[] args) {
		new Ex01();
	}

}
