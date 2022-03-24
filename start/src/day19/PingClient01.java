package day19;
/*
  	서버에 접속한 후 특정 데이터를 서버에 보내면 
  	서버가 다시 응답하는 데이터를 받아 출력하는 프로그램을 만들어보자 
 */
import java.io.*;
import java.net.*;

public class PingClient01 {

	public PingClient01() {
		/*
		 	상대방과 통신하기 위해선 통신 도구가 필요
		 	이 통신 도구(전화기)의 역할을 하는 게 Socket 클래스
		 */
		
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
				
		try {
			// Socket 객체를 만들면 자동적으로 상대방과 접속이 이루어진다.
			socket = new Socket("172.30.1.50", 7777);
			
			/*
			 	포트번호는 접속받는 프로그램에서 지정한 번호여야 한다.
			 	 이제 접속이 되었으므로 상대방과 통신하면 된다.
			 	 
			 	 통신 방법
			 	 	1. 기본 스트림을 꺼내서 내보낸다
			 	 	 	getInputStream(); getOutputStream();
			 */
			
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			// 스트림이 준비됐으니 데이터를 서버에 전달해보자
			String msg = "머선 129";
			// 바이트 배열로 변환
			byte[] buff = msg.getBytes();
			// 이것을 서버에 보낸다.
			out.write(buff);
			// 메세지를 보내면 서버가 응답 메세지를 보내준다.
			// 응답 메세지를 받아서 출력해보자.
			buff = new byte[1024];
			int len = in.read(buff);
			//읽은 데이터를 문자열로 변환
			msg = new String(buff, 0, len);
			
			//메세지 출력
			System.out.println("서버가 보내준 메세지 : "  + msg);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch(Exception e) {}
		}
		 	
	}

	public static void main(String[] args) {
		new PingClient01();
	}

}
