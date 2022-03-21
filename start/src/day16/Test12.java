package day16;
/*
  학생들의 점수를 기억하는 Map을 만들자

  여러 학생(String)의 한 과목 점수(Integer)
  
 */
import java.util.*;
public class Test12 {

	public Test12() {
		HashMap<String, Integer> student = new HashMap<String, Integer>();
		
		student.put("제니", 95);
		student.put("리사", 85);
		student.put("로제", 90);
		student.put("지수", 80);
		
		//키값만 꺼내보자
		Set<String> set = student.keySet();
		
		//키값과 데이터를 동시에 꺼내보자
		Set<Map.Entry<String, Integer>> entry = student.entrySet();
		
		//Iterator로 변환
		Iterator<Map.Entry<String, Integer>> itor = entry.iterator();
		while(itor.hasNext()) {
			Map.Entry<String, Integer> stud = itor.next();
			String key = stud.getKey();
			int value = stud.getValue();
			
			//출력
			System.out.println(key + " : " + value);
		}
		
	}

	public static void main(String[] args) {
		new Test12();
	}

}
