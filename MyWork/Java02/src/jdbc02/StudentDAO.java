package jdbc02;

import java.sql.*;
import java.util.*;

import jdbc01.DBConnection;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// Create(Insert), Read(SelectList, SelectOne), Update, Detete


// => 첫번쩨 예제 DBStart 와 DAO 와 다른점 
// 요청 처리 결과를 제공 
// 그러므로 특히 select 결과를 전달하기 위해 담는 작업 필요 ,패킹
public class StudentDAO {		//데이타 억세스 오브젝트 
	
	// ** 전역변수 정의 
	private static Connection cn = DBConnection.getConnection();
	
	private static Statement st;
	private static PreparedStatement pst;	
	private static ResultSet rs;
	private static String sql;
	
	// ** SelectList
	// => select 처리 결과 인 ResultSet -> 전달 
	//  이를 위한 가장 적합한 객체는 ArrayList 
	// - 배열 : 고정크기 (정의할 떼 크기결정) -> 탈락
	// - ArrayList : 가변크기, 변화가 없는 순차처리에 가장 효율적 -> 합격
	// - LinkedList : 가변크기 ,변화가 많은 순차처리에 효율적 -> 탈락 
	public List<StudentVO> selectList() {
		
		sql = "select * from student";
 		List<StudentVO> list = new ArrayList<>();    // StudentVO 타입, 언제든지 후손타입으로 변경가능하게 
  		try {
			st = cn.createStatement();				//커넥션으로 statement 사용 
			rs = st.executeQuery(sql);
  			
			if(rs.next()) {
				// select 존재 
				// => ROW들를 1건씩 list에 담기  
				// 	- ROW들를 1건 컬럼 단위로 -> StudentVO
				//  - StudentVO -> list에 
				do {
					StudentVO vo = new StudentVO();			// 새로운 vo를 만듬 
					vo.setSno(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setJno(rs.getInt(4));
					vo.setInfo(rs.getString(5));
					vo.setPoint(rs.getDouble(6));
					vo.setBirthday(rs.getString(7));
					vo.setNow(rs.getString(8));
					list.add(vo);
					
				} while (rs.next());
				
			}else {
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			list = null;
		}
 		
 		return list;
 		
	}//selectList
	
	// ** SelectOne
	public StudentVO selectOne(StudentVO vo) {
		
		sql = "select * from student where sno= ? " ;
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSno());
			rs = pst.executeQuery();
			if(rs.next()) {
				// select 성공 (resultSet -> vo 에 담아서 return)
				vo.setSno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setJno(rs.getInt(4));
				vo.setInfo(rs.getString(5));
				vo.setPoint(rs.getDouble(6));
				vo.setBirthday(rs.getString(7));
				vo.setNow(rs.getString(8));	
				return vo;
			}else {
				// select 결과 없음
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("** SelectOne Exception => " + e.toString());
			return null;
		}
	}
	
	// ** Insert
	
	   // => CURRENT_TIMESTAMP
	   //   - MySql에서 현재날짜시간을 DATETIME 타입으로 제공
	   //   - SQL 표준이며, 함수 아님.
	public int insert(StudentVO vo) {
		sql = "insert into student values(?,?,?,?,?,?,?,Current_Time)";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSno());
			pst.setString(2, vo.getName());
			pst.setInt(3, vo.getAge());
			pst.setInt(4, vo.getJno());
			pst.setString(5, vo.getInfo());
			pst.setDouble(6, vo.getPoint());
			pst.setString(7, vo.getBirthday());	
			return pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}
	
	
	// ** Update
	// => name, age 수정 test 
	public int update(StudentVO vo) {
		sql = "update student set name = ? ,age = ? where sno = ?";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getName());
			pst.setInt(2, vo.getAge());
			pst.setInt(3, vo.getSno());
			return pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	}
	
	// ** Detete
	
	public int delete(StudentVO vo) {
		sql = "delete from student where sno = ?";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSno());
			return pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	}
	
}
