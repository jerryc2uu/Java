package day14.ex;

/*
   문제 1 ]
   		원의 정보를 기억할 클래스를 제작하라
   		가지는 정보는 반지름, 면적, 둘레
   		기능은 변수들에 접근할 수 있는 함수들 
   		+ 면적이 같으면 같은 원으로 처리해주는 
   		  equals() 함수로 오버라이딩
   		+ 이 클래스 타입의 변수를 출력하면 
   		  해당 원의 정보를 출력해주는 toString()함수도 오버라이딩
   		
 */
public class Ex01 {

	public Ex01() {
		//원 객체 두 개 만들고\
		Circle won1 = new Circle((int)(Math.random()*(10 - 1 + 1) + 1 ));
		Circle won2 = new Circle((int)(Math.random()*(10 - 1 + 1) + 1 ));
		
		//결과값 변수
		String result = (won1.equals(won2)) ? " 같은 " : " 다른 ";
		
		System.out.println("won1과 won2 원은 " + result + " 원입니다.");
		System.out.println("won1 : \n\t " + won1);
		System.out.println("won2 : \n\t " + won2);
		System.out.println();
		
	}

	public static void main(String[] args) {
		new Ex01();
	}

}
