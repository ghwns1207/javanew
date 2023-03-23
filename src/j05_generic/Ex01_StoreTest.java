package j05_generic;

import j01_class.Ex02_Person;

//------------------------------------------------------------
//** Generic
//=> 컬렉션(Collection:자료구조) 을 보강해준 기능
//=> 컴파일 단계에서 객체의 자료형을 선언(정의) 해주면
//   다른 타입의 자료가 저장될수 없도록 해주는 기능

//** Generic 클래스 정의
//=> 클래스 이름 옆에 <> 사이에 알파벳 1글자를 사용하여 
//   Generic Type 명을 선언해줌 
//   ex : <T> 처럼 "<" 와 ">" 사이에 선언 
//=> 대문자로 T, E 등을 많이 사용 
//   Type 의미로 "T" 를 주로 사용
//=> Generic 타입으로 클래스를 사용한다는 의미 
//=> 제네릭으로 기본 자료형(int, float, double....)은 사용할 수 없지만
//   기본자료형의 wrapper 클래스를 이용할 수있다. 

//** Generic 타입제한 (Wildcards_와일드카드타입 이용으로)
//=> <?>
//   Unbounded Wildcards (제한없음_모든 클래스나 인터페이스 타입 가능)

//=> <? extends ...> 상속 받은 클래스 까지는 가능하지만 위로는 안됨
//   Upper Bounded Wildcards (상위클래스 제한_같거나 하위 타입 가능)
//=> <? super ...>	반대 위로는 되지만 아래는 안됨
//   Lower Bounded Wildcards (하위클래스 제한_ 같거나 상위타입 가능)
//------------------------------------------------------------
 
// 1. Object 이용한 기존방식
// Object data = new String("Test");
// => 모든 클래스는 Object의 후손이므로 
// 우측에 사용되어 대입될수 있다
// 즉, 모든 클래스는 아래 setter의 매개변수가 될수있다

class Store{
	private Object data;

	public Object getData() { return this.data; }

	public void setData(Object data) { this.data = data; }
	
	
}//Store

// 2. Generic 방식     
// => 클래스변수의 타입을 T(임의의 알파벳) 로 표현 해놓고
// 실행코드에서 결정해서 사용 
// => 결정된 타입 이외에는 사용불가 ( Exception 발생 )

class StoreG<T>{			// 클래스명 < 임의의 알파벳>
	private T data;      // 타입을 지정하지 않고 임의의 알파벳으로 대신  

	public T getData() { return this.data; }

	public void setData(T data) { this.data = data; }
	
}
public class Ex01_StoreTest {

	public static void main(String[] args) {

		// 1. Object 이용한 기존방식
	    // => 매개변수들 Type
	    //      "짜장면" :  Object ? = new String("짜장면") 과 동일한 의미
	    //       123 :  Object ? = new Integer(123) 과 동일한 의미
	    //      그러므로 String ss = (String)s1.getData();  // "짜장면" 가능, 123 런타임오류
	    //     그러므로 Integer i = (Integer)s1.getData(); // 123 가능 "짜장면" 런타임오류
		
		// 형변환이 불가능한 경우에도 컴파일 오류 발생하지 않음 
		// 이 상황을 방지하기 위한 프로그래밍 기법이 제네릭
		Store s1 = new Store();
		s1.setData("짜장면");
//		s1.setData(new Ex02_Person("김호준", "나나", 30));
//		s1.setData(123);			// Integer 기본자료형은 wrapper class 로 자동 형변환 
		s1.setData(12.542);			// Double 
		
		
		// 문제점 : 
		// => 컴파일 오류는 없지만, 런타임 오류 발생가느성 매우 높음  java.lang.ClassCastException
		// => Object type 의 특성상 모든 타입의 자료가 사용가능하므로 코드에서 원하지 않는 type의 자료가 
		// => 담겨 있더라도 컴파일 오류가 발생하지 않음 
		// -> 그러므로 코드상 필요한 type으로 타입 제한이 필요함 
		// -> 이것을 가능하도록 지원하는 방법이 generic
//		String ss = (String)s1.getData();	// 현재 Double type 이기 때문에 스트링으로 형변환을 할수 없다  -> 런타임 에러 발생 
		
		Double d = (Double)s1.getData();	//
		System.out.println(" ** Test1 =>" + s1.getData());
		
		// 2. Generic 방식  
		// 2.1) 생성시 Generic type 을 생략 가능 하지만 
		// Generic 이 적용안됨 (기존 방식 처럼 작동됨 - > 오브젝트 )
		StoreG sg1 = new StoreG();
		sg1.setData("제네릭");
		sg1.setData(123);
		sg1.setData(123.1564);
		
		System.out.println(" ** test2.1 => " + sg1.getData());
		
		// 2.2) 스트링만 사용가능 
		StoreG<String> sg2 = new StoreG<String>();   // -> 구버전 우측에 타입 
		sg2.setData("오호");
//		sg2.setData(123);      -> 잘못된 타입을 넣으면 컴파일 에러 
		System.out.println(" ** test2.2 => " + sg2.getData());
	  
		// 2.3 Integer
		StoreG<Integer> sg3 = new StoreG();      // -> 신버전 우측 타입 필요없음
		sg3.setData(21321);
		sg3.setData(123);
//		sg3.setData(123.54556);	  // -> Double 타입 에러 
		System.out.println(" ** test2.3 => " + sg3.getData());
		
		
		// 2.4)
		StoreG<Ex02_Person> sg4 = new StoreG<Ex02_Person>();
		sg4.setData(new Ex02_Person("홍길동" , "010" , 30));
		System.out.println(" ** test2.4 => " + sg4.getData());
		
	}//main

}//class
