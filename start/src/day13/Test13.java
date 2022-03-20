package day13;
/*
   강제 예외 던지기

   : 자바는 예외로 인정하지 않지만 프로그램 목적 상 예외로 처리해야 하는 경우 사용하는 방법

 */
import java.util.*;

public class Test13 {

	/*
	   사용자가 나이를 입력하면 입력된 나이를 출력하는 프로그램을 작성하세요.
	   단, 나이를 음수로 입력하면 예외로 처리되게 하라
	   = 강제로 예외가 발생하게 하라
	*/
	
	public Test13() {
		Scanner sc = new Scanner(System.in);
		
		try {
			getAge(sc);
		} catch(Exception e) {
//			e.printStackTrace();  ==> 예외의 내용이 나오지 않는다. 이 때 필요한 것이 사용자 예외 클래스
			System.out.println("Error : 나이가 음수로 입력되었습니다.");
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
			throw new Exception();
			
		} else {

			System.out.println("입력된 나이는 " + age + " 입니다.");
		
		}
			
		
	}

	public static void main(String[] args) {
		new Test13();
	}

}
