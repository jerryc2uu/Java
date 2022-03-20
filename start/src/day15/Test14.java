package day15;

import java.util.*;
public class Test14 {

	public Test14() {
		/*
	
			TreeSet은 정렬 불가능한 데이터들은 입력할 수 없다.
		
		
		
		TreeSet set = new TreeSet();//TreeSet은 오름차순 정리를 하는데 객체는 오름차순 정리가 불가능하다.
		Won w1 = new Won(5);
		Won w2 = new Won(10);
		
		set.add(w1);
		set.add(w2);
		
		ArrayList list = new ArrayList(set);
		
		for(Object o : list) {
			System.out.print(o + " ");
		}
		
		==> 이 작업은 에러가 발생하는데 원인은 Won 객체가 정렬할 수 없는 데이터이기 때문
			
			해결방법
				1. TreeSet을 만들 때 정렬 방식을 알려주면서 만든다. ==> Comparator 이용
				2. Won을 정렬 가능한 클래스로 만든 후 입력해준다. ==> 정렬 가능한 클래스로 만들어서 입력하는 방법
				 	==> Comparable 인터페이스를 구현하는 클래스로 제작
						compareTO()라는 함수를 오버라이딩해서 만든다.
		*/
		
		
		// 1번 방법
		TreeSet set = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Won w1 = (Won) o1;
				Won w2 = (Won) o2;
				
				int result = w1.getRad() - w2.getRad();
				//내림차순 정렬 예정이므로 부호를 반전시켜 반환한다.
				return -result;
			}
			
		});
		
		Won w1 = new Won(5);
		Won w2 = new Won(10);
		
		set.add(w1);
		set.add(w2);
		
		//출력
		Iterator itor = set.iterator();
		while(itor.hasNext()) {
			Won w = (Won) itor.next();
			System.out.println(w);
		}
	}

	public static void main(String[] args) {
		new Test14();
	}

}
