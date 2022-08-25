package githrd.controller;

import java.util.*;

import githrd.dao.MemberDao;
import githrd.vo.MemberVO;

public class MemberController02 {

	private MemberDao mDao;

	public MemberController02() {
		mDao = new MemberDao();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("회원번호로 조회 : mno\n아이디로 수정 : id\n명령 종료 : exit\n명령 입력 : ");
			String str = sc.nextLine();
			System.out.println();
			
			switch(str) {
			case "mno":
				minfoPrint(sc);
				break;
			case "id":
				uptelPrint(sc);
			case "exit":
				sc.close();
				System.out.println("*** 프로그램 종료 ****");
			default:
				System.out.println("#잘못 입력하셨습니다.");
			}
		}
		/*
		 //1. 회원번호와 id 조회 
		 ArrayList<MemberVO> list = mDao.getMnoid();
		 mnoidPrint(list); System.out.println();
		*/ 
		 //2. 회원번호 입력하면 해당 회원의 정보 출력
		 //minfoPrint(sc);	
		
		 
		 //3. 아이디 입력하면 해당 회원의 전화번호 수정해서 출력
			/* uptelPrint(sc); */
		 /* 
		 //4. Scanner로 회원 정보 입력받아서 회원 가입 후 출력
		 addMember(sc);
		 
		 // 5. 신규 회원 정보 출력
		 newPrint();
		*/
		/*
		 6. 회원리스트를 꺼내오는데 한 페이지 당 3명의 아이디, 메일, 가입일을 리스트 형식으로 보여주고
		  	그 중에서 한 명의 아이디를 입력하면 그 회원의 상세 데이터를 조회
		     한 페이지 당 보여주는 리스트의 갯수는 3개, 한 페이지 당 보여지는 페이지 수는 3개
		  	이전, 다음 페이지를 같이 표현해서 이동 가능한 페이지 메뉴는 총 5개로 하라.
		 	이전 페이지 누르면 현재 보는 페이지가 5페이지라면 3페이지로 이동하고 이동 가능한 페이지는 1~3로 변경
		 	현재 보는 페이지가 1페이지라면 다음 페이지 누르면 보여지는 페이지는 4페이지... 
		 	시작페이지는 4페이지가 되고 종료페이지는 6페이지가 돼야 한다.
		 	
		*/
	}

	// 1. 회원번호와 id 조회해서 출력해주는 함수
	public void mnoidPrint(ArrayList<MemberVO> list) {
		System.out.println("### 회원번호와 id 조회 ###");
		for (MemberVO m : list) {
			System.out.printf("%4d - %7s", m.getMno(), m.getId());
			System.out.println();
		}
	}
	// 회원 번호 입력받기 전담 함수
	public int getMno(Scanner sc) {
		int mno = 0;
		ArrayList<Integer> mnoList = mDao.getMnoList();
	
		while(true) {
			System.out.println("=================================");
			System.out.print("회원번호를 입력하세요!");
			String sno = sc.nextLine();
			try {
				mno = Integer.parseInt(sno); 
				
				if(!mnoList.contains(mno)) {
					System.out.println("# 없는 회원번호입니다. 다시 입력하세요!");
					continue;
				}
			} catch(Exception e) {
				System.out.println("# 잘못된 입력입니다.");
				continue;
			}
			break;
		}
		return mno;
	}

	// 2. 회원번호(1001) 입력하면 해당 회원의 정보 출력해주는 함수
	public void minfoPrint(Scanner sc) {
		
		while(true) {
			int mno = getMno(sc);
			
			MemberVO mvo = mDao.getMinfo(mno);
			
			System.out.println("### " + mno + "번 회원의 정보 조회 ###");
			System.out.printf(
					"회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n성별 : %1s\n가입일 : %18s",
					+mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(), mvo.getTel(), mvo.getAno(),
					mvo.getGen(), mvo.getSdate());
			System.out.println();
			}
	}
	
	// 아이디 입력받기 전담 함수
	public String getId(Scanner sc) {
		String id = null;
		
		ArrayList<String> idList = mDao.getIdList();
		while(true) {
			System.out.println("아이디를 입력하세요!");
			id = sc.nextLine();
			
			try {
				if(!idList.contains(id)) {
					System.out.println("없는 회원 아이디 입니다. 다시 입력하세요..");
					continue;
				}
				
			} catch(Exception e) {
				System.out.println("# 잘못된 입력입니다...");
				continue;
			}
			break;
		}
		return id;
	}
	// 3. 아이디 입력하면 해당 회원의 전화번호 수정해서 출력해주는 함수
	public void uptelPrint(Scanner sc) {
		while(true) {
			String id = getId(sc);
			

			System.out.println("### 전화번호 수정 ###");
			
			int result = mDao.upTEL(id);
	
			if (result == 1) {
				System.out.println("***" + id + "사원의 전화번호 수정에 성공했습니다 ***");
			} else {
				System.out.println("###" + id + "사원의 전화번호 수정에 실패했습니다.\n댕댕이 이제리에게 문의하세요!");
			}

		}
	}

	// 4. Scanner로 회원 정보 입력받아서 회원 가입 처리 후 출력해주는 함수
	public void addMember(Scanner sc) {
		System.out.println("==================================");
		System.out.println("정보를 입력하세요!!");
		 
		System.out.println("### 회원가입 진행 ###");

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
		String sno = sc.nextLine();
		int ano = Integer.parseInt(sno);
		System.out.print("성별 : ");
		String gen = sc.nextLine();
		MemberVO mvo = new MemberVO();

		mvo.setName(name);
		mvo.setId(id);
		mvo.setPw(pw);
		mvo.setMail(mail);
		mvo.setTel(tel);
		mvo.setAno(ano);
		mvo.setGen(gen);
		int result = mDao.inJOIN(mvo);

		if (result == 1) {
			System.out.println("***" + name + " 사원의 회원가입이 완료되었습니다! ***");
			/*
			 * System.out.
			 * printf("회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n가입일 : %18s"
			 * , mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(),
			 * mvo.getTel(), mvo.getAno(), mvo.getSdate());
			 */
		} else {
			System.out.println("### 회원가입에 실패했습니다. 댕댕이 이제리에게 문의하세요! ###");
		}

	}

	public void newPrint() {
		// 데이터 받고
		MemberVO mvo = mDao.getNew();
		System.out.println("=====================");
		System.out.println("*** 신규 회원 정보 ****");
		System.out.printf("회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n가입일 : %18s",
				mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(), mvo.getTel(), mvo.getAno(), mvo.getSdate());

	}

	public static void main(String[] args) {
		new MemberController02();
	}

}
