package day19;

/*
 	클라이언트가 접속을 하면 접속을 받고 

 	클라이언트가 준 데이터를 받아보고
 	적당한 내용으로 응답하는 서버를 만들어보자
*/

import java.io.*;
import java.net.*;
public class PingServer01 {
	
	public PingServer01() {
		
		//대표전화(접속만 받는 전화기)를` 만든다
		ServerSocket server = null;
		try {
			server = new ServerSocket(7777);
			//7777번으로 접속을 요청하는 것을 받을 준비를 한다.
			System.out.println("서버 접속 대기 중");
			
			Socket socket = server.accept();
			/*
			  이 함수는 Blocking 함수이다.
			  이 말은 특정한 조건이 만족되지 않으면 실행되지 않는 함수라는 뜻
			  	ex) Scanner는 우리가 키보드에 입력하지 않으면 멈춰있는다.
			  System.in.read();
			  sc.nextLine();
			  	=> Blocking 함수
			  
			  accept()는 누군가 접속을 요청해야만 실행되는 함수
			  이 함수가 실행되었다는 것은 누군가 접속을 요청했다는 뜻
			  이 때 서버에서는 담당자 전화기를 배정해줘야 한다.
			 */
			
			//반환값으로 실제 통신할 전화기를 배정한다.
			System.out.println("서버 접속 완료");
			
			/*
			   여기까지 실행되었다는 것은 누군가 접속했다는 것이 되고
			   그 사람과 통신할 전화기도 배정받은 상태다.
			   이 전화기를 이용해서 상대방과 통신이 가능할 것이고
			   여기서는 자바로 만들기 때문에 스트림 방식으로 통신을 해야 한다.(외부 장치니까)
			 */
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();//바이트 기반 스트림
			
			//통로는 준비해놨으니 먼저 데이터를 받아본다.
			byte[] buff = new byte[1024];
			int len = in.read(buff);
			String msg = new String(buff, 0, len);
			
			//출력
			System.out.println("받은 메세지 : " + msg);
			//적당한 메세지로 응답해준다.
			msg = msg + " : 잘 받았습니다.";
			
			
			//msg를 byte[]로 바꿔준다.
			buff = msg.getBytes();
			
			//스트림에 보낸다.
			out.write(buff);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new PingServer01();
		//핑 : 컴퓨터가 네트워크에 연결돼 있는가 확인하려면 다른 컴퓨터에 핑을 보내서 받아본다.
	}

}
