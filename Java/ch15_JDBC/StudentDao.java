package com.lect.ex3Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDao {
	private static StudentDao INSTANCE = null; 
	public static int SUCCESS =1;
	public static int FAIL =0;
	
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	
	public static StudentDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new StudentDao(); 
		}
		return INSTANCE; 
	}
	
	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1.학과명 리스트 출력 -> 콤보박스에 입력
	public Vector<String> getMNamelist(){
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String MNameQuery = "SELECT mNAME FROM MAJOR";
		Vector<String> mList = new Vector<String>(); 
		mList.add("");
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(MNameQuery); 
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				mList.add(rs.getString("mNAME")); 
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return mList;
		
	}
	// 2. 학번으로 학생 정보 검색
	public ArrayList<StudentDto> sNogetStudent(String sNo) {
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String searchBysNo = "SELECT sNO,sName,mName,score FROM STUDENT S, MAJOR M WHERE S.mNo = M.mNo AND sNO = ?";
		ArrayList<StudentDto> sList = new ArrayList<StudentDto>(); 
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(searchBysNo); 
			pstmt.setString(1, sNo);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				String sNAME = rs.getString("SNAME"); 
				String mName = rs.getString("MNAME"); 
				int score = rs.getInt("SCORE"); 
				sList.add(new StudentDto(sNo,sNAME,mName,score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return sList; 
		
	}
	// 3. 전공으로 학생 정보 검색
	public ArrayList<StudentDto> mNamegetStudent(int mNo){
		ArrayList<StudentDto> sList = new ArrayList<StudentDto>(); 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String searchByMajor = "SELECT ROWNUM \"RANK\", sName||'('||sNO||')' \"sName\", SCORE\r\n" + 
				"    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND S.mNo = ? ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(searchByMajor); 
			pstmt.setInt(1, mNo);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				int rank = rs.getInt("RANK");
				String sName = rs.getString("sName");
				int score = rs.getInt("SCORE"); 
				sList.add(new StudentDto(rank,sName,score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return sList; 
	}
	// 4. 학생 입력
	public int insertStudent(StudentDto dto) {
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		String inputStudent = "INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(STUDENT_SEQUENCE_sNO.NEXTVAL,'000')), ?,?,0,?)";
		int result = StudentDao.FAIL;
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(inputStudent); 
			pstmt.setString(1, dto.getsName());
			pstmt.setInt(2, dto.getScore());
			pstmt.setInt(3, dto.getmNo());
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 5-1. 학생 정보 수정 
	public int updateStudent(StudentDto dto) {
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		String updateStudent = "UPDATE STUDENT SET sNAME = ?,SCORE = ?,mNo=? WHERE sNo=?";
		int result = StudentDao.FAIL;
		
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(updateStudent); 
			pstmt.setString(1, dto.getsName());
			pstmt.setInt(2, dto.getScore());
			pstmt.setInt(3, dto.getmNo());
			pstmt.setString(4, dto.getsNo());
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 6. 학생 출력 
	public ArrayList<StudentDto> getStudents(){
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String searchAll = "SELECT ROWNUM \"RANK\",sNAME||'('||sNO||')' \"sNAME\",mNAME||'('||mNO||')' \"mNAME\",SCORE \r\n" + 
				"    FROM (SELECT S.*,M.mNAME FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO ORDER BY SCORE DESC)";
		ArrayList<StudentDto> sList = new ArrayList<StudentDto>(); 
		
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(searchAll); 
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				int rank = rs.getInt("RANK");
				String sName = rs.getString("sNAME"); 
				String mName = rs.getString("mNAME"); 
				int score = rs.getInt("SCORE"); 
				StudentDto student = new StudentDto(rank,sName,mName,score);
				sList.add(student);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return sList;
		
	}
	// 7. 제적자 출력 
	public ArrayList<StudentDto> getStudentsExpel(){
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String searchExpel = "SELECT ROWNUM \"RANK\",sNAME||'('||sNO||')' \"sNAME\",mNAME||'('||mNO||')' \"mNAME\",SCORE \r\n" + 
				"    FROM (SELECT S.*,M.mNAME FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND sEXPEL = 1 ORDER BY SCORE)";
		ArrayList<StudentDto> sList = new ArrayList<StudentDto>(); 
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(searchExpel); 
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				int rank = rs.getInt("RANK");
				String sName = rs.getString("sNAME"); 
				String mName = rs.getString("mNAME"); 
				int score = rs.getInt("SCORE"); 
				StudentDto student = new StudentDto(rank,sName,mName,score);
				sList.add(student);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return sList;
	}
	//8.제적 처리 하기 
	public int sNoExpel(String sNo) {
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		String expelStudent = "UPDATE STUDENT SET sEXPEL = 1 WHERE sNO = ?";
		int result = StudentDao.FAIL;
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(expelStudent); 
			pstmt.setString(1, sNo);
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		
	}
	// 9. 이름으로 학생 정보 찾기 
	public ArrayList<StudentDto> sNamegetInfo(String sName){
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		String searchBysNo = "SELECT sNO,sNAME, SCORE, mNAME FROM STUDENT S, MAJOR M WHERE S.mNo = M.mNo AND sNAME = ?";
		ArrayList<StudentDto> sList = new ArrayList<StudentDto>(); 
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(searchBysNo); 
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				String sNo = rs.getString("sNO");
				String sNAME = rs.getString("SNAME"); 
				int score = rs.getInt("SCORE");
				String mName = rs.getString("mNAME");
				  
				sList.add(new StudentDto(sNo,sNAME,mName,score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
		return sList;
	}	
}
