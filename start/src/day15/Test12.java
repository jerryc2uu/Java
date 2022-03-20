package day15;
/*
   블랙핑크 멤버를 HashSet에 저장한 후 꺼내서 출력
 */
import java.util.*;



public class Test12 {

	public Test12() {
		
		HashSet set = new HashSet();
		
		//데이터 추가
		set.add("제니");
		set.add("리사");
		set.add("로제");
		set.add("지수");
		
		//입력된 데이터 꺼내기
		// 갯수 꺼내고
			int len = set.size();
			System.out.println("채워진 멤버 수 : " + len);
			
			/*
			   Set계열 컬렉션은 데이터 꺼내는 함수가 존재하지 않는다.
			   따라서 
			   1. Iterator로 변환해서 순서대로 꺼내기
			   2. List 계열로 변환해서 인덱스로 꺼내기
			 */
			
			System.out.println("1. Iterator를 이용하는 방법");
		//1. Iterator로 변환
			Iterator itor = set.iterator();//set 내부에 이미 존재하는 함수, Iterator 타입으로 반환해주는 함수
			/*
			   Iterator는 StringTokenizer와 유사하게 
			   버퍼메모리에서 하나씩 순차적으로 꺼내고
			   꺼내는 순간 소멸된다. 
			 */
			while(itor.hasNext()) {
				//boolean hasNext() : 꺼낼 데이터가 남아있는지 알려주는 함수
				
				//데이터 꺼낸다.
				String name = (String) itor.next(); // next() : 데이터 꺼내서 반환해주는 함수
				
				//출력
				System.out.println(name);//해쉬코드값으로 정렬해서 보관된 것
			}
			
			System.out.println("2. List 배열로 변환해서 사용하는 방법");
		//2. List 계열로 변환
			Vector vec = new Vector(set);//set에 저장된 데이터로 Vector를 만든다는 뜻, 다른 컬렉션 데이터 복사해서 만든 것
			
			//데이터 꺼내서 출력//인덱스 있음
			for(int i = 0 ; i < vec.size(); i++) {
				String name = (String) vec.get(i);
				//출력
				System.out.println(name);
			}
			
	}

	public static void main(String[] args) {
		new Test12();
	}

}
