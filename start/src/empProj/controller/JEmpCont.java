package empProj.controller;

import empProj.dao.*;
import empProj.vo.*;
import java.util.*;

public class JEmpCont {

	private JEmpDao jDao;
	
	public JEmpCont() {
		
		jDao = new JEmpDao();
		//JEMP 테이블이 없으면 만들고 이미 있으면 건너뛰도록 하자
		int cnt = jDao.tabCnt();
		
		if(cnt == 0) {
			addTable();
		} else if(cnt == 1) {
			System.out.println("*** 이미 테이블이 준비되어 있습니다. ***");
		}
		
		delD30();
	}
	/*
	 	테이블의 데이터 삭제는 트리거가 하는 것이 원칙
	 		트리거 : update, insert, delete 실행 전 자동으로 작동
	 	여기서는 질의명령으로 수동 처리하자
	 	
	 	순서
	 		삭제 명령의 경우
	 			데이터를 백업 테이블에 백업 후 해당 테이블에서 삭제한다.
	 			데이터베이스 작업이 두 번 실행되어야 하고 결과적으로 질의명령이 두 개 작성되어야 한다.
	 			
	 			여기선 임의로 jemp 테이블의 30번 부서 사원들을 삭제해보자
	 			
	 */
	public void delD30() {
		//먼저 백업하고
		int cnt = jDao.backupDno30();
		//결과 출력
		System.out.println("30번 부서원 " + cnt + " 명의 데이터를 백업했습니다.");
		
		//삭제
		int result = jDao.delDno30();
		System.out.println("30번 부서원 " + result + " 명의 데이터를 사원 테이블에서 삭제했습니다.");
		
		if(cnt == result) {
			//백업하고 삭제가 동일하므로 작업 성공
			System.out.println("퇴사 처리가 정상적으로 완료되었습니다.");
		} else {
			System.out.println("처리 작업에 문제가 있습니다. 귀여운 댕댕이 이제리에게 문의하세요.");
		}
	}
	
	//제니 데이터 입력 전용 함수
	public void addJennie() {
		//제니 데이터 추가. 이름, 직급, 부서번호
		String name = "JENNIE";
		String job = "MANAGER";
		int dno = 40;
		
		//vo 만들고
		EmpVO eVO = new EmpVO();
		//데이터 채우고
		eVO.setEname(name);
		eVO.setJob(job);
		eVO.setDno(dno);
		
		//데이터 베이스 작업 함수 호출
		int result = jDao.insertJEMP(eVO);
		if(result == 1) {
			System.out.println("***" + name + "사원의 데이터 입력 성공했습니다.");
		} else {
			System.out.println("###" + name + "사원 추가에 실패했습니다.");
		}
	}
	
	//추가된 사원의 정보를 조회해서 출력하는 함수
	public void printLast() {
		//데이터 받고
		EmpVO evo = jDao.getLast();//함수 실행 종료되면 사라지는 변수
		System.out.println("=================================");
		System.out.println("*** 마지막 입사한 사원 정보 ***");
		System.out.printf("사원번호 : %4d\n사원이름 : %-10s\n사원직급 : %-10s\n입 사 일 : %18s\n부서번호 : %2d", 
				evo.getEno(), evo.getEname(), evo.getJob(), evo.getSdate(), evo.getDno());
		
	}
	
	//emp 테이블 복사해서 jemp 테이블 만들기
	public void addTable() {
		//할일
		//dao의 함수만 호출해주면 된다.
		jDao.addJEmp();
	}
	
	public static void main(String[] args) {
		new JEmpCont();
	}

}
