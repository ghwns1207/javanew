package j03_Exception;

import java.io.IOException;

//** Checked Exception 처리
// 1) 직접 처리
//	  => 해당 메서드 내에서 try ~ catch 블럭 처리
// 2) 위임 처리
//	  => Exception 처리를 상위 메서드로 위임(떠넘기기)

public class Ex05_IOthrows {
	// 1) 직접 처리
	public static String readString1() {
		byte[] bf = new byte[100] ;
		System.out.println("** 문자열을 입력하세요 1 => ");
		try {
			System.in.read(bf);
			// Checked -> 컴파일 오류 발생 : Unhandled exception type IOException
		} catch (IOException e) {
			System.out.println("** IOException => "+e.toString());
		}
		return new String(bf);
	}//readString1
	
	// 2) 위임 처리 (떠넘기기)
	// => throws IOException
	//    IOException의 처리를 상위의 메서드(현재메서드를 call 한 메서드) 로 떠넘김
	// => throws 하는 Exception 은 모두 Checked 방식으로 처리 해야함
	// => throws 하는 Exception 을 처리하는 구문에서는 Exception 적용범위가 더 넓어야함 
	//    즉, throws Exception -> main 의 catch (IOException e) : 오류
	public static String readString2() throws Exception {
	//public static String readString2() { -> 컴파일 오류 발생
		byte[] bf = new byte[100] ;
		System.out.println("** 문자열을 입력하세요 2 => ");
		System.in.read(bf);
		// Checked -> 컴파일 오류 발생 : Unhandled exception type IOException
		return new String(bf);
	}//readString2

	public static void main(String[] args) throws Exception {
		// 1) 직접 처리
		System.out.println("** main readString1=> "+readString1());
		
		// 2) 위임 처리 (떠넘기기)
//		try {
//			System.out.println("** main readString2=> "+readString2());
//		} catch (IOException e) {
//			System.out.println("** main IOException=> "+e.toString());
//		} catch (Exception e) {
//			System.out.println("** main Exception=> "+e.toString());
//		}
		//3) main 도 throws 가능함 
		System.out.println("** main readString2=> "+readString2());
	} //main

} //class
