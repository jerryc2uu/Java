package day17;
/*
   이전 예제에서 만든 파일을 읽어보자

 */
import java.io.*;
public class Test02 {

	public Test02() {
		//1. 파일로 연결된 스트림을 준비
		FileInputStream fin = null;
		
		try {
			//스트림 연결
			//fin = new FileInputStream("src/day17/result/FileTest01.txt"); // 프로젝트 기준 경로
			/*
			//2. 한 글자만 읽는다
			int ch = fin.read();
			//3. 출력
			System.out.println("읽은 문자  : " + (char) ch);
			 */
			
			/*
			//2. 여러 글자를 읽는다.
			//byte[] 준비
			byte[] buff = new byte[10]; //0으로 채워진 상태
			//읽은 갯수
			int len = fin.read(buff); // 읽은 글자의 byte를 위의 방 buff에 채워준다.
			
			//byte[]을 문자열로 변환
			String str = new String(buff, 0, len);//String 클래스에 byte[]을 문자열로 변환해주는 함수
			
			//3. 출력
			System.out.println("읽은 내용 : " + str);
			*/
			
			//Test01.java 파일을 읽어서 출력해보자
			fin = new FileInputStream("src/day17/Test01.java");
			//몇 글자 읽어야 할 지 모르므로 반복해서 처리한다. (더 이상 읽은 내용이 없을 때까지)
			//읽은 내용이 없는 경우는 int read(byte[] b)의 반환값에 -1을 반환해준다. (읽은 갯수가 -1일일 수는 없으니까)
			//따라서 함수 실행의 반환값이 -1이 될 때까지 반복해서 처리하면 된다.
			
			while(true) {
				//byte[] 준비
				byte[] buff = new byte[1024];
				//데이터를 읽는다.
				int len = fin.read(buff);
				if (len == -1) {
					//이 경우는 더 이상 읽어온 데이터가 없는 경우이므로 
					//반복을 즉시 종료한다.
					break;
				}
				//읽은 byte[]을 문자열로 변환해서 출력
				String str = new String(buff, 0, len);
				//출력
				System.out.print(str);

			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch(Exception e) {}
		}
		
	}

	public static void main(String[] args) {
		new Test02();
	}

}
