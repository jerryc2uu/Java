package day18;
/*
  	result 폴더의 blackpink.txt 파일을 읽어보자.
  	
  	기본 스트림은 바이트 기반 스트림으로 
  	보조 스트림은 문자 기반 스트림으로 처리
  	
  	+) 스트림을 사용 할 때 주의 사항
  	 1. 방향이 같아야 한다.
  	 2. 크기가 같아야 한다.(바이트는 바이트끼리, 문자는 문자끼리)
  	 
  	 위 조건처럼 다른 계열의 스트림을 연결해서 사용해야 하는 경우
  	 InputStreamReader/OutputStreamWriter를 중간에 넣어 사용해야 한다.
  	 
  	 반드시 기본 스트림은 바이트 기반이어야 하고, 보조 스트림이 문자 기반이어야 한다.
  	 그 반대는 안 된다.
 */
import java.io.*;
public class Test08 {

	public Test08() {
		//기본 스트림
		FileInputStream fin = null;
		//중간(보조보조) 스트림
		InputStreamReader isr = null;
		//보조 스트림
		BufferedReader br = null;
		
		try {
			//스트림 연결
			fin = new FileInputStream("src/day18/result/blackpink.txt");
			isr = new InputStreamReader(fin);//크기가 다른 두 스트림 연결시켜주는 스트림
			br = new BufferedReader(isr);
			
			//문자 단위로 읽어야 하는 경우에 버퍼리더의 readLine() 쓰면 편하기 때문에 중간 스트림을 쓰는 것
			
			//몇 번 읽어야 할 지 모르므로
			while(true) {
				String str = br.readLine();
				
				if(str == null) {
					break;
				}
				
				System.out.println(str);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				fin.close();
			} catch(Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		new Test08();
		
	}

}
