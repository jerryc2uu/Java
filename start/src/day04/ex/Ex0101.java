package day04.ex;


/*
    문제 1 -1 ]
    
   1 ~ 25 숫자 3개를 랜덤하게 발생시켜
   그 수들 중 가장 큰 수, 중간 수, 작은 수를 구분해서 출력하는 프로그램을 작성하세요.
   
   3항 연산자 사용
   
 */
public class Ex0101 {
	public static void main(String[] args) {
		
		int no1 = (int) (Math.random() * (25 - 1 + 1) + 1);
		int no2 = (int) (Math.random() * (25 - 1 + 1) + 1);
		int no3 = (int) (Math.random() * (25 - 1 + 1) + 1);
		
		int a = (no1 > no2) ? ((no1 > no3) ? (no1) : (no3)) : ((no2 > no3) ? (no2) : (no3));
		int b = (no2 > no3) ? ((no1 > no2) ? (no2) : (no1)) : ((no1 > no3) ? (no3) : (no1));
		int c = (no1 > no3) ? ((no2 > no3) ? (no3) : (no2)) : ((no1 > no2) ? (no1) : (no2));
		
		System.out.println(" 큰 수는 " + a + " 중간 수는 " + b + " 작은 수는 " + c + " 입니다. ");
	}

}
