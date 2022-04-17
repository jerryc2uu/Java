package githrd.controller;

import java.util.*;

import githrd.dao.MemberDao;
import githrd.vo.MemberVO;

public class MemberController {

	private MemberDao mDao;
	
	public MemberController() {
		mDao = new MemberDao();

		/*//1. 회원번호와 id 조회
		ArrayList<MemberVO> list = mDao.getMnoid();
		mnoidPrint(list);
		System.out.println();

		//2. 회원번호 입력하면 해당 회원의 정보 출력
		System.out.println("=================================");
		System.out.print("회원번호를 입력하세요!");
		
		Scanner no = new Scanner(System.in);
		int mno = no.nextInt();
		minfoPrint(mno);
		
		//3. 아이디 입력하면 해당 회원의 전화번호 수정해서 출력
		System.out.println("==================================");
		System.out.println("아이디를 입력하세요!");
		
		Scanner str = new Scanner(System.in);
		String id = str.nextLine();
		uptelPrint(id);
	*/
		//4. Scanner로 회원 정보 입력받아서 회원 가입 후 출력
		System.out.println("==================================");
		System.out.println("정보를 입력하세요!!");
		
		addMember();
	}
	
	//1. 회원번호와 id 조회해서 출력해주는 함수
	public void mnoidPrint(ArrayList<MemberVO> list) {
		System.out.println("### 회원번호와 id 조회 ###");
		for(MemberVO m : list) {
			System.out.printf("%4d - %7s", m.getMno(), m.getId());
			System.out.println();
		}
	}
	
	//2. 회원번호(1001) 입력하면 해당 회원의 정보 출력해주는 함수
	public void minfoPrint(int mno) {
		
		/* int mno = sc.nextInt(); */
		MemberVO mvo = mDao.getMinfo(mno);
		System.out.println("### " + mno + "번 회원의 정보 조회 ###");
		System.out.printf("회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n성별 : %1s\n가입일 : %18s",
				+ mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(), mvo.getTel(), mvo.getAno(), mvo.getGen(), mvo.getSdate());
		System.out.println();
	}
	
	//3. 아이디 입력하면 해당 회원의 전화번호 수정해서 출력해주는 함수
	public void	uptelPrint(String id) {
		
		System.out.println("### 전화번호 수정 ###");
		int result = mDao.upTEL(id);
		
		if(result == 1) {
			System.out.println("***" + id + "사원의 전화번호 수정에 성공했습니다 ***");
		} else {
			System.out.println("###" + id + "사원의 전화번호 수정에 실패했습니다. 댕댕이 이제리에게 문의하세요!");
		}
		
	}
	
	//4. Scanner로 회원 정보 입력받아서 회원 가입 처리 후 출력해주는 함수
	public void addMember() {
		System.out.println("### 회원가입 진행 ###");

		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비번 : ");
		String pw = sc.nextLine();
		System.out.print("메일 : ");
		String mail = sc.nextLine();
		System.out.print("전번 : ");
		String tel = sc.nextLine();
		System.out.print("아바타 : ");
		int ano = sc.nextInt();
		//System.out.print("성별 : ");
		//String gen = sc.nextLine();
		
		MemberVO mvo = new MemberVO();
		
		mvo.setName(name);
		mvo.setId(id);
		mvo.setPw(pw);
		mvo.setMail(mail);
		mvo.setTel(tel);
		mvo.setAno(ano);
		//mvo.setGen(gen);
		
		int result = mDao.inJOIN(mvo);
		
		if(result == 1) {
			System.out.println("***" + name + "사원의 회원가입이 완료되었습니다! ***");
			System.out.printf("회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n가입일 : %18s",
							mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(), mvo.getTel(), mvo.getAno(), mvo.getSdate());
		} else {
			System.out.println("### 회원가입에 실패했습니다. 귀염둥이 이제리에게 문의하세요! ###");
		}
		
	}
	
	public void injoinPrint() {
		
		
	}
	
	public static void main(String[] args) {
		new MemberController();
	}

}
