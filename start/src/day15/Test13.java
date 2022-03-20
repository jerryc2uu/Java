package day15;
/*
  HashSet에 랜덤하게 숫자 6개를 채워보자
  set 계열의 특징
  1. 입력 순서 보장 x
  2. 중복 데이터 허용 x
  
 */


  
import java.util.*;

public class Test13 {

	public Test13() {
		//HashSet을 만든다
		HashSet set = new HashSet();
		int count = 1;
		while(true) {
			//랜덤하게 정수 만들고
			int no = (int)(Math.random() * 11);
			
			//정수를 set에 채워준다.
			set.add(no);
			
			//6개만 입력할 예정이므로
			//채워진 숫자의 갯수를 꺼내온다.
			int len = set.size();
			
			if(len == 6) {
				break;
			}
			count++;
		}
		
		//출력
		//반복 횟수 출력
		System.out.println("1. 반복 횟수 : " + count);
		//내용 출력
		Iterator itor = set.iterator();
		while(itor.hasNext()) {
			System.out.print(((int)itor.next()) + " ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		new Test13();
	}	

}
