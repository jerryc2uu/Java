package day05.ex;

/*
    문제 7 ]
        5자리의 숫자를 입력한 후 
        각자리의 수의 합을 구하는 프로그램을 작성하세요.
  
       힌트 ] 
           ***** % 10 ==> 마지막 자리만 꺼낸다.
           ***** / 10 ==> **** (네 자리)만 꺼낸다.
 */
import java.util.*;

public class Ex07 {

	public static void main(String[] args) {
		
		//1. 입력도구 준비
		Scanner sc = new Scanner(System.in);
		
		//2. 메세지 출력
		System.out.print("5자리 정수 입력 : ");
		
		//3. 입력 받아서 기억
		int no = sc.nextInt();
		
		int sum = 0;
		
		int tmp = no;
		
		//4. 반복해서 합 구하고
		for (int i = 0 ; i < 5 ; i++) {
			sum = sum + tmp % 10;
			tmp = tmp / 10;
		}
		
		/* 자바 스크립트
		   for ( var i = 0 ; i < 10 ; i++ ) {
		   		alert((i + 1) + ' 회차');
		     }
		 */
			
		//5. 결과 출력
		System.out.println("입력한 수 " + no + "의 각 자리 수 합은 " + sum + " 입니다. ");
		
		

	}

}
