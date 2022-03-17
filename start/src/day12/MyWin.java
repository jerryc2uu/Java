package day12;
/*
   무명 내부 클래스 예시

 */
import java.awt.event.*;

import java.awt.*;
import javax.swing.*;

public class MyWin {	
	JFrame fr;
	JButton btn1, btn2;
	JPanel mainP, bPan;
	
	
	public MyWin() {
		fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainP = new JPanel();
		mainP.setPreferredSize(new Dimension(280, 450));
		mainP.setBackground(Color.BLUE);
		
		bPan = new JPanel();
		bPan.setLayout(new GridLayout(1, 2));
		
		btn1 = new JButton("닫기");
		btn2 = new JButton("변경");
		
		
	
		//닫기 이벤트 추가
		btn1.addActionListener(new ActionListener() {
			//이 클래스는 무명 내부 클래스
			//오버라이드 하는 함수의 내용이 극도로 짧아서 별도 클래스 제작하는 것이 번거로움
			//구현하는 순간 new 시켜서 그 인스턴스를 사용함
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
				
			
			
		bPan.add(btn1);
		bPan.add(btn2);
		
		fr.add(mainP, BorderLayout.CENTER);
		fr.add(bPan, BorderLayout.SOUTH);
		
		fr.setVisible(true);
		fr.setSize(300, 500);
		fr.setResizable(false);
	}
	
	
	public static void main(String[] args) {
		new MyWin();

	}
	
	class MyEvt implements ActionListener {
		//전역 내부 클래스
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}

}
