package day14;

//Nemo 객체 두 개를 만들어서 같은 네모인지 판별해서 출력하라

public class Test02 {

	public Test02() {
		//네모 객체 두 개 만들고
		Nemo n1 = new Nemo(20, 10);
		Nemo n2 = new Nemo(10, 20);
		
		//결과값 변수
		String result = (n1.equals(n2)) ? " 같은 " : " 다른 ";// Object는 상위 클래스, 따라서 어떤 타입을 넣든지 Object로 자동 형변환된다.
															  // 다시 Object 타입을 Nemo 타입으로 강제 형변환하게 된다. Nemo -> Object -> Nemo 순서
		
		System.out.println("n1과 n2 네모는 " + result + " 네모입니다.");
		System.out.println("n1 : \n\t " + n1);
		System.out.println("n1 : \n\t " + n2);
		System.out.println();
		System.out.println("n1 == n2 : " + (n1 == n2)); //false인 이유 : 주소값 비교이기 때문
														// 레퍼런스 타입은 절대로 이렇게 하면 안 된다. 내용 비교하려면 equals() 호출
	}

	public static void main(String[] args) {
		new Test02();
	}

}
