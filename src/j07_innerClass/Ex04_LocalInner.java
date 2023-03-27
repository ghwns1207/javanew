package j07_innerClass;

//** LocalInner Class
//=> 메서드의 내부에 정의 되는 InnerClass.
//=> 메서드내에 정의되는 지역변수와 같다 (즉, 메서드내에서만 사용됨)
//=> static Local_InnerClass는 허용 되지 않음
// 단, 상수는 허용


public class Ex04_LocalInner {

	int a = 100;
	
	Ex04_LocalInner(){ System.out.println("** Ex04 default 생성자 "); }
	
	public void innerTest( int n ) {
		int b = 200; 
		final int C = n;      // 상수는 대문자 
		
		System.out.println("** innerTest(), b = " + b);
		// ** Local Inner Class 정의 
		class LInner{
			int d = 400; 
			
			LInner(){ System.out.println("** LInner default 생성자 "); } 
			
			public void printData() {
				System.out.printf("** LInner printData : a = %d, b = %d, C = %d, d = %d \n" , a,b,C,d);
			}// printData
			
		}//LInner
		
		System.out.println("** innerTest(), c = " + C);	// Local Inner Class 생성시점 확인 위해 출력
		// ** Local Inner Class 사용 
		LInner lin = new LInner();			// 생성자 만나기 전까지 로컬  이너 클래스 동작안함 
		lin.printData();		// 로컬 이너 클래스는 메서드 내부에서만 사용가능 
		
	}//innerTest
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ** Outer 클래스 생성
		// => Inner 클래스 생성시점 : 메서드 호출시 메서드 내부의 생성문 실행시점에 생성 
		Ex04_LocalInner ex04 = new Ex04_LocalInner();	// outer class 생성 
		ex04.innerTest(20);			// 

	}//main

}//class 
