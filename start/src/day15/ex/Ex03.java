package day15.ex;
/*
학생 한명의 정보를 저장할 클래스를
 제작하세요
정보는
	학생이름, 반, 번호, 
	자바, 데이터베이스, 웹, 스프링 점수
	총점, 평균
를 기억하게 하고

10명의 학생을 TreeSet에 입력하고
반 순서대로 정렬되도록 하세요.
반이 같으면 번호순으로 정렬되도록 하세요.

*/
import java.util.*;
public class Ex03 {


	public Ex03() {
		
		String[] name = new String[10];

		
		for(int i = 0 ; i < name.length ; i++) {
			char ch = (char)('A'+ i);
			String str = ch + " ";
			name[i] = str;
		}
		
		// 1. list 계열로 변환 후 출력
		System.out.println("1. list 계열로 변환 : ");

		TreeSet set = new TreeSet();
		
		for(int i = 0 ; i < name. length ; i++) {
			set.add(new Student(name[i]));
		}
		
		
		ArrayList list = new ArrayList(set);
		
		
		for(Object o : list) {
			Student s = (Student) o;
			System.out.println(s);
		}
		
		System.out.println();
		
		// 2. 무명 내부 클래스
		System.out.println("2. 무명 내부 클래스 : ");
		TreeSet set1 = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				
				int result = s1.getBan() - s2.getBan();
				
				if(result == 0) {
					result = s1.getNum() - s2.getNum();
				}
				return -result;
			}
		});
		
		for(int i = 0 ; i < name. length ; i++) {
			set1.add(new Student(name[i]));
		}
		
		Iterator itor = set1.iterator();
		while(itor.hasNext()) {
			Student s = (Student) itor.next();
			System.out.println(s);
		}
			
			
		
		
		
		
		
			
		
	}

	public static void main(String[] args) {
		new Ex03();
	}

}
