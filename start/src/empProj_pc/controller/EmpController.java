package empProj_pc.controller;

import java.util.*;

import empProj_pc.view.EmpView;

public class EmpController {
	
	private EmpView view;
	
	public EmpController() {
		view = new EmpView();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("사원 번호로 조회 : eno\n부서번호로 조회 : dno\n직급으로 조회 : job\n모든 사원 조회 : all\n프로그램 종료 : exit\n명령 입력 : ");
			String str = sc.nextLine();
			System.out.println();
			
			switch(str) {
			case "dno":
				view.dnoInfoPrint(sc);
				break;
			case "job":
				view.jobInfoPrint(sc);
				break;
			case "all":
				view.allPrint();
				break;
			case "exit":
				sc.close();
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		
		}
	}
	
	public static void main(String[] args) {
		new EmpController();
	}

}
