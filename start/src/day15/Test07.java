package day15;

import java.util.*;

public class Test07 {

	public Test07() {

		ArrayList vec = new ArrayList();
		
		//데이터 입력
		vec.add("제니");
		vec.add('F'); 
		vec.add(27);
		vec.add(168.5);
		vec.add(false);
		
		// 자동화 처리
		for(int i = 0 ; i < vec.size(); i++) {//capacity() : 데이터를 채울 수 있는 공간, size() : 공간에 채워진 데이터의 갯수
			// 데이터 꺼내고	
			Object o = vec.get(i);//따로 설정하지 않으면 모든 데이터는 Object 타입으로 기억되기 때문
			//꺼낸 데이터가 어떤 타입의 데이터인지 모르므로
			if(o instanceof String) {
				String str = (String) o;
				System.out.println("이름 : " + str);

			} else if(o instanceof Integer) {
				int age = (int) o;
				System.out.println("나이 : " + age);
				
			} else if(o instanceof Character) {
				char gen = (char) o;
				System.out.println("성별 : " + gen);
				
			} else if(o instanceof Double) {// 이 연산자에 기본 데이터 타입을 쓸 순 없음. 클래스 타입에만 쓸 수 있는 연산자
				double height = (double) o;
				System.out.println("신장 : " + height);
				
			} else if(o instanceof Boolean) {
				boolean bool = (boolean) o;
				System.out.println("학원 : " + bool);
				
			}
		}
		
		//이렇게 여러 형태의 데이터가 입력된 경우에는 데이터를 사용하는 시점에서는 원래 데이터로 강제 형변환해서 사용해야 함
		
		/*
		   컬렉션의 특징을 여러 형태의 데이터를 동시에 보관할 수 있다는 것이다.
		   하지만 배열과 마찬가지로 한가지 타입으로만 통일해서 쓰는 게 일반적
		 */
	}

	public static void main(String[] args) {
		new Test07();
	}

}
