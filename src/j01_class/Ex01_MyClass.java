package j01_class;

public class Ex01_MyClass {
	
	//멤버 
	// => 변수(속성/필드) 메서드/동작(main, 생성자, getter/setter, toString(), ...) 
	// => 멤버 (Global, 클래스 외부에서 접근 가능 ) / 지역 (local, 정의된 지역 범위내에서만 접근가능)
	
	// 접근제어자 : public 프로젝트 > protected 패키지 + 상속 > default 패키지 내부  > private 클래스 내부
	// => private : 메서드를 통해 접근 (setter/getter) 
	
	//static 정적 클래스 변수 /non_static 동적 ,인스턴스 변수  
	
	private static  String name = "김호준";   
	private  String job = "";
	private String phone = "01032297255";
	private int age = 100;
	
	// => 생성자 메서드 
	// 	- 기본(default) 생성자 : 매개변수 없음 , 생성자가 하나도 없으면 컴파일러가 자동 추가 
	// 	- 생성자 오버로딩 : 매개변수갯수 , type이 다르면 동명의 복수 메서드 허용 
	//  - 일반 메서드와 차이점 : 클래스와 동명, 리턴 값이 없다, new 연산자 뒤쪽에서 한번만 호출가능  
	//  - 기본 생성자, 멤버 변수들을 초기화하는 생성자를 주로 사용 
	
	public Ex01_MyClass(){ System.out.println("기본 default 생성자");}
	public Ex01_MyClass(String name, String job, String phone, int age) {
		Ex01_MyClass.name = name; 				//static 접근
		this.job = job;
		this.phone = phone;
		this.age = age;
	}
	
	public void myprint() {
		int age = 200;
		String name = "홍길동" ; 
		System.out.println("name1 : "+ name);
		System.out.println("name2 : "+ Ex01_MyClass.name);  // 홍길동
		System.out.println("job : "+ job );
		System.out.println("phone : "+ phone);
		System.out.println("age1: "+ this.age); 
		System.out.println("age2: "+ age); //200
		
	}// myprint

	public static void main(String[] args) {
		// => static 메서드 : static 또는 인스턴스를 통해 접근 
		Ex01_MyClass my = new Ex01_MyClass(); // 인스턴스 객체 
		
		int age = 20; //지역변수 
		System.out.println("안녕하세요");
		System.out.println("name : " + Ex01_MyClass.name );
		System.out.println("job : "+my.job );   // static 또는 인스턴스를 통홰 접근 
		System.out.println("phone : " + my.phone);
		System.out.println("age1 : " + age);	// 지역변수 
		System.out.println("age2 : " + my.age);	// 인스턴스 
		
		my.myprint();
		// => 생성자로 초기화 
		Ex01_MyClass tom = new Ex01_MyClass("Tom" , "게임" , "01011111111" , 11);
		tom.myprint();
		Ex01_MyClass jerry = new Ex01_MyClass("Jerry" , "요리" , "0102222222" , 20);
		jerry.myprint();
	}//main

}//class
