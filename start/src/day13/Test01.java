package day13;

import day12.sub.*;

/*
   day12.sub 패키지의 Figure 인터페이스를 구현한 삼각형과 사각형을 
   무명내부클래스를 만들어서 사용해보자
 */
public class Test01 {
	int width = (int)(Math.random()*21+5);//전역변수 : 프로그램 종료 시까지 유지, heap에 생성
	int height = (int)(Math.random()*21+5);
	double area;
	Figure fig, fig1;
	
	
	public Test01() {
		//int width = (int)(Math.random()*21+5);  ==> 변수에서 만든 리터럴이 리터럴 풀에 쌓임. 함수 호출 시 그 리터럴 자체를 사용(변수에 접근하지 않음)
		//int height = (int)(Math.random()*21+5);
		//double area;       ==> 함수 실행 후에는 이미 사라지고 없는 변수, stack에 생성
		
		
		//사각형
		fig = new Figure() {
			@Override
			public void setArea() {
				area = width * height;
				
			}

			@Override
			public void toPrint() {
				setArea();
				System.out.printf("이 사각형은 가로가 %3d 이고, 세로가 %3d 이고, 면적이 %6.2f 입니다.", width, height, area);
				System.out.println();
				
			}
		};
		
		//삼각형
		fig1 = new Figure() {
			//int width = (int)(Math.random()*21+5);
			//int height = (int)(Math.random()*21+5);
			//double area;
			@Override
			public void setArea() {
				area = width * height * 0.5;
				
			}
			
			@Override
			public void toPrint() {
				setArea();
				System.out.printf("이 삼각형은 밑변이 %3d 이고, 높이가 %3d 이고, 면적이 %6.2f 입니다.", width, height, area);
				System.out.println();
				
			}
		};
	}
	public static void main(String[] args) {
		Test01 t1 = new Test01();
		//사각형 면적 구하고
		//t1.fig.setArea();
		//사각형 내용 출력
		t1.fig.toPrint();
		//삼각형 내용 출력
		t1.fig1.toPrint();
		System.out.println("사각형 가로 : " + t1.width);

	}

}
