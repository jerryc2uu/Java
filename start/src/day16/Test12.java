package day16;
/*
  학생들의 점수를 기억하는 Map을 만들자


  여러 학생(String)의 한 과목 점수(Integer)
  //int는 객체(참조형)타입이 아니다. 제너릭스 선언에서는 참조형 타입을 써야 한다.
  
 */
import java.util.*;
public class Test12 {

	public Test12() {
		HashMap<String, Integer> student = new HashMap<String, Integer>();
		
		//map에 키값과 데이터를 넣는다.
		student.put("제니", 95);
		student.put("리사", 85);
		student.put("로제", 90);
		student.put("지수", 80);
		
		//키값만 꺼내보자
		Set<String> set = student.keySet();
		
		//키값과 데이터를 동시에 꺼내보자
		//Map.Entry가 4개 채워져 있을 것, 키는 String 데이터는 Integer
		Set<Map.Entry<String, Integer>> entry = student.entrySet();
		
		//Iterator로 변환
		Iterator<Map.Entry<String, Integer>> itor = entry.iterator();
		while(itor.hasNext()) {
			Map.Entry<String, Integer> stud = itor.next();
			String key = stud.getKey();
			int value = stud.getValue();//자동 언박싱 된다.
			
			//출력
			System.out.println(key + " : " + value);
		}
		
	}

	public static void main(String[] args) {
		new Test12();
	}

}
