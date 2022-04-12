package formatTest;

import java.text.*;
import java.util.*;
public class Test04 {

	public Test04() {
		/*
		 	"INSERT INTO emp VALUES( 1234, '제니', 'jennie')"
			"INSERT INTO emp VALUES( 1235, '리사', 'lisa')"
			"INSERT INTO emp VALUES( 1236, '로제', 'rose')"
			"INSERT INTO emp VALUES( 1237, '지수', 'jisoo')"
			
			위 질의명령들을 ArrayList에 담아서 하나로 관리
		 */
		
		MessageFormat form = new MessageFormat("INSERT INTO emp VALUES( {0}, {1}, {2})");
		
		/*
		 	동일한 내용은 그대로 쓰고 변화되는 부분은 {0}, {1}, ... 로 기록한다.
		 	번호는 입력되는 데이터의 순서 의미
		 */
		
		Object[] data1 = {1234, "제니", "jennie"}; // 최상위클래스 Object, 따라서 모든 클래스는 Object 타입으로 볼 수 있다.
		Object[] data2 = {1235, "리사", "lisa"}; 
		Object[] data3 = {1236, "로제", "rose"};
		Object[] data4 = {1237, "지수", "jisoo"};
		
		String memb1 = form.format(data1);
		String memb2 = form.format(data2);
		String memb3 = form.format(data3);
		String memb4 = form.format(data4);
		
		//문자열만 모아두는 list
		ArrayList<String> list = new ArrayList<String>();
		list.add(memb1);
		list.add(memb2);
		list.add(memb3);
		list.add(memb4);
		
		/*
		//꺼내서 출력
		for(String sql : list) {
			System.out.println(sql);
		}
		*/
		
		/*
		 	list에서 변화되는 데이터만 추출하고 싶다면
		 	
		 	1. MessageFormat에서 데이터가 들어갈 부분을 명시한 패턴을 만든다
		 	2. parse 함수로 데이터 부분을 추출해내면 된다.
		 */
		
		//제니만 뽑아보자
		String jennie = list.get(0);
		
		Object[] result1 = null;
		try {
			result1 = form.parse(jennie);
			
			//출력
			for(int i = 0 ; i < result1.length ; i++) {
				System.out.println((i+1) + " 번째 데이터 : " + result1[i]);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Test04();
	}

}
