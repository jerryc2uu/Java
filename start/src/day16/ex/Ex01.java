package day16.ex;
/*
	5 ~ 10 사이의 정수를 랜덤하게 발생시켜서
	그 수만큼의 학생의 점수를 기억하는 
	HashMap 을 만들어서 데이터를 기억시키고
	꺼내서 출력하세요.
	데이터를 꺼낼때 키를 모두 추출해서 꺼내는 방식으로 출력하세요.
 */

import java.util.*;
public class Ex01 {
	
	
	public Ex01() {
		//학생 수 발생
		int no = (int)(Math.random()*(10-5+1)+1);
		
		ArrayList names = new ArrayList();
		for (int i = 0 ; i < no ; i++) {
			names.add((char)A+i);
			get()
		}
	

		HashMap map = new HashMap();
		
		//데이터 추가
		for(int i = 0 ; i < no ; i++ ) {
			map.put("i+1", (int)(Math.random()*(100-60+1)+60));
		}
		
		//키값 모두 추출
		Set keys = map.keySet();
		for(Object key : keys) {
			Object value = map.get(key);
			System.out.println(key + " : " + value);
		}
			
			
		
		
	}
	
	public void setNames() {
		for(int i = 0 ; i < (int)(Math.random()*(10-5+1)+1) ; i++ {
			
		}
			
	}
	
	public static void main(String[] args) {
		new Ex01();
	}
	
}




