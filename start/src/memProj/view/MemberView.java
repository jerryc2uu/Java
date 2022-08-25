package memProj.view;

import java.util.*;

import memProj.dao.MemberDao;
import memProj.vo.MemberVO;

public class MemberView {
	private MemberDao mDao;
	public MemberView() {
		mDao = new MemberDao();
	}
	
	//회원 번호 입력받는 함수
	public int getMno(Scanner sc) {
		int mno = 0;
		ArrayList<Integer> mnoList = mDao.getMnoList();
		while(true) {
			System.out.println("회원번호를 입력하세요! 이전 단계는 -1을 입력하세요.\n회원번호 : ");
			String sno = sc.nextLine();
			System.out.println();
			try {
				mno = Integer.parseInt(sno);
				
				if(mno != -1 && !mnoList.contains(mno)) {
					System.out.println("# 없는 회원입니다. 다시 입력하세요.\n");
					continue;
				}
			} catch(Exception e) {
				System.out.println("# 잘못된 입력입니다.\n");
				continue;
			}
			break;
		}
		return mno;
	}
	
	//회원 번호 입력받아서 회원 정보 출력하는 함수
	public void mnoInfoPrint(Scanner sc) {
		while(true) {
			int mno = getMno(sc);
			
			if(mno == -1 ) {
				break;
			}
			
			MemberVO mvo = mDao.getMnoInfo(mno);
			
			System.out.println("*** " + mno + "번 회원의 정보 조회 ***");
			System.out.printf(
					"회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n성별 : %1s\n가입일 : %18s",
					+mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(), mvo.getTel(), mvo.getAno(),
					mvo.getGen(), mvo.getSdate());
			System.out.println();
		}
	}
	
	//회원 아이디 입력받는 함수
	public String getId(Scanner sc) {
		String id = null;
		ArrayList<String> idList = mDao.getIdList();
		while(true) {
			System.out.println("회원 아이디를 입력하세요! 이전 단계는 -1을 입력하세요.\n회원 아이디 : ");
			id =sc.nextLine();
			System.out.println();
			
			try {
				
				if(!id.equals("-1") && !idList.contains(id)) {
					continue;
				} 
			} catch(Exception e) {
				System.out.println("# 잘못된 입력입니다.\n");
				continue;
			}
			
			break;
		}
		return id;
	}
	
	//회원 아이디 입력받아서 정보 출력하는 함수
	public void idInfoPrint(Scanner sc) {
		while(true) {
			String id = getId(sc);
			
			if(id.equals("-1")) {
				break;
			}
			
			MemberVO mvo = mDao.getIdInfo(id);
			System.out.println("*** " + " 회원의 정보 조회 ***");
			System.out.println("");
			System.out.printf(
					"회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n성별 : %1s\n가입일 : %18s",
					+mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(), mvo.getTel(), mvo.getAno(),
					mvo.getGen(), mvo.getSdate());
			System.out.println();
		}
	}
	
	//아바타 리스트 출력하는 함수
	public void anoPrint() {
		ArrayList<Integer> list = mDao.getAnoList();
		for(int mno : list) {
			System.out.println(mno + " ");
		}
		System.out.println();
		System.out.println();		
	}
	
	//아바타 입력 받기 전담함수
	public int getAno(Scanner sc) {
		int ano = 0;
		ArrayList<Integer> anoList = mDao.getAnoList();
		while(true) {
			anoPrint();
			System.out.println("조회할 아바타를 입력하세요! 이전 단계는 -1을 입력하세요.\n아바타 : ");
			String sno = sc.nextLine();
			System.out.println();
			try {
				ano = Integer.parseInt(sno);
				
				if(ano != -1 && !anoList.contains(ano)) {
					System.out.println("# 없는 아바타 입니다. 다시 입력하세요!\n");
					continue;
				}
			} catch(Exception e) {
				System.out.println("# 잘못된 입력입니다.\n");
				continue;
			}
			break;
		}
		return ano;
	}
	
	//아바타 입력해서 회원들 정보 조회하는 함수
	public void anoInfoPrint(Scanner sc) {
		while(true) {
			int ano = getAno(sc);
			
			if(ano == -1) {
				break;
			}
			
			ArrayList<MemberVO> list = mDao.getAnoInfo(ano);
			
			if(list.size() == 0) {
				System.out.println("*** 해당 아바타를 가진 회원이 없습니다. ***\n");
				continue;
			}
			System.out.println("*** " + ano + " 아바타 가진 회원들 정보 조회 ***");
			for(MemberVO mvo : list) {
				System.out.printf(
						"회원번호 : %4d\n회원이름 : %3s\n아이디 : %7s\n비번 : %5s\n메일 : %15s\n전번 : %11s\n아바타 : %2d\n성별 : %1s\n가입일 : %18s\n",
						+mvo.getMno(), mvo.getName(), mvo.getId(), mvo.getPw(), mvo.getMail(), mvo.getTel(), mvo.getAno(),
						mvo.getGen(), mvo.getSdate());
				System.out.println();
			}
			System.out.println();
			
		}
	}
}
