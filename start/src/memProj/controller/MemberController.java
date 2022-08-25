package memProj.controller;

import java.util.Scanner;

import memProj.view.*;

public class MemberController {
	
	private MemberView view;
	
	public MemberController() {
		view = new MemberView();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("회원번호로 조회 : mno\n회원 아이디로 조회 : id\n회원 아바타로 조회 : ano\n프로그램 종료 : exit\n명령 입력 : ");
			String str = sc.nextLine();
			System.out.println();
			switch(str) {
			case "mno":
				view.mnoInfoPrint(sc);
				break;
			case "id":
				view.idInfoPrint(sc);
				break;
			case "ano":
				view.anoInfoPrint(sc);
				break;
			case "exit":
				sc.close();
				System.out.println("*** 프로그램을 종료합니다. ***");
				return;
			default:
				System.out.println("# 잘못 입력하셨습니다.\n");
			}
		}
	}

	public static void main(String[] args) {
		new MemberController();
	}

}
