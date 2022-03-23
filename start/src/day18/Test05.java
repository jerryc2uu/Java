package day18;
/*
 	1. BufferedReader/BufferedWriter 사용해서 파일을 복사해보자.
 	2. PrintWriter를 이용해서 blackpink.txt 파일을 복사해보자
 */
import java.io.*;
public class Test05 {

	public Test05() {
		//기본 스트림 준비 (복사니까 읽고 쓰는 것 두 개)
		FileReader fr = null;
		FileWriter fw = null;
		//보조 스트림 준비 => 반드시 기본 스트림이 있어야 한다.
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		//2. PrintWriter로 복사해보자. => 내부적으로 buffered 있고, 기본 스트림을 알아서 만들어서 연결해서 쓴다. 
		PrintWriter pw = null;
		
		try {
			// 읽는 쪽 스트림 연결
			fr = new FileReader("src/day18/result/blackpink.txt");
			br = new BufferedReader(fr);
			
			/*
			// 쓰는 쪽 스트림 연결
			fw = new FileWriter("src/day18/result/blackpink_01.txt");//없으면 만들 것
			bw = new BufferedWriter(fw);//여기에 데이터 실어주면 fw까지 흘러간다.
			*/
			pw = new PrintWriter("src/day18/result/blackpink_02.txt");
			
			// 문자 배열은 필요 없다. String의 readLine() 사용하면...
			
			// 몇 번 반복해야할 지 모르므로
			while(true) {
				//읽어온다.
				String str = br.readLine();//문자 기반 스트림은 문자열로 읽을 수 있다는 장점이 있다. 바이트 기반보다는 작업이 수월
				
				//읽은 데이터가 없는 경우?
				if(str == null) {
					break;
				}
				
				/*
				//읽은 데이터가 있는 경우?
				bw.write(str + "\r\n");//읽어올 때 줄바꿈 기호를 버렸기 때문에 쓸 때는 따로 추가해줘야 한다.
				
				//버퍼가 다 차지 않은 경우 강제로 비워준다.
				bw.flush();
				*/
				pw.println(str);
				pw.flush();//오토플러쉬가 있지만 혹시 모르니까 적어준다.
			}
			
			System.out.println("*** 복사 성공 ***");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
				br.close();
				fr.close();
			} catch(Exception e) {}
		}
		
	}

	public static void main(String[] args) {	
		new Test05();
	}

}
