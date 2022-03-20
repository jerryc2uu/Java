package day14;
/*
 	Test05를 확인한 후 이 클래스를 확인하세요.
 	Test03에서 만든 문자열을 줄바꿈 기호(\n)를 
 	기준으로 분리해서 배열에 담아보자 
 	
 	배열 만들 때 필요한 것
 	1. 타입
 	2. 길이(갯수)
 */


 	
import java.util.*;
 	
public class Test04 {

	public Test04() {
			//1. 객체 만들고
		    StringBuffer buff = new StringBuffer();
				
		    //2. 반복해서 결합 작업
			buff.append("Hey boy\n");
		    buff.append("Make 'em whistle like a missile, bomb, bomb\n");
			buff.append("Every time I show up, blow up, uh\n");
		    buff.append("Make 'em whistle like a missile, bomb, bomb\n");
		    buff.append("Every time I show up, blow up, uh\n");
				
			//3. 문자열로 변환
			String song = buff.toString();
			
			//4. 줄바꿈 기호 기준으로 분리
			StringTokenizer token = new StringTokenizer(song, "\n");
			
			/*
			 	잘려진 데이터를 배열에 기억할 예정이므로 
			 	전체 잘려진 갯수를 알아낸다.
			 	
			 */
			
			int len = token.countTokens(); // 분리한 데이터의 갯수를 반환해주는 함수
				
			//5. 분리된 데이터를 기억할 배열 만들기
			String[] norea = new String[len];
			
			//6. 하나씩 꺼내서 배열에 담아준다.
			for(int i = 0 ; token.hasMoreTokens() ; i++) { // 마지막 데이터 꺼내는 순간 끝나는 함수니까
				//데이터 꺼내고
				String tmp = token.nextToken();
				//꺼낸 데이터 배열에 담기
				norea[i] = tmp;
			}
			
			// 배열 내용 출력
			for(String s : norea) {
				System.out.println(s);
			}
		
	}

	public static void main(String[] args) {
		new Test04();
	}

}
