package j07_innerClass;

import j01_class.Ex03_Student;


//** 클래스 맴버
//=> 맴버(전역) 변수, 
//=> 메서드 : 생성자, main, setter/getter, toString, 일반메서드
//=> 초기화블럭 : {   }  / static {   }
//=> 내부(inner) 클래스 : 클래스 내부에 다른 클래스를 정의

//** Inner Class 기본형식과 특성

class OuterClass {
	// 1) 맴버(전역)변수
	int age = 100;
	private String name = "홍길동";
	static String grade = "A++";
	
	// => 맴버변수로 클래스를 장의
	// => has-a 괸계 포함 : 재사용성이 많은 경우 
	// inner 클래스와 비교 : 현재클래스에서만 필요한 경우 
	// ( 단 , inner 클래스가 외부에서 접근이 불가능한 맴버는 아님)
	Ex03_Student student;
	
	// 2) 생성자 및 메서드
	OuterClass(){ System.out.println("** outerClass Default 생성자 **"); }
	
	// 3) 클래스
	// => 내부(inner) 클래스 : 일반적인 클래스의 특징을 모두 가짐 
	// => 외부(outer) 클래스 의 모든맴버(private 포함) 에 접근 가능
	
	//class Inner
	static class Inner{
		
		// ** static Test
	    // => static 맴버 추가
	    //    내부 클래스가 static 변수를 사용하려면, 해당 내부 클래스도 static 이어야함.
	    //    -> static 내부 클래스
	    // => 단, JavaSE-16 부터는 일반내부 클래스도 static 변수 허용함.
		static String country = "korea";
		Inner(){ System.out.println("** Inner Default 생성자 **");}
		
		// => static inner 클래스인 경우 
		//	  static 방법으로 접근 가능하도록 작성 
		public static void printData() {
			 System.out.println("** Inner printData , grade => " + grade);		// outer 의 static 맴버 
			 
		}//printData
		
		// non-static inner 클래스인 경우 
//		public void printData() {
//			System.out.println("** Inner printData , ager => " + age);		//non-static Inner 클래스인 경우
//			System.out.println("** Inner printData , name => " + name);
//			System.out.println("** Inner printData , grade => " + grade);
//			
//		}//printData
		
	}//inner 
	
	
}// outerClass

public class Ex01_innerBasic {

	public static void main(String[] args) {
		// ** 생성 
		
		OuterClass out1 = new OuterClass();
		out1.age = 200;	// OuterClass의 맴버들만 접근 가능 
		
		// => student 사용 
		out1.student = new Ex03_Student("김호준5", "555555","배고파",275,70,80);
		System.out.printf("out1.age = %d, out1.student_name = %s \n" , out1.age , out1.student.getName());

		// => inner 사용(생성) 
		// 	생성문 왼편의 타입은 import 됨
		// 	직접 생산은 불가능 -> Inner in = new Inner(); 오류
		// 	우측의 생성자는 outer 클래스의 인스턴스의 종속됨
		
		// => static Inner Test 를 위해 주석 처리함 
//		OuterClass.Inner in1 = out1.new Inner();
//		in1.printData();
//		in1.printData(out1);	// static inner Test 
		
		// => inner 직접생산 
//		OuterClass.Inner in2 = new OuterClass().new Inner();
//		in2.printData();
		
		// ** static
		// => Outer의 static 멤버접근 
		System.out.println("** Outer의 static 멤버 ,grade =>" + OuterClass.grade);
		// inner 의 static 멤버 접근 
		
		// => static inner Test : Outer, inner 의 인스턴스가 필요없음
		OuterClass.Inner.printData();
		System.out.println("** static Inner country =>" + OuterClass.Inner.country);
		
	}// main

}// class
