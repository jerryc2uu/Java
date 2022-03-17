package day04.ex;


/*
     1.

     알파벳을 입력 받아서
     그 문자가 대문자인지 소문자인지를 판별하는 프로그램을 작성하세요.
  
     2. 숫자 또는 알파벳을 입력 받아서
     그 문자가 대문자인지 소문자인지를 판별하는 프로그램을 작성하세요.
     
 */


import java.util.*;
public class Ex0201 {
	public static void main(String[] args) {
		
		 // 1번
			Scanner sc1 = new Scanner(System.in);
			
			System.out.println("알파벳 입력 : ");
			String str1 = sc1.nextLine();
			sc1.close();
			
			char ch1 = str1.charAt(0);
			
			String result1 = (ch1 < 'a') ? "대문자" : "소문자";
			
			System.out.println("입력한 문자 : " + ch1);
			System.out.println("판별 : " + result1);
			
			
			
			
	     // 2번		
			Scanner sc2 = new Scanner(System.in);
			
			System.out.println("문자 입력 : ");
			String str2 = sc2.nextLine();
			sc2.close();
			
			char ch2 = str2.charAt(0);
			
			String result2 = (ch2 < 'A') ? "숫자" : ((ch2 < 'a') ? "대문자" : "소문자");
			
			System.out.println("입력한 문자 : " + ch2);
			System.out.println("판별 : " + result2);
			
	}
}
