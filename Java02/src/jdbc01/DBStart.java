package jdbc01;

import java.sql.Connection;

public class DBStart {
	
	// ** 전역변수 정의
	
	private static Connection cn = DBConnection.getConnection();
	
	public static void main(String[] args) {
		// 1. Connection 확인 
		
		System.out.println("** Connection 확인 => " + cn);
		
		
		
		
	}//main

}//class 
