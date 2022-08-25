package empProj_pc.view;

import java.util.*;

import empProj_pc.dao.EmpDao;
import empProj_pc.vo.EmpVO;

//리스트 출력 클래스
public class EmpView {

	private EmpDao eDao;
	
	public EmpView() {
		eDao = new EmpDao();
	}
	
	//1. 모든 사원 리스트 출력 함수
	public void allPrint() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		System.out.println("*** 모든 사원 정보 조회");
		for(EmpVO e : list) {
			System.out.printf("|%7d   | %10s | %10s | %22s |\n", e.getEno(), e.getEname(), e.getJob(), e.getSdate());
		}
		System.out.println();
	}
	
	//2. 부서 리스트 출력 함수
	public void deptPrint() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		for(EmpVO e : list) {
			System.out.println(e.getDno() + " - " + e.getDname());
		}
		System.out.println();
	}
	
	//3. 부서번호 입력 받는 함수
	public int getDno(Scanner sc) {
		int dno = 0;
		
		ArrayList<Integer> dnoList = eDao.getDnoList();
		
		while(true) {
			deptPrint();
			System.out.print("부서번호를 입력하세요! 이전 단계는 -1을 입력하세요.\n부서번호 : ");
			String sno = sc.nextLine();
			System.out.println();
			
			try {
				dno = Integer.parseInt(sno);
				
				if(dno != -1 && dnoList.contains(dno)) {
					System.out.println("# 없는 부서입니다. 다시 입력하세요!\n");
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
	
	//4. 부서번호 입력 받아서 부서원 정보 출력
	public void dnoInfoPrint(Scanner sc) {
		while(true) {
			int dno = getDno(sc);
			
			if(dno == -1) {
				break;
			}
			
			ArrayList<EmpVO> list = eDao.getDnoInfo(dno);
			
			if(list.size() == 0) {
				System.out.println("*** 부서원이 없는 부서번호 입니다.\n");
				continue;
			}
			
			System.out.println("*** " + dno + "번 부서원 정보 조회");
			for(EmpVO evo : list) {
				System.out.printf("|%7d   | %10s | %10s | %22s | %6d |    %2d    | %10s | %8s |\n", 
						evo.getEno(), evo.getEname(), evo.getJob(), evo.getSdate(), 
						evo.getSal(), evo.getDno(), evo.getDname(), evo.getLoc());
			}
			System.out.println();
		}
	}
	
	//5. 모든 직급 리스트 출력
	public ArrayList<String> jobList() {
		ArrayList<String> list = eDao.getAllJob();
		
		for(String job : list) {
			System.out.println(job + " | ");
		}
		System.out.println();
		return list;
	}
	
	//6. 직급 정보 출력 함수
	public void jobInfoPrint(Scanner sc) {
		while(true) {
			ArrayList<String> jobList = jobList();
			System.out.println("조회할 직급을 입력하세요! 이전 단계는 -1을 입력하세요.\n입 력 : ");
			String job = sc.nextLine();
			System.out.println();
			job = job.toUpperCase();
			
			if(job.equals("-1")) {
				break;
			} else if(!jobList.contains(job)) {
				System.out.println("# 없는 직급입니다. 다시 입력하세요!");
				System.out.println();
				continue;
				
			}
			
			ArrayList<EmpVO> list = eDao.getJobInfo(job);
			
			System.out.println("*** " + job + " 직급 정보 조회");
			for(EmpVO evo : list) {
				System.out.printf("|%7d   | %10s | %10s | %22s | %6d |    %2d    | %7s |\n", 
						evo.getEno(), evo.getEname(), evo.getJob(), 
						evo.getSdate(), evo.getSal(), evo.getGrade(), evo.getScomm());
			}
		}
	}
	
}
