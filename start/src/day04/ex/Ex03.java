package day04.ex;
/*
    문제 3 ] 
        게시물을 게시판에 출력하는데 
        하나의 페이지에 게시물을 15개를 출력할 예정이다.
        게시물 수를 랜덤하게 발생시켜서
        그 게시판의 페이지가 몇 페이지가 필요한지를 계산해서
        출력해주는 프로그램을 작성하세요.
        
        참고 ]
           게시물이 없는 경우는 게시물이 없는 페이지가 적어도 1페이지는 필요하다.
 */

public class Ex03 {
	public static void main(String[] args) {
	
		int total = (int) (Math.random() * (100 - 0 + 1) + 0);
		
		
		int no1 = total / 15;
		int no2 = total % 15;
	
		int result = (total == 0) ? ( 1 ) : ((no2 > 0) ? (no1 + 1) : (no1));
		
		System.out.println("게시물 수 : " + total);
		System.out.println("페이지 수 : " + result);
		
		
	}
	
}
