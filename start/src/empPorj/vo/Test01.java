package empPorj.vo;

import java.util.*;
public class Test01 {

	public Test01() {
		EmpVO eVO1 = new EmpVO();
		EmpVO eVO2 = new EmpVO();
		EmpVO eVO3 = new EmpVO();
		
		MemberVO mVO1 = new MemberVO();
		MemberVO mVO2 = new MemberVO();
		MemberVO mVO3 = new MemberVO();
		
		ArrayList list1 = new ArrayList();
		
		list1.add(eVO1);
		list1.add(eVO2);
		list1.add(eVO3);
		list1.add(mVO1);
		list1.add(mVO1);
		list1.add(mVO1);
		
		EmpVO e1 = (EmpVO) list1.get(0); //==> object 타입으로 자동 형변환 되어 들어가있기 때문에 그냥은 오류남
		MemberVO m1 = (MemberVO) list1.get(3);
		Object o = list1.get(1);
		
		
		//그래서 제너릭스를 사용해 EmpVO 타입만 채울 수 있는 전용 ArrayList를 만든다..
		ArrayList<EmpVO> list2 = new ArrayList<EmpVO>();
		list2.add(eVO1);
		list2.add(eVO2);
		list2.add(eVO3);
		//list2.add(mVO1); ==> EmpVO 타입만 채울 수 있기 때문에 오류남..
		
		EmpVO ev1 = list2.get(0);
		EmpVO ev2 = list2.get(1);
		
	}
}
