package day16;
/*
   Set계열 특징
   	1. 입력 순서 보장 x  ==> 나름의 정렬 규칙이 있기 때문
    2. 중복 데이터 입력 x ==> 가로가 같으면 같은 사각형이 되게 클래스를 만든 경우에는??
							  TreeSet : equals() 오버라이딩 불필요, Compare() 안에서 오름차순으로 처리가 되기 때문 
							  HashSet : 해쉬코드로 정렬
 */




import java.util.*;

public class Test01 {
/*
  Nemo 클래스 만들고 가로가 같으면 같은 네모로 처리되게 하라.
  
  HashSet은 인터페이스 구현이 필요없다. 해쉬코드로 처리할 것이기 때문.
  
  먼저 넣은 데이터는 무시하고 나중에 넣은 데이터를 출력한다.(삭제하는 게 아님)
 */
   
	public Test01() {
		
		//HashSet은 해쉬코드로 정렬하기 때문에 해쉬코드를 안 만들면 중복 데이터가 입력된다.
		Nemo n1 = new Nemo(5, 3);
		Nemo n2 = new Nemo(5, 5);
		Nemo n3 = new Nemo(5, 6);
		Nemo n4 = new Nemo(5, 7);
	
		
		//HashSet 만든다
		HashSet set = new HashSet();
		
		//위에 만든 네모 두 개를 넣는다. 
		set.add(n1);
		set.add(n2);
		set.add(n3);
		set.add(n4);
		
		//set 계열 데이터 꺼내기 : Iteroator 변환 or list 계열로
		//ArryaList list = new ArrayList(set); 생략
		for(Object o : new ArrayList(set)) {
			System.out.println(o); // 함수는 인스턴스를 따르고 변수는 레퍼런스를 따른다. 
									//출력만 할 목적이면 최종적으로 오버라이딩된 Nemo의 toString()가 호출되므로 강제형변환은 불필요
		}
		
		
	}

	public static void main(String[] args) {
		new Test01();
	}

}
