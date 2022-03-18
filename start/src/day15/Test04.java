package day15;
/*
   특정 문자열에서 원하는 규칙에 맞는 부분만 추출해서 출력
   
 */
import java.util.regex.*;

public class Test04 {

	public Test04() {
		String tel = "HP : 010-1234-5678";
		// 위 전화번호에서 실제 번호만 추출해서 출력
		
		//1. 패턴을 만든다
		Pattern form = Pattern.compile("01[0-9]-\\d{3,4}-\\d{4}");
		//2. 패턴에 맞는지 검사한다
		Matcher mat = form.matcher(tel);
		//3. 검사 결과 중 형식에 맞는 부분 추출
			// find() : 규칙에 맞는 부분을 확인해주는 함수. 반환값은 ture of false
			// group() : 규칙에 맞는 부분을 반환해주는 함수
			if(mat.find()) {
				String hp = mat.group();
				//출력
				System.out.println("전화번호 : " + hp);
			}
		
	}
		

	public static void main(String[] args) {
		new Test04();
	}

}