package j01_class;

//** 클래스에 포함 가능한것 (맴버)
//=> 속성(변수, 필드_Field, Column), 기능.동작(메서드)
//=> 맴버변수(전역변수), 맴버메서드 
//=> 맴버메서드 종류 (역할이 정해져있는 메서드들)
// - main, 생성자(Constructor), toString, setter, getter

//** 클래스명																										
//=> 대문자로 시작, 예약어 사용불가 , API 라이브러리의 클래스명 비추
//=> 클래스는 객체의 설계도

//** 객체의 주기 (LifeCycle)
//=> 생성 -> 사용 -> 소멸  (in Memory, RAM)
//=> 클래스(in HDD) -> 생성(in Memory) -> 객체화 (인스턴스 생성)
// -> 사용 -> 소멸(Memory 반납)

//** 클래스, 객체, 인스턴스(instance : 사례, 경우) 
//	클래스와 인스턴스는 설계도와 제품이라고 할수있다.
//	그럼 객체는 클래스일까 인스턴스일까? 
//	Java 프로그래밍에서는 설계도인 클래스가
//	메모리상의 구체적인 실체인 인스턴스가 되었을때 객체라고 부른다. 

//	그러므로 클래스와 인스턴스는 구별되고, 클래스와 객체도 구별되지만, 
//	객체와 인스턴스는 구분없이 포괄적으로 객체라는 말을 쓰기도 한다.

public class Ex03_Car {
	// ** 맴버변수, 필드(field) : 속성 
	// => 클래스의 전역변수
	//    클래스내에 있는 모든 메서드에서 사용가능
	public int speed;
	public int mileage;
	public String color="Yellow";
	
	// 실행문 -> 메서드 내부에만 작성가능
	//color = "White"; XXXXXX
	//System.out.println("** speed => "+speed); XXXXX
	
	// ** 맴버메서드 (Method, function, procedure)
	// => 동작 또는 기능을 구현
	public void speedUp() {
		// ** 지역변수
		// => 메서드내부에서만 사용가능
		// => 전역변수와 동일명 가능 (내부에서는 지역변수 우선) 
		int price=1000 ;
		String color = "Blue" ;
		System.out.printf("** price=%d , color=%s \n",price, color);
		// return 10; // XXX
		// return; -> void 메서드 종료
		speed+=10;
		System.out.println("** speed => "+speed);
	}
	
	public void speedDown() {
		speed-=10;
	}
	
	// toString (메서드명) : 객체의 속성(맴버필드,맴버변수) 의 값을 문자로 제공하는 역할에 주로 사용됨	
	// String (return Type) : 문자열을 반환(return) -> 메서드 처리 결과로 문자열을 제공
	public String toString() {
		return "[ 속도: " + speed + " 주행거리: " + mileage + " 색상: " + color +" ]";
	}
	
} //class
