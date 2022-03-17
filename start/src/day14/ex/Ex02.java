package day14.ex;

import day14.Nemo;

/*
   문제 02]
   		사각형의 정보를 기억하는 클래스 sagak를 제작하라
   		필요한 변수, 함수, 생성자는 필요한 만큼만 추가
   		
   		단, 가로와 세로가 동시에 같은 사각형만 같은 사각형으로
   		처리가 되도록 오버라이딩
   		
   		이 클래스 객체를 출력하면 내용이 출력되도록 toString() 오버라이딩
 */
public class Ex02 {

	public Ex02() {
		
		//네모 객체 두 개 만들고
		 	Sagak n1 = new Sagak(20, 10);
			Sagak n2 = new Sagak(10, 20);
				
		//결과값 변수
			boolean bool = n1.equals(n2);
			String result = (bool == true) ? " 같은 " : " 다른 ";
		
		//출력
			System.out.println("n1과 n2 네모는 " + result + " 네모입니다.");
			System.out.println("n1 : \n\t " + n1);
			System.out.println("n1 : \n\t " + n2);
			System.out.println();
		}

	public static void main(String[] args) {
		new Ex02();
	}

}
