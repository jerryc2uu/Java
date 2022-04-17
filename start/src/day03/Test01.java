package day03;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("*** Git 연동 성공 ***");
		
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		if(no == 3) {
			System.out.println("6");
		} else if (no == 6) {
			System.out.println("3");
		}
	}
}
