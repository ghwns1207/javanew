package j03_Exception;

import java.util.Scanner;

//** AgeException 만들기2 -> UnChecked Exception 
//=> extends RuntimeException
//=> 즉, 컴파일러가 예외처리(try~catch~)를 확인하지 않음
//=> 주로 프로그래머의 실수로 발생 가능한 오류들
class AgeExceptionU extends RuntimeException {
	private static final long serialVersionUID = 1L;
	AgeExceptionU() {
		super("나이가 범위를 벗어남 : UnChecked Test");
	}
	AgeExceptionU(String message) {
		super(message);
	}
} //AgeExceptionU

public class Ex08_MyExceptionUn {
	
	// ** 나이 입력받아 return 하는 메서드 만들기
	// => 예외처리코드를 컴파일시에 확인하지않음
	public static int readAge() {
		Scanner sc = new Scanner(System.in);
		System.out.println("** 나이를 입력 하세요 => ");
		int age = sc.nextInt(); //문자입력시 -> InputMismatchException 
		sc.close();
//		if (age<1 || age>200) throw new AgeExceptionU();
		if (age<1 || age>200) throw new AgeExceptionU("message Test");
		else return age;
	} //readAge

	public static void main(String[] args) {
		// ** 에외처리 적용하지 않은경우
		// => 예외처리코드를 컴파일시에 확인하지않음
		//    그러나 런타임시에 오류가 발생하면 비정상종료함.
		System.out.println("** main: Age => "+readAge());
		
		// ** 에외처리 적용
//		try {
//			System.out.println("** main: Age => "+readAge());
//		} catch (Exception e) {
//			System.out.println("** Exception => "+e.toString());
//		}
		System.out.println("** Program 정상종료 **");
	} //main

} //class
