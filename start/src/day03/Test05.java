package day03;

public class Test05 {
	public static void main(String[] args) {
		int no1 = 10;
		int no2 = 20;
		
		/*
		int no3 = no1++ + ++no2; // no1 = 10, no2 = 21, no3 = 31
		
		System.out.println("no1 : " + no1);// no1 = 11
		System.out.println("no1 : " + no1);// 위의 변수값 11이 계속 기억됨
		System.out.println("no2 : " + no2);// 위의 변수값 21이 계속 기억됨
		System.out.println("no3 : " + no3);// 위의 변수값 31이 계속 기억됨
		*/
		
		int no = no1-- + ++no2; // no1 = 10
		System.out.println("no1 : " + no1);// no1 = 9
		System.out.println("no1 : " + no1);// no1 = 9
		System.out.println("no2 : " + no2);// no1 = 9
		System.out.println("no4 : " + no);// no1 = 9
		
	}
}
