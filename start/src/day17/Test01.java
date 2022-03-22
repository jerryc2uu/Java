package day17;
/*
    파일에 내용을 저장하는 프로그램을 만들어보자.
 */
import java.io.*;
public class Test01 {

	public Test01() {
		//파일에 저장하기 위해서는 파일로 연결된 스트림이 필요
		FileOutputStream fout = null;  //예외 처리가 필요하기 때문, 경로가 잘못되면 파일을 만들 수 없으므로
		
		try {
			//fout = new FileOutputStream("C:\\class\\java\\1hakwon_repo\\begin\\start\\src\\day17\\result");//절대경로 이용
			fout = new FileOutputStream("src/day17/result/FileTest01.txt");
			//파일이 존재하지 않아도 자동으로 만들어준다.
			// fout은 파이프, 데이터를 여기로 흘려보내면 자동적으로 처리된다.
			/*
			//1. 한 글자만 입력해보자
			//fout.write('j');//char ==> int 자동 형변환
			
			//2. 여러 글자를 입력해보자
			//문자열 준비
			String song = "Hey boy\r\nMake 'em whistle like a missile, bomb, bomb";//\r\n : 엔터키와 같은 기능
			//문자열 byte[]로 변환
			byte[] buff = song.getBytes(); //getBytes() : 문자열 => byte[]
			//배열을 스트림에 흘려보낸다.
			fout.write(buff);
			*/
			
			//3. 지정한 부분만 내보내보자
			String song = "Make 'em whistle like a missile, bomb, bomb";
			byte[] buff = song.getBytes();
			fout.write(buff, 9, buff.length - 9); // 9 : 시작 인덱스, buff.length - 9 : 내보낼 갯수
			
			System.out.println("***파일 저장 성공***");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//외부 장치와 연결된 경우 해당 외부 장치의 사용이 끝나면 닫아주는 것이 원칙
			try {
				fout.close();// close() : 예외를 전이하는 함수로 함수 호출한 곳에서 예외 처리
				
			} catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		new Test01();
	}

}
