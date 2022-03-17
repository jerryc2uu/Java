package day12.sub;
/*
 
랜덤하게 3 ~ 5 정수를 발생시켜서
	3 이 나오면 삼각형
	4 가 나오면 사각형
	5 가 나오면 원
의 형태로 10의 도형을 만들어서 
하나의 변수로 관리하고
각 도형의 내용을 출력하세요.

*/

public class Ex01 {
	private Figure[] fig;
	
	public Ex01() {
		setFig();
		
		figPrint();
	}
	
	//1. 난수 발생 함수
	public int getRndNo() {
		return (int)(Math.random() * 3 + 3);
	}
	
	//2. 배열 변수 초기화 함수
	public void setFig() {
		fig = new Figure[10];
		
		//빈 방에 도형 넣기
		for(int i = 0 ; i < 10 ; i++) {
			int no = getRndNo();
			
			switch(no) {
			case 3://삼각형
				fig[i] = fig[i] = new Semo((int)(Math.random() * 21 + 5), (int)(Math.random() * 21 + 5));
				break;
			case 4://사각형
				fig[i] = fig[i] = new Nemo((int)(Math.random() * 21 + 5), (int)(Math.random() * 21 + 5));
				break;
			case 5://원
				fig[i] = fig[i] = new Won((int)(Math.random() * 21 + 5));
				break;
			}
		}
		
	}
	
	// 3. fig 배열 출력 함수
	public void figPrint() {
		for(Figure f : fig) {
			f.toPrint();
		}
	}
	public static void main(String[] args) {
		new Ex01();
	}

}
