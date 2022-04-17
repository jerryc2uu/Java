package toyProject;

import java.util.*;
public class Test01 {

	public Test01() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요!");
		int no = sc.nextInt();
		switch(no) {
			case 3:
				System.out.println("6");
				break;
			case 6:
				System.out.println("3");
				break;
		}
	}

	public static void main(String[] args) {
		new Test01();
	}

}
