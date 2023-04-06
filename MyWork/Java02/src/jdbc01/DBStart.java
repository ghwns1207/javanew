package jdbc01;

import java.sql.*;

public class DBStart {

	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection();
	
	private static Statement st;
	private static PreparedStatement pst;	
	private static ResultSet rs;
	private static String sql;
	
	// ** StudentList
	// => MySql Command
	// login -> DB선태 -> sql 구문실행 -> 결과 
	// => JDBC
	// connection 생성 = login -> Statement 객체로 sql 구문실행 -> ResultSet에 실행결과 전달 
	// connection - > use database , statement -> select * from student 입력 , resultSet -> 순차처리 출력문 받아옴 
	public static void selectList() {
		// 1) Connection 생성
		// => 전역변수로 전달받음 
		
		// 2) SQL 구문처리 
		sql = "select * from student";   //세미 콜론 생략 ,sql 구문만 입력 
		try {		//checkedException
			
			st = cn.createStatement();      // Connection 객체로 Statement 생성 
			rs = st.executeQuery(sql);			// 입력 , 삭제는 update, select 는 쿼리
			
			// 3) 결과 처리 
			// => select 결과가 존재하는지 확인 
			// => ResultSet 객체는 이를 위한 메서드 제공 
			// => next() : 다음 data 가 존재하면 true , 현재 data를 제공 
			System.out.println("----------------------------------------------");
			System.out.println("** StudentList **");
			System.out.println("----------------------------------------------");
			if(rs.next()) {
				// select 결과가 존재
				do {
					System.out.print(rs.getInt(1)+ " ");   //인덱스는 1부터 
					System.out.print(rs.getString("name")+ " ");  // 컬럼 네임도 가능 
					System.out.print(rs.getInt("age")+ " ");
					System.out.print(rs.getInt(4)+ " ");
					System.out.print(rs.getString("info")+ " ");
					System.out.print(rs.getDouble("point")+ " ");
					System.out.print(rs.getString(7)+ " ");
					System.out.print(rs.getString(8)+ "\n");
				} while (rs.next());
				
			}else {
				// select 결과가 1건도 없음 
				System.out.println("** SelectList : 출력할 자료 없음 ");
				
			}
			
			
		} catch (Exception e) { 
			// TODO: handle exception 
			System.out.println("** selectList Exception => " + e.toString());
		}
		
	}// selectList
	
	//** jo 별 student list 
	public static void joList(int jno) {
		sql = "select * from student where jno = " + jno ; 
		
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			
			System.out.println("----------------------------------------------");
			System.out.println("** JoList **");
			System.out.println("----------------------------------------------");
			
			if (rs.next()) {
				
				do {
					System.out.print(rs.getInt(1)+ " ");   //인덱스는 1부터  get컬럼타입(인덱스 또는 컬럼이름)
					System.out.print(rs.getString("name")+ " ");  // 컬럼 네임도 가능 
					System.out.print(rs.getInt("age")+ " ");
					System.out.print(rs.getInt(4)+ " ");
					System.out.print(rs.getString("info")+ " ");
					System.out.print(rs.getDouble("point")+ " ");
					System.out.print(rs.getString(7)+ " ");
					System.out.print(rs.getString(8)+ "\n");
				} while (rs.next());
				
			}else {
				System.out.println("** JoList : 출력할 자료 없음 ");
			}
			
		} catch (Exception e) { 
			// TODO: handle exception 
			System.out.println("** joList Exception => " + e.toString());
		}
	}
	
	// ** Student Insert 
	// => 컬럼 8개 모두 매개변수로 전달 받아야됨.
	// sno , name, age, jno, info, poin, birthday, now
	// => 매개변수 : 많고 불편
	// => 그러므로 엔티티(Table)를 객체화함 : ~~VO (Value Object) -> StudentVO
	public static void insert(int sno, String name) {
		
//		sql = "insert into student values(" +sno +"," + name+ ","+... now+ ")";
		// => Statement 객오류의 확률이 매우 높고 불편 
		// => 그러므로 PreparedStatement 객체 사용 
		// => PreparedStatement	: 바인딩변수 ? 제공
		//  "insert into student values( ? , ? , ?, ?, ?, ? ,?, ?)"
		//  ? 해결 : Query 구문 실행전에  
		
		sql = "insert into student values( ?, ?, ?, ?, ?, ? ,?, ?)";
		
		try {
			pst = cn.prepareStatement(sql);	 // ?가 있는 구문 , 생성하면서 sql 매개변수 처리
			pst.setInt(1, sno);				 // (index = 1부터 ? 의 위치 , value), ?를 처리
			pst.setString(2, name);	         // ? 를 모두 처리 

			//SQL 구문 실행 
			// => .executeUpdate() : insert(C), updated(U) , delete(D) 구문 실행시 사용 
			// => 실행결과는 성공적으로 처리된 Row의 갯수를 return int 타입 
//			int count = pst.executeUpdate();       // 성공한 갯수 반환 PreparedStatement는 sql를 이미 처리해서 매개변수로 안 넣어도됨 
				
			if( pst.executeUpdate() > 0) {     // 재활용 떄문이 아니면 그냥 입력 
				// 성공
				
			}else {
				// 실패
				
			}
			
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
		}
	}
	
	
	public static void main(String[] args) {
		// 1. Connection 확인
		System.out.println("** Connection 확인 => " + cn);
		
		// 2.Student List
		selectList();
		
		// 3. jo 별 student list 
		joList(3);

	}// main

}// class
