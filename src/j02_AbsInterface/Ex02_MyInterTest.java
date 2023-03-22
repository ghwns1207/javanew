package j02_AbsInterface;

class MyChild1 implements Ex02_MyInterface {
	
	MyChild1() { System.out.println("** MyChild1 Default 생성자 **"); }
	
	// ** 오버라이딩
	// => 반드시 조상의 접근범위보다 같거나 넓어야함 
	@Override
	//String getName() { return NAME; } //=> Error : 접근범위 default (package) 
	public String getName() { return NAME; }
	
	@Override
	public int getNum() { return NUM; }
	@Override
	public void setNum() { }
	
	void child1() {System.out.println("** Child1 method Test **"); }
} //MyChild1

class MyChild2 implements Ex02_MyInterface {
	String name ="홍길동" ;
	int num;
	@Override
	public String getName() { return name; }
	@Override
	public int getNum() { return NUM*num; }
	@Override
	public void setNum() {num=100;}
	
	void child2() {System.out.println("** Child2 method Test **"); }
} 

public class Ex02_MyInterTest {

	public static void main(String[] args) {
		// ** interface 생성
		// => 직접생성은 불가능
		//    Ex02_MyInterface in1 = new Ex02_MyInterface();  -> ERROR
		// => 인스턴스의 Type 으로는 정의가능, 구현클래스를 통해 생성됨
		// => 그러나 사용범위는 interface 에 정의된 만큼만
		
		Ex02_MyInterface in1 = new MyChild1();
		System.out.printf("** main in1 : NAME=%s, NUM=%d \n",in1.getName(), in1.getNum());
		//in1.child1(); -> 호출 불가능
		
		Ex02_MyInterface in2 = new MyChild2();
		in2.setNum();
		System.out.printf("** main in2 : NAME=%s, NUM=%d \n",in2.getName(), in2.getNum());
		
		MyChild1 ch1 = new MyChild1();
		ch1.child1();
		// ** interface 에 정의된 상수에 직접 접근
		// => interface 이름으로 접근 (인스턴스명으로 접근하면 경고) 
		System.out.printf("** main interface 의 상수 : NAME=%s, NUM=%d \n",ch1.NAME, in2.NUM); // 경고
		System.out.printf("** main interface 의 상수 : NAME=%s, NUM=%d \n",Ex02_MyInterface.NAME, Ex02_MyInterface.NUM);

		// ** interface 의 특징
		// => MyChild1 , MyChild2 은 서로 관련이 없지만,
		//    동일 인터페이스를 구현했기때문에 같은 계층구조로 묶을 수 있게됨
		// => 다형성 적용가능
		in1 = in2;
		System.out.printf("** main in1=in2 : NAME=%s, NUM=%d \n",in1.getName(), in1.getNum());
	
	} //main

} //class
