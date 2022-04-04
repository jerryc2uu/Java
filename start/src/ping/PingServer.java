package ping;

import java.net.*;
import java.io.*;

public class PingServer {
	ServerSocket server;
	
	public PingServer() {
		try {
			server = new ServerSocket(7777);
			
			while(true) {
				System.out.println("서버 접속 대기");
				//접속 해오는 클라이언트에게 접속 허용
				Socket socket = server.accept();
				String ip = socket.getInetAddress().getHostAddress();//ip 주소 꺼내오기
				System.out.println("### " + ip + " ] 접속 완료!");//누가 접속했는지 볼 수 있음
				
				//데이터 입출력 준비
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				
				//데이터 받고
				byte[] buff = new byte[10240];
				int len = in.read(buff);
				//문자열 변환
				String msg = new String(buff, 0, len);
				//출력
				System.out.println(ip + " : " + msg);
				
				//응답 메세지
				//데이터 만들고
				String remsg = msg +  " - server";
				//서버 메세지 전송
				byte[] buff1 = remsg.getBytes();//문자열을 바이트배열로 바꿔주는 함수
				out.write(buff1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
