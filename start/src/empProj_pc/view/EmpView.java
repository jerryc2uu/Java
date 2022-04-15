package empProj_pc.view;

import java.util.*;


import empProj_pc.vo.EmpVO;
import empProj_pc.dao.*;
import empProj_pc.vo.*;

public class EmpView {
	
	private EmpDao eDao;
	
	public EmpView() {
		eDao = new EmpDao();
	}
	
	//모든 사원 리스트 출력
	public void allPrint() {
		ArrayList<EmpVO> list = eDao.getAll();
		
		System.out.println("*** 모든사원 정보조회");
		System.out.println("==================================================================");
		System.out.println("| 사원번호 |  사원이름  |   직  급   |        입   사   일       |");
		System.out.println("------------------------------------------------------------------");
		
		for(EmpVO e : list) {
			System.out.printf("|%7d   | %10s | %10s | %22s |\n", e.getEmpno(), e.getEname(), e.getJob(), e.getSdate());
		}
		System.out.println("==================================================================");
		System.out.println();
	}
	
	//부서 리스트 출력
	public void deptPrint() {
		ArrayList<EmpVO> list = eDao.getDeptList();
		
		for(EmpVO evo : list) {
			System.out.println(evo.getDeptno() + " - " + evo.getDname());
		}
		System.out.println();
	}
	
	//부서번호 입력 받아서 출력
	public int getDno(Scanner sc) {
		int dno = 0;
		ArrayList<Integer> dnoList = eDao.getDnoList();
		while(true) {
			deptPrint();
			System.out.print("부서번호를 입력하세요! 이전단계는 -1 을 입력하세요.\n부서번호 : ");
			String sno = sc.nextLine();
			System.out.println();
			try {
				dno = Integer.parseInt(sno);
				
				if(dno != -1 && !dnoList.contains(dno)) {
					System.out.println("# 없는 부서입니다. 다시입력하세요!\n");
					continue;
				}
			} catch(Exception e) {
				System.out.println("# 잘못된 입력입니다.\n");
				continue;
			}
			
			break;
		}
		
		return dno;
	}
	
	//부서원 정보 출력
	

}
