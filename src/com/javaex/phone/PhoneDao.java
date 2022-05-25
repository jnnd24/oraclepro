package com.javaex.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {
	
	//필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	//생성자
	
	
	//gs
	
	
	//메소드
	
	// -- DB연결 메소드 --
	private void getConnection() {
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);
		    // 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, "phonedb", "phonedb");
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		
	}
	
	// -- 자원정리 메소드 --
	private void close(){
		 try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }
	}
	
	
	// -- select 메소드 --
	public void selectPhone() {
		//리스트만들기
		//List<PhoneVo> phoneList = new ArrayList<PhoneVo>();
		
		getConnection();
		try {
			//SQL문 준비
			String query = "";
			query += " select  person_id ";
			query += "         ,name ";
			query += "         ,hp ";
			query += "         ,company ";
			query += " from person ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			//실행결과
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int pId = rs.getInt("person_id");
				String pName = rs.getString("name");
				String pHp = rs.getString("hp");
				String pCom = rs.getString("company");
				System.out.println(pId + "\t" + pName + "\t" + pHp + "\t" + pCom);
			}
			
			
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		
	}
	
	
	
	// -- insert 메소드 --
	public int insertPhone(PhoneVo phoneVo) {
		getConnection();
		int count = 0;
		
		try {
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "";
		    query += " insert into person ";
		    query += " values (seq_person_id.nextval, ?, ?, ?) ";
		    
		    pstmt = conn.prepareStatement(query);
		    pstmt.setString(1, phoneVo.getName());
		    pstmt.setString(2, phoneVo.getHp());
		    pstmt.setString(3, phoneVo.getCompany());
			

		    count = pstmt.executeUpdate();
		    
		    // 4.결과처리
		    System.out.println("[" + count + "건 등록되었습니다.]");
	
		}  catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		close();
		return count;
	}
	
	
	// -- update 메소드 --
	//미완성
	public int updatePhone(PhoneVo phoneVo) {
		getConnection();
		int count = 0;
		
		try {
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "";
		    query += " update person ";
		    query += " set hp = ?, company = ? ";
		    query += " where person_id = ? ";
		    
		    pstmt = conn.prepareStatement(query);
		    pstmt.setString(1, phoneVo.getHp());
		    pstmt.setString(2, phoneVo.getCompany());
		    pstmt.setInt(3, phoneVo.getPersonId());
			

		    count = pstmt.executeUpdate();
		    
		    // 4.결과처리
		    System.out.println("[" + count + "건 수정되었습니다.]");
	
		}  catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		close();
		return count;
	}
	
	
	
	

}
