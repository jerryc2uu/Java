package day04;

/*
    정수 하나를 입력받아서


    이 수가 0인지 홀수인지 짝수인지 판별하세요.
    
    참고]
        조건문
        
        if(조건식) {
        // 조건식이 참일 경우 실행하는 부분
            실행내용
        }    
 */

import java.util.*;

public class Test01 {
	public static void main(String[] args ) {
		// 할일
		// 입력도구 준비하고
		Scanner sc = new Scanner(System.in);
		
		// 입력받기 전에 입력 메세지 출력해주고
		System.out.print("정수 입력 : ");
		
		// 입력받아서 정수를 변수에 기록시키고
		int num = sc.nextInt();
		
		// 조건에 따라서 판별하고
		String soo = "[영]";
		
		// 홀수인 경우
		if(num % 2 != 0) {//num % 2 == 1
			soo = "홀수";
		}
			
	    // 짝수인 경우
		if(num != 0  &&  num % 2 == 0) {
			soo = "짝수";
		}
		
		// 내용 출력
		System.out.println("입력받은 정수 " + num + " 은 " + soo + " 입니다. ");
	}

}
