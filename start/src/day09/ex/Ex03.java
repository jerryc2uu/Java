package day09.ex;
/*
  문제 03 ]
  		사각형의 넓이를 계산하는 프로그램을 작성하세요.
  		
  		길이(정수) 랜덤하게 만들어주는 함수
  		넓이 계산해주는 함수
  		사각형의 내용을 출력해주는 함수
  		 
 */
public class Ex03 {
	
	int garo, sero, area;
	
	public Ex03() {
		
		//길이
		garo = getInt();
		sero = getInt();
		//넓이
		setArea(garo, sero);
		//출력
		toPrint(garo, sero, area);
	}
	
	//1. 길이 랜덤하게 만들어주는 함수
	public int getInt() {
		int no = (int)(Math.random() * (20 - 1 + 1) + 1);
		return no;
	}
		
	//2. 넓이 계산해주는 함수
	public int setArea(int garo, int sero) {
		area = garo * sero;
		return area;
	}
	//3. 내용 출력해주는 함수
	public void toPrint(int garo, int sero, int area) {
		System.out.println("가로 : " + garo);
		System.out.println("세로 : " + sero);
		System.out.println("넓이 : " + area);
	}
		
		
	public static void main(String[] args) {
		new Ex03();

	}
	
	
}
