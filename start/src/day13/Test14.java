package day13;

//사용자 예외 클래스 사용해보기
import java.util.*;

public class Test14 {

	/*
	   사용자가 나이를 입력하면 입력된 나이를 출력하는 프로그램을 작성하세요.
	   단, 나이를 음수로 입력하면 예외로 처리되게 하라
	   = 강제로 예외가 발생하게 하라
	   
	 */
	
	public Test14() {
		Scanner sc = new Scanner(System.in);
		
		try {
			getAge(sc);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAge(Scanner sc) throws Exception {
		//메세지 출력
		int age = 0;
		
		while(true) {
			System.out.print("* 나이 입력 : ");
			try {
				age = sc.nextInt();
				break;
				
			} catch(Exception e) {
				System.out.println("# 잘못된 입력입니다.");
			}
		}
		
		if(age < 0) {
			//나이가 음수로 입력된 경우이므로 강제로 예외 발생 
			throw new MinusAge();
			
		} else {

			System.out.println("입력된 나이는 " + age + " 입니다.");
		
		}
			
		
	}

	public static void main(String[] args) {
		new Test14();
	}

}
