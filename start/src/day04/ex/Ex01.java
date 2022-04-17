package day04.ex;

/*
   문제1 ]
       1 ~ 25 숫자 3개를 랜덤하게 발생시켜서 
       그 숫자들 중 가장 큰 수만 출력하는 프로그램을 작성하세요.
       
       단, 3항 연산자를 사용해서 처리하세요.
       
 */
public class Ex01{
	public static void main(String[] args) {
	
	/*
	int a = (int) (Math.random() * (25 - 1 + 1) + 1);
	int b = (int) (Math.random() * (25 - 1 + 1) + 1);
	int c = (int) (Math.random() * (25 - 1 + 1) + 1);
	
	//int result = (no1 > no2) ? ((no1 > no3) ? (no1) : (no3)) : (no2);
	
	int result = (a > b) ? ((a > c) ? (a) : (c)) : ((b > c) ? (b) : (c));
	
	System.out.println("no1 : " + a);
	System.out.println("no2 : " + b);
	System.out.println("no3 : " + c);
	System.out.println(result + "은(는) 가장 큰 수 입니다." );
	
	*/
	
	  //1. 랜덤한 정수 3개 발생시킨다.
	  int no1 = (int)(Math.random() * (25 -1 + 1) +1);
	  int no2 = (int)(Math.random() * (25 -1 + 1) +1);
	  int no3 = (int)(Math.random() * (25 -1 + 1) +1);
	  
	  //#보너스 문제 : -100 ~ 100 사이의 정수를 랜덤하게 발생시켜 보세요.
	     
	  //2. 판별해서 변수에 담는다. 
	  
	  int max = (no1 > no2) ? ( // no1 > no2인 경우
			  		(no1 > no3) ? (no1) : (no3) //no1이 가장 큰 수 , no3이 가장 큰 수
			  	) : ( // no2 > no1인 경우
			  		(no2 > no3) ? (no2) : (no3) //no2가 가장 큰 수, no3이 가장 큰 수
			  	);
	  
	  //3. 출력한다.
	  
	  System.out.println("입력한 세 정수 \n\t" + no1 + "," + no2 + "," + no3 + " \n 중 제일 큰 수는 " + max + "입니다.");
	
	
	 
	/* 
	  참고 ]
	    문자열을 표현할 때 문자열 안에 " 기호를 출력하는 방법
	    ==> \"
	     이 때 사용한 \를 이스케이프문자라고 부른다.
	     
	     많이 사용하는 문자들이 있는데 
	        \" : 문자열 내에 "를 표현한다.
	        \n : 한 줄 내림 기호 (줄바꿈)
	        \r : 캐리지리턴
	        \t : tab
	        \b : backspace
	 */
	        
	     
	     
	     
	     
		
	}
}
	
		
    	
