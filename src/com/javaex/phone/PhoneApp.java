package com.javaex.phone;

import java.util.Scanner;


public class PhoneApp {

	public static void main(String[] args) {
		
		
		//시작화면
		System.out.println("*****************************************");
		System.out.println("*            전화번호 관리 프로그램           *");
		System.out.println("*****************************************");
		System.out.println();
		System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
		System.out.println("-----------------------------------------");
		
		

		PhoneDao phoneDao = new PhoneDao();
		
		
		
		Scanner sc = new Scanner(System.in);
		while(true){
			//메뉴
			System.out.print("메뉴번호: ");
			String sel = sc.nextLine(); 
		
			switch(sel) {
			case "1":
				//1.리스트
				phoneDao.selectPhone();
				break;
			
			case "2":
				//2.등록
				//PhoneVo pVo = new PhoneVo();
				
				System.out.println("<2.등록>");

				System.out.print("이름 > ");
				String intName = sc.nextLine();
				//phoneVo.setName(intName);
				
				System.out.print("휴대전화 > ");
				String intHp = sc.nextLine();
				//phoneVo.setHp(intHp);

				System.out.print("회사번호 > ");
				String intCom = sc.nextLine();
				//phoneVo.setCompany(intCom);

				PhoneVo pVo = new PhoneVo(intName, intHp, intCom);
				phoneDao.insertPhone(pVo);

				break;
				
			case "3":
				//3.수정
				System.out.println("<3.수정>");
				/******************************/
				/******************************/
				/******************************/
				/******************************/
				/******************************/
				break;
				
			case "4":
				//4.삭제
				/******************************/
				/******************************/
				/******************************/
				/******************************/
				/******************************/
				break;

			case "5":
				//5.검색
				/******************************/
				/******************************/
				/******************************/
				/******************************/
				/******************************/
				break;

			case "6":
				//6.종료
				System.out.println("********************************");
				System.out.println("*            감사합니다           *");
				System.out.println("********************************");
				break;//스위치 탈출해서 아래 if문으로 이동함
				
			default: 	//없는 메뉴
				System.out.println("[다시 입력해 주세요.]");
				break;
				
			}  //switch
			if (sel.equals("6")) { // 6 입력 시 while문까지 탈출
				break;
			}
		}   //while	
		sc.close();
		
		
		
		
		
		
	}

}
