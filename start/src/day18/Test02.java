package day18;
/*
   result 폴더에 있는 blackpink.txt 파일을 읽어보자
 */
    
import java.io.*;
public class Test02 {

	public Test02() {
		//기본(타겟) 스트림 준비
		FileReader fr = null;
		
		try {
			//파일에 스트림 연결
			fr = new FileReader("src/day18/result/blackpink.txt");
			
			/*
			//1. 한 글자만 읽어보자
			int ch = fr.read();//이 함수 자체의 반환값이 int(읽은 문자의 아스키코드값)이기 때문에 int 타입 변수 선언
			==> char ch = (char) fr.read(); 가능
			
			//출력
			System.out.println("읽은 문자 : " + (char) ch);// 코드값으로 반환된 숫자를 문자로 강제 형변환 해준다.
			
			//2. 여러 글자 읽어보자
			
			//문자 배열 준비
			char[] buff = new char[1024];
			
			//읽은 데이터를 buff에 채워준다. 반환값은 읽은 문자의 갯수
			int len = fr.read(buff);
			
			//읽은 데이터를 문자열로 변환
			String str = new String(buff, 0, len);
			System.out.println(str);
			 */
			
			//3. 전체를 읽어보자
			//문자 배열 준비
			char[] buff = new char[1024];
			while(true) {
				//읽은 데이터를 buff에 채워준다. len은 읽은 갯수
				int len = fr.read(buff);
				
				if(len == -1) {
					//읽어온 문자가 없는 경우
					break;
				}
				
				//이 행을 실행하는 경우는 읽어온 문자가 있는 경우이므로 출력해준다.
				String str = new String(buff, 0, len);
				
				//출력
				System.out.print(str);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		new Test02();
	}

}
