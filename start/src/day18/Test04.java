package day18;
/*
   버퍼리더를 사용해서 휘파람.txt 파일을 읽어보자

 */
import java.io.*;
public class Test04 {

	public Test04() {
		//기본(타겟) 스트림
		FileReader fr = null;
		//보조(필터) 스트림
		BufferedReader br = null;//2byte씩 처리하지 않고 모아놨다가 한 번에 채워진 내용 만큼 처리하려고
		
		try {
			//스트림 연결
			fr = new FileReader("src/day18/result/blackpink.txt");
			br = new BufferedReader(fr);
			
			//읽은 데이터 기억할 배열 준비
			char[] buff = new char[1024];//한 번에 1024 문자 일괄적으로 처리
			
			//몇 번 읽어야할지 모르므로
			while(true) {
				String line = br.readLine();//줄 단위로 한 행씩 읽는 함수, 줄바꿈기호는 읽지 않는다. 따라서 줄바꿈은 println으로 따로 해줘야 한다.
											//읽는 것이기 때문에 flush() 불필요
				//읽은 데이터가 없는 경우는 함수 즉시 종료
				if(line == null) {
					break;
				}
				
				//읽은 데이터가 있는 경우는 출력
				System.out.println(line);
				/*
				  println()은 내용 출력 후 줄을 바꾸는 함수
				  이미 readLine()에서 한 행을 읽은 후
				  줄바꿈기호를 버렸기 때문에 읽은 내용을 그대로 출력하기에
				  자동으로 줄이 바뀌지 않는다.
				  따라서 강제로 줄바꿈 작업을 해줘야 한다. 그래서 println() 사용한 것
				   
				 */
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();	
				fr.close();
				
			} catch(Exception e) {
			}
		}
	}
				

	public static void main(String[] args) {
		new Test04();
	}

}
