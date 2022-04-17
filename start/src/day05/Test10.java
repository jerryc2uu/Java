package day05;
/*
 	do - while 명령문
 */
public class Test10 {

	public static void main(String[] args) {
		
		int no = 10;
		
		do {
			System.out.println("no : " + no);//조건식 관계 없이 적어도 1회 실행
			++no;
		} while(no < 10); 

	}

}
