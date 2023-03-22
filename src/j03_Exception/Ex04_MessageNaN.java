package j03_Exception;

public class Ex04_MessageNaN {

	public static void main(String[] args) {
		// ** by Zero ( 나누기 0 )
		// => 정수형 연산 : ArithmeticException 
		// => 실수형 연산 : Exception 이 일어나지않음
		//                Wrapper 클래스의 메서드 활용
		
		try {
			double d1 = 1.5/0.0 ; // Infinity : 무한수
			double d2 = 1.5%0.0 ; // NaN : Not a Number (숫자가 아님)
			
			if (Double.isInfinite(d1) || Double.isNaN(d2) )
				 System.out.println("** Zero 연산은 허용하지 않습니다 **");
			 System.out.printf("** 실수형연산 : d1=%f, d2=%f \n",d1,d2);
			
			System.out.printf("** Message Test : 정수 0 나누기=%d \n",(100/0));
							// 예외 발생 케치 블럭으로 
			
		} catch (Exception e) {
			System.out.println("** Exception, toString => "+e.toString());
			System.out.println("** Exception, getMessage => "+e.getMessage()); //Simple Message
			System.out.println("** Exception, printStackTrace => ");
			e.printStackTrace();
			// => e.toString 을 포함한 순차적인 실행경로 등이 출력되어
			//    예외발생의 원인과 경로 파악에 도움. 
			
		} finally {
			System.out.println("** finally_무조건 실행 **");
		} //try
		System.out.println("** Program 정상종료 **");
	} //main

} //class
