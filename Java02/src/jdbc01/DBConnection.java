package jdbc01;

import java.sql.Connection;			//인터페이스
import java.sql.DriverManager;		//클래스 

//** DB 연결
//=> Connection 객체가 DB 연결및 연결정보를 관리함
//즉, Connection 객체를 생성해야함

//** Connection 객체 생성
//=> 일반적인 생성문 
// 	Connection cn = new Connection_구현클래스() -> XXX
//=> DB 연결정보를이용해서 생성후 그 생성값을 전달받음

public class DBConnection {

	public static  Connection  getConnection() {
		
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");		//Class = class들을 관리하는 클래스
	         // forName() -> 클래스 찾는 메서드 
	         			// 규칙 // 내피시 : 포트 번호 / 사용 디비 ? 옵션 설정 ~~~ 
	         String url="jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	            // => allowPublicKeyRetrieval=true : local DB open 하지 않아도 connection 허용 false는 디비를 누군가 오픈 해야됨 
	         	// => localhost 내 컴퓨터 -> ip address @127.0.0.1
	         System.out.println("===> JDBC Connection 성공  ===");
	           return DriverManager.getConnection(url,"root","mysql");
	      } catch (Exception e) {
	         System.out.println("*** JDBC Connection Exception => "+e.toString());
	         return null;
	      }
		
	}//getConnection
	
	
	
}//class 
