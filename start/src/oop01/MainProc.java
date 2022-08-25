package oop01;

/*
 	숫자를 입력받아서 그 숫자 만큼의 크기를 갖는 정수 배열을 만들고
	랜덤하게 1 ~ 25 사이의 정수를 발생시켜서 배열에 기억시키고
	그 배열의 내용을 출력
	
	단, 배열 초기화, 배열 셋팅, 배열 출력은 ArrProc라는 클래스에서 기능을 구현하라
	
*/
import java.util.*;
public class MainProc {

	public MainProc() {
		//데이터 입력 받을 준비
		Scanner sc = new Scanner(System.in);
		int no = 0;
		
		while(true) {
				
			//메세지 출력
			System.out.print("* 만들 배열의 길이 : ");
			//정수 꺼내오고
			String sno = sc.nextLine();
			
			try {
				no = Integer.parseInt(sno); // sno를 정수로 변환..
				//정수로 변환 성공하면 반복 종료
				break;
			} catch(Exception e) {
				System.out.println("숫자 형태로 입력하세요.");
			}
		
		}
		
		ArrProc ap = new ArrProc();
		
		//배열 만들고
		int[] num = ap.intArr(no);
		
		//배열에 데이터 채우고
		ap.setArr(num);
		
		// 출력
		ap.printArr(num);
		}
		
				
	

	public static void main(String[] args) {
		new MainProc();
	}

}
