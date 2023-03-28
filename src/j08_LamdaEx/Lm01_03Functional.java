package j08_LamdaEx;

//** @FunctionalInterface Test
//=> 이를 적용한 인터페이스는 한개의 추상메소드만을 선언할수있다.
//=> 그러나 static, default 선언이 붙은 메서드는 무관함.

@FunctionalInterface // 추가 메서드 하나만 가능
interface Value {
	int num(int a, int b); // 하나의 메서드만 가능
//	String myString(int a , int b);
}

class Compute {

	// => 아래 메서드의 매개변수로 FunctionalInterface 를 정의
	// => 이 메서드에 전달될수 있는 매개변수는 이 인터페이스의 구현객체
	// Lamda 식으로 정의 가능
	// 이떄 num 메서드의 구현부가 작성됨
	// 이 시점에서는 num 메서드의 처리내용은 구현이 안되어 있음
	public void inValue(Value v) { // 매개변수를 인터페이스 사용 use-a 관계
		int result = v.num(5, 10);
		System.out.println("result => " + result);
	}

}

public class Lm01_03Functional {

	public static void main(String[] args) {
		
		// 1. 람다식 사용 X, 익명클래스 ( + 연산으로 구현 )
		System.out.println("** Test1. 람다식 사용 X, 익명클래스 **");
		
//		Value v1 = new Value() {
//		@Override
//		public int num(int a, int b) {
//			// TODO Auto-generated method stub
//			return a+b;
//		}
//	};		
		
		Compute cp1 = new Compute();
		// => Value Type의 매개변수를 익명클래스로 정의 
		cp1.inValue(new Value() {
			@Override
			public int num(int a, int b) {
				System.out.printf("** num : a = %d , b = %d" , a,b);
				return a+b;
			}
		});

		// 2. 람다식 사용 O ( * 연산으로 구현 )
		// => Value Type의 매개변수를 람다식 정의 
		System.out.println("** Test2. 람다식 사용  **");
		cp1.inValue((a,b) ->{
			System.out.printf("** num : a = %d , b = %d" , a,b);
			return a * b ; 
		});

		// 3. 생략형 람다식 사용 O ( - 연산으로 구현 )
		System.out.println("** Test3. 람다식 사용 : 생략형  **");
		cp1.inValue((a,b) -> a - b);
		
	} // main

}// class
