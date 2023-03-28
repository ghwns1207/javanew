package j07_innerClass;

//** 익명클래스 (Anonymous 클래스)
//=> 이름이 없는 클래스이며, 한번만 사용하고 버려지는 객체를
// 사용 할 때 유용하게 쓰이는 내부클래스로서,
// 다른 클래스를 상속 받는 경우 또는 인터페이스를 구현 하는 경우 이용됨

interface Flyer {
	void fly();
}// Flyer, abstract public 생략

// 1. 일반적인 방법 
// => 구현 클래스를 작성해놓고 필요할 떄 사용 : 사용 빈도가 많을 떄 , 언제든 재사용 가능 
class FlyerI implements Flyer {

	@Override
	public void fly() {
		System.out.println("** 일반적인 방법 : 구현 클래스를 작성 -> 언제든 재사용가능 ");
	}

}// FlyerI

public class Ex05_AnnonyFly {

	public static void main(String[] args) {
		// 1. 일반적인 방법
		Flyer f1 = new FlyerI();
		f1.fly();

		// 2. 익명클래스 (Anonymous 클래스)
		// => 구현 클래스를 필요한 위치에서 직접 작성
		// 		Flyer f2 = class {.....}; -> 이러한 개념을 문법적으로는 아래처럼 정의 
		// 		Flyer f2 = new Flyer(); -> 인터페이스로는 생성 불가능 (인터페스명의 생성자허용안됨)
		//     	Flyer f2 = new Flyer(); {......}; -> 익명 클래스 정의 
		// => 인터페이스는 직접 생성(new) 될수 없고 implements 하는 클래스를 통해 생성후 사용되어짐.
		// => 단, 익명 클래스는 새로운 클래스명을 작성하는 것이 아니고, 인터페이스명(또는 조상클래스명) 으로 생성함.
		// 인터페이스의 구현 클래스를 new 다음에 직접 작성함
		// => 그러므로 익명 클래스는 클래스를 상속받거나, 인터페이스를 구현하는 형태만 가능하며,
		// 강제성을 부여한 일회성 코드에 주로 이용됨 (예, 이벤트 핸들러 또는 이벤트 리스너 구현)
		// => Anonymous 클래스에서는 인터페이스이름으로 new 하고 { ...}; 블럭에서 구현
		// 마지막에는 반드시 ;
		// => 내부적으로 Flyer 를 구현한 익명의 클래스가 생성되며 이를 Anonymous 클래스 라함.

		Flyer f2 = new Flyer() {
			@Override
			public void fly() {
				System.out.println("** 익명클래스 (Anonymous 클래스) : 직접 오버라이딩 메서드 작성 ");

			}
			// => 오버라이딩 외의 메서드 추가 : 오류는 없음 -> 조상 인스턴스로는 실행 불가능 하므로 의미없다 , 조상 인터페이스의 정의된 내용이 아니면 실행 x 
			public void myMethod() {System.out.println("** myMethod Test"); }
		}; // 익명클래스 종료 반드시 ";" 필요함.
		f2.fly();
		
		// 3. Object를 상속 받는 익명 클래스 
		Object ob = new Object() {			// 메서드 사용의 제한이 있다 
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Object를 상속 받는 익명 클래스 Test";
			}
			  // => 오버라이딩 이 아닌 메서드는 작성 불가능하지는 않지만
	         //    조상의 인스턴스로는 실행 불가능하므로 작성의 의미가 없음
			public void myMethod() {System.out.println("** myMethod Test"); }
		};
		System.out.println(ob);

	}// main

}// class
