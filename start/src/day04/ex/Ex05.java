package day04.ex;

/*
   3자리 숫자(100 ~ 999)를 입력받아서


   이 숫자에 가장 가까운 100의 배수를 만들기 위해서는 
   얼마가 필요한지를 계산해서 출력해주는 프로그램을 작성하세요.
   
   예 ]
     241은 200에 가까우므로 41을 빼야한다.
     777은 800에 가까우므로 23을 더해야 한다.
     999는 100에 가까우므로 1을 더해야 한다.
     
 */
//import java.util.*;

import javax.swing.*;
public class Ex05 {
	public static void main(String[] args) {
	
	/*	
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		
		int num = sc.nextInt();
		
		int no = num % 100;
		
						
	    String result = ( no > 50 ) ? (100 - no + "을(를) 더해야 한다.") : ( no + "을(를) 빼야 한다." ); 
		
	    System.out.println("숫자 : " + num);
	    System.out.println("필요한 수 : " + result);
	*/
		//세자리 정수를 입력 받는다.
		String sno = JOptionPane.showInputDialog("세 자리 정수 입력 : ");
		//입력받은 데이터는 정수 형태의 문자열이므로 정수로 변환해줘야 한다.
		//정수 형태의 문자열을 정수로 변환해주는 기능을 가지고 있는 함수는
		// Integer.parseInt(문자열)
		int no = Integer.parseInt(sno);
		
		// 10단위 이하만 추출해낸다.
		//int num = no - (no / 100 * 100)
		int num = no % 100;
		
		// num이 50보다 큰 지 판별한다.
		
	    int hap = 0;
		int result = 0;
		
		
		hap = (num > 50) ? (100 - num) : (num);
		//result = (num > 50) ? no + hap : ho - hap;
		
		result = num > 50 ? (no / 100 + 1) * 100 : (no / 100) * 100 ;
		
		String str = num > 50 ? "더해줘야 한다." : "빼줘야 한다.";
		
		//출력
		System.out.println("입력한 정수 : " + no + " 는 " + result + " 가까우므로 " + hap + " 을 " + str);
	}

}
