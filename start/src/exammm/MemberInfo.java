package exammm;

import java.util.*;

public class MemberInfo {
	
	private MemberDao mDao;
	
	public MemberInfo() {
		mDao = new MemberDao();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회원번호를 입력하세요!\n회원번호 : ");
		String sno = sc.nextLine();
		int mno = Integer.parseInt(sno);
		minfoPrint(mno);
		
	}
	
	//Scanner로 회원번호 입력받아서 회원 정보 출력
	public void minfoPrint(int mno) {
		MemberVO mvo = mDao.getMnoInfo(mno);
		System.out.println("###" + mno + "번 회원 정보 조회 ###");
		System.out.printf("회원아이디 : %7s\n회원이름 : %4s\n회원메일 : %15s", mvo.getId(), mvo.getName(), mvo.getMail());
		System.out.println();
		System.out.println("### 정보 조회 완료 ###");
	}
	
	public static void main(String[] args) {
		new MemberInfo();
	}
}
