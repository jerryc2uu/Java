package day19;

import java.awt.event.*;
import java.net.*;

public class WriteEvt implements ActionListener {
	MsgWrite main;
	public WriteEvt(MsgWrite main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 어떤 버튼이 눌렸는지 확인
		String str = e.getActionCommand();
		
		if(str.equals("다시작성")) {
			main.area.setText("");
			
		} else if(str.equals("보내기")) {
			sendProc();
		}
		
	}
	
	//쪽지 보내기 전담 처리 함수
	public void sendProc() {
		//보낼 내용을 알아내고
		String msg = main.area.getText();
		//바이트 배열로 반환
		byte[] buff = msg.getBytes();
		
		//상대방 ip 알아내고
		//이름 읽어오고
		String name = main.field.getText();
		String ip = (String) main.main.nameToIp.get(name);
		
		InetAddress inet = null;
		try {
			inet = InetAddress.getByName(ip);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//이것을 패킷으로 포장한다.
		DatagramPacket pack = null;
		try {
			 pack = new DatagramPacket(buff, buff.length, inet, 7777);
			 //이러면 패킷이 만들어졌고 이제 만들어진 패킷을 네트워크에 흘려보내며 된다.
			 
			 main.main.sSocket.send(pack);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//이 작업이 완료되면 전송이 완료됐으므로 현재 작업창을 닫고 메인 창을 띄워준다.
		main.frame.dispose();
		main.main.frame.setVisible(true);
		
	}

}
