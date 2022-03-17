package day14;
/*
   문자열 데이터


   
   	"제니, 리사, 로제, 지수"
 */
import java.util.*;

public class Test05 {

	public Test05() {
		String member = " 제니, 리사, 로제, 지수";
		
		// , 를 기준으로 자른다.
		StringTokenizer token = new StringTokenizer(member, ",");
		/*
		   이렇게 객체가 만들어지면 잘려진 결과는
		   버퍼메모리(임시 메모리 공간)에 기억되고 하나씩 꺼내서 사용 
		   사용하는 즉시 소멸된다.
		   
		   결과를 재사용해야 한다면 변수나 배열에 저장시켜놔야 함
		   
		 */
		//배열에 담아보기
		// 잘려진 데이터의 갯수를 반환해주는 함수. 
		int len = token.countTokens();
				
		//데이터를 기억할 배열
		String[] pink = new String[len];
		
		//인덱스 변수 만들고
		int idx = 0; 
				
		// 하나씩 꺼내서 출력한다.
		while(token.hasMoreTokens()) {
			// Tokens: 임시메모리에 꺼낼 문자열이 있는지 여부를 논리값으로 반환
			// Elements : 임시메모리에 꺼낼 객체가 있는지 여부를 논리값으로 반환
			
			// 한 번 꺼낸 데이터는 소멸
			// 출력만 할 예정이므로 꺼내서 출력만하자
			
			String black = token.nextToken();
			
			// 배열에 기억
			pink[idx] = black;
			
			//인덱스 증가
			idx++;
			
			//출력
			System.out.println(black);
		}
		
		System.out.println("---------------------------------------");
		//꺼낸 데이터 다시 꺼내려 하면 실행조차 안 함
		while(token.hasMoreTokens()) {
			
			//String black = token.nextToken();
			String black = ((String)token.nextElement());//nextElement()의 반환값은 Object 타입이라 강제형변환 필요
			
			//출력
			System.out.println(black);
		}
		
		//배열 내용 출력
		for(String name : pink) {
			System.out.print(name + " , ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		new Test05();
	}

}
