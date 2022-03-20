package day15.ex;

import java.util.*;

/*
1 ~ 99 사이의 정수를 랜덤하게 발생시켜서 
10개를 TreeSet에 입력한 후
내림차순으로 정렬해서 출력하세요.
*/
public class Ex02 {

	public Ex02() {
		
		TreeSet set = new TreeSet();
		
		//데이터 입력
		for(int i = 0 ; i < 10 ; i++) {
			int no = (int)(Math.random()*(99-1+1)+1);
			set.add(no);
		}
		//출력
		ArrayList list = new ArrayList(set);

		//내림차순 정리
		Collections.sort(list, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				int result = 0;
				
				int no1 = (int) o1;
				int no2 = (int) o2;
				
				result = no1 - no2;
				
				return -result;
			}
			
		});  
		
		for(Object o : list) {
			int no = (int) o;
			System.out.print(no + " ");
		}
		
		
		
	}

	public static void main(String[] args) {
		new Ex02();
	}

}
