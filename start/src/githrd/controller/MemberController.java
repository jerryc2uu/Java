package githrd.controller;

import githrd.dao.MemberDao;

public class MemberController {

	private MemberDao mDao;
	
	public MemberController() {
		mDao = new MemberDao();
	}
	
	//회원번호와 id 조회해서 출력해주는 함수
	
	//회원번호(1001) 입력하면 해당 회원의 정보 출력해주는 함수
	
	//아이디 입력하면 해당 회원의 전화번호 수정(0101-1212-1212)해주는 함수
	
	//(어려워여~)Scanner로 회원 정보 입력받아서 회원 가입 처리해주는 함수
	public static void main(String[] args) {
		new MemberController();
	}

}
