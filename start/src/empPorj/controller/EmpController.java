package empPorj.controller;

import java.util.*;
import empPorj.dao.*;
import empPorj.vo.*;

/*
 	사원번호와 사원이름 조회해서 출력해주고 사원번호 입력하면 
 	해당 사원의 사원번호, 이름, 직급, 급여, 입사일을 조회해서 출력해주는 기능을
 	여기에 추가하세요..
 	
 	사원번호로 조회 : eno\n
 */
public class EmpController {
	private EmpDao eDao;
	
	public EmpController() {
		eDao = new EmpDao();

		System.out.println("\t1. 모든 사원들 정보 조회");
		
		ArrayList<EmpVO> list1 = eDao.getAll();
		for(EmpVO e : list1) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("\t2. 20번 부서 사원들 정보 조회");
		
		//20 부서를 입력해서 부서원들의 정보를 조회
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 부서 번호를 입력하세요 : ");
		int dno = sc.nextInt();
		*/
		ArrayList<EmpVO> list2 = eDao.getDnoInfo(20);
		for(EmpVO v : list2) {
			System.out.println(v);
		}
		System.out.println();
		 
		
		//SALESMAN 직급을 가진 사원들의 정보 조회
		System.out.println("\t3. 직급 정보 조회");
		ArrayList<EmpVO> list3 = eDao.getJobInfo("SALESMAN");
		for(EmpVO o : list3) {
			System.out.println(o);
		}
		
	}

	public static void main(String[] args) {
		new EmpController();
	}

}
