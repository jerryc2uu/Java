package day15;
/*
   파라미터로 전달된 문자열 


   	http://www.blackpink.org/member/?id=ens&pw=12345&tel=01031759042
   	중에서 넘겨진 데이터만 잘라서 출력하라
   	
 */
import java.util.*;

public class Test01 {

	public Test01() {
		String url = "http://www.blackpink.org/member/?id=ens&pw=12345&tel=01031759042";//get방식 : 주소에 데이터가 그대로 노출

		//위 문자열에서 데이터 부분만 추출하려면 
		//? 기호의 위치값을 알아낸 후 그 바로 다음 위치에서부터 끝까지 잘라내면 된다.
		//StringTokenizer는 따로 배열에 담아야해서 귀찮어
		
		int idx = url.indexOf('?');//url.은 String 클래스 타입의 멤버에 접근해서 사용하겠다는 의미 
									// Math.radom()//Math 클래스 안의 멤버 random() 쓰겠다는 의미 
								   //indexOf : 특정 문자의 위치값 알아내는 함수
		String param = url.substring(idx + 1); //=>id=ens&pw=12345&tel=01031759042
		
		System.out.println(param);
 		
		//만들어진 문자열을 &를 기준으로 잘라내서 배열에 담아본다.
		StringTokenizer token = new StringTokenizer(param, " & ");
		//잘려진 갯수 알아내고
		int cnt = token.countTokens();
		//문자열 배열을 만든다.
		String[] tmp = new String[cnt];//null 상태의 배열들
		//배열에 잘려진 내용을 순차적으로 채운다.
		
		/*
		int i = 0;
		while(token.hasMoreTokens()) {//임시 메모리에 꺼낼 데이터가 있는지 계속 확인, 사용 즉시 소멸
			tmp[i++] = token.nextToken();
			//i++;
		}
		*/
		
		for(int i = 0 ; token.hasMoreTokens() ; i++) { // ****반복문에서 조건식에는 참 거짓이라는 논리값만 있으면 된다. if문도 마찬가지로 논리값만 나오면 된다.
			tmp[i] = token.nextToken(); //이 명령을 실행하는 순간 버퍼 메모리에서 꺼낸 데이터는 삭제
		}
		/*
		   반복문에서 조건식의 의미는 반복횟수의 컨트롤
		   만일 무한 반복되면 다른 처리는 할 수 없기 때문에
		   
		   +) cpu는 코어 1개당 한 가지 일만 한다.
		*/
		System.out.println(Arrays.toString(tmp));
		String[][] data = new String[cnt][2];//  총 3개가 있고, 이걸 분리하면 "=" 기준으로 두 개 나옴
		for(int i = 0 ; i < tmp.length ; i++) {
			String str = tmp[i];
			StringTokenizer tk = new StringTokenizer(str, "=");
			
			data[i][0] = tk.nextToken();
			data[i][1] = tk.nextToken();
			
		}
		//결과 출력
		for(String[] arr : data) {
			/*
			for(String s : arr) {
				System.out.print(s + " : ");
			}
			System.out.println();
			 */
			System.out.println(arr[0] + " : " + arr[1]);
			
			
		}
	}

	public static void main(String[] args) {
		new Test01();
		
		
		
	}

}
