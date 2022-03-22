package day17;
/*
 	이미지 파일을 복사해보자
 	: 문자가 아니므로 byte 단위로 처리해야 한다.
 */
import java.io.*;
public class Test03 {

	public Test03() {
		// 스트림은 단방향, 복사라는 작업은 한 곳에서 읽어서 다른 곳에 읽은 내용을 그대로 쓰는 작업
		// 따라서 스트림이 2개 필요하다.
		
		//1. 스트림 2개 준비
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		try {
			//스트림을 만들고
			fin = new FileInputStream("src/day17/Juyeon.jpg");
			fout = new FileOutputStream("src/day17/result/Juyeon_copy.jpg");
			
			//한 쪽에서 읽어서 그대로 다른 곳에 쓴다.
			// 몇 번 읽어야 할 지 모르므로
			while(true) {
				byte[] buff = new byte[1024];
				int len = fin.read(buff);
				if(len == -1) {
					//더 이상 읽은 데이터 없는 경우이므로
					break;
				}
				fout.write(buff, 0, len);
			}
			
			//메세지 출력
			System.out.println("***파일 복사 성공***");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fout.close();
				fin.close();
			} catch(Exception e) {}
		}
		
	}

	public static void main(String[] args) {
		new Test03();
	}	

}
