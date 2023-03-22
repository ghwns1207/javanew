package j03_Exception;

//** 예외생성
//=> throw : 예외(Exception) 생성하기
//=> throws: 예외(Exception) 전달하기 (떠넘기기)

//=> extends Exception => Checked Exception 
//=> extends RuntimeException => UnChecked 예외 (예외처리를 강제하지 않음)

public class Ex07_throw {

	public static void main(String[] args) {
		// 1) Exception 생성하기  
		// throw new Exception() ;
		// => 컴파일 오류  -> Checked Exception 속성을 가지고 있음
		// => 반드시 try ~ 블럭에서 생성
		// throw new Exception("** throw new Exception **");
		
//		try {
//			//throw new ClassNotFoundException("** throw new ClassNotFoundException **");
//			throw new Exception("** throw new Exception **");
//		} catch (Exception e) {
//			System.out.println("** Exception => "+e.toString());
//		}
		
		// 2) unChecked Exception Test
		// => 컴파일러가 예외처리(try~catch) 를 확인하지 않음
		//throw new RuntimeException() ; 
		// => 무조건  RuntimeException 발생으로 비정상종료 
		
		// 3) MyException
		// => 특정상황에 대해 Exception 으로 정의할 수 있음 
		// => 인스턴스를 정의 할 수 있고, 일회적으로 사용한다면 인스턴스 정의 없이 가능	
		try {
			//Exception myE = new Exception("** 의도적 MyExcception **");
			//throw myE;
			throw new Exception("** 의도적 MyExcception **");
		}catch (Exception e) {
			System.out.println("** Exception => "+e.toString());
		}
		
		System.out.println("** Program 정상종료 **");
	} //main

} //class
