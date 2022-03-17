package day09.ex;

/*
   문제 02 ]
   		반지름 하나를 랜덤하게 입력한 후
   		원의 넓이
   		원의 둘레
   		를 계산해서
   		출력하는 프로그램을 작성하라
   		
   		반지름 랜덤하게 만들어주는 함수
   		넓이 계산해주는 함수
   		둘레 계산해주는 함수
   		출력해주는 함수
   		각각 만들어서 작성하라
 */
public class Ex02 {
	public Ex02() {
		//반지름
		int rad = setInt();
		
		//넓이
		setArea(rad);
		
		//둘레
		setArround(rad);
		
		//출력
		toPrint(rad);
		
	}
	
	//1. 반지름 랜덤하게 발생시켜주는 함수
	public int setInt() {
		int rad = (int)(Math.random() * (100 - 1 + 1) + 1);
		return rad;
	}
	
	//2. 원의 넓이 구해주는 함수
	public double setArea(int rad) {
		double area = rad * rad * Math.PI;
		return area;
	}
	//3. 원의 둘레 구해주는 함수
	public double setArround(int rad) {
		double arround = 2 * rad * Math.PI;
		return arround;
	}
	
	//4. 출력해주는 함수
	public void toPrint(int rad) {
		System.out.print("반지름이 " + rad + " 인 원의 넓이는 : ");
		System.out.println(setArea(rad));
		System.out.print("반지름이 " + rad + " 인 원의 둘레는 : ");
		System.out.println(setArround(rad));
	}
	
	public static void main(String[] args) {
		new Ex02();

	}

}
