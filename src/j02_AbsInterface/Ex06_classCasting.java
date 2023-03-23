package j02_AbsInterface;

//*** 클래스의 형변환
//=> 자동 형변환 (형변환 생략가능)
//   조상 <- 자손 (Up_Casting)

//=> 명시적 형변환 (형변환 생략불가능)
//   자손 <- 조상 (Down_Casting)
//   실제적 클래스타입이 변환가능한 경우에만 적용됨 
//   (변환불가능한 경우에는 컴파일 오류 없어도 런타임 오류(ClassCastException) 발생)

//Animal => Mammal 포유류  => PetAnimal
//Animal => Reptil 파충류 

class Animal2 {
	int legsA=2;
	String name;
	public Animal2() {System.out.println("** Animal 생성자 **"); }
	public Animal2(String name) { this.name=name ;}
	void breath() {
		System.out.println(name +" 는 숨을 쉽니다 ~~");
	}
} // Animal

class Mammal extends Animal2 {
	String cry ;
	int legs=3;
	public Mammal() {System.out.println("** Mammal 생성자 **"); }
	void crying() {
		System.out.println(super.name+ " 은(는) "+cry + " 웁니다 ~~");
	}
} // Mammal

class PetAnimal extends Mammal {
	int legs=4 ;
	PetAnimal() { System.out.println("~~ PetAnimal 생성 ~~"); }
	
	@Override // Animal
	void breath() {
		super.breath();
		System.out.println("여기는 PetAnimal breath() 입니다 ~~");
	}
	
	void legsPrint(int legs) {
		System.out.printf("%s의 다리 => (Local):%d, Pet(Global):%d, Mam(Father):%d, Ani(할아버지):%d \n"
						,name,legs,this.legs,super.legs, super.legsA) ;
	} 
	
} //PetAnimal

class Reptile extends Animal2 {
} // Reptile


public class Ex06_classCasting {

	public static void main(String[] args) {
		// Test1. PetAnimal 생성
		PetAnimal dog = new PetAnimal();
		// ** instanceof Test
		if ( dog instanceof PetAnimal ) System.out.println("** dog 는 PetAnimal 입니다.");
		if ( dog instanceof Mammal ) System.out.println("** dog 는 Mammal 입니다.");
		if ( dog instanceof Animal2 ) System.out.println("** dog 는 Animal2 입니다.");
		if ( dog instanceof Object ) System.out.println("** dog 는 Object 입니다.");
		
		// Test2. Up_Casting Test
		Animal2 an1 = new PetAnimal(); // 조상 <- 후손 : Up_Casting
		//PetAnimal pa = new Animal();   // 후손 <- 조상 : Down_Casting (XXXXX) 
		an1 = new Reptile(); // 다형성 : 후손 교체 가능 
		
		Animal2 an2 = new Animal2();
		System.out.println("** an1 과 an2 비교 **");
		an1=dog;
		
		//an2=dog; 
		// 조상 <- 후손 : Up_Casting , an1, an2 에 정의된 만큼만 접근가능 
		// =>  Animal2 an2 = new PetAnimal(); 과 동일 효과
		
		 // Test3. Down_Casting -> 명시적으로
		System.out.println("** Down_Casting Test **");
		// an1.legsPrint(10); => 불가능
		PetAnimal cat=null ;	// String name = null;
		cat = (PetAnimal)an1; 	// an1 과 an2 비교 
		cat.legsPrint(10);		// => 생성시 사용한 생성자에 따라 다운 캐스팅이 가능 또는 불가능 하다 
								// => PetAnimal로 생성한 an1 은 가능 , Animal2로 생성한 an2 는 불가능 
		
		dog = (PetAnimal)an1; // 컴파일오류, 런타임오류 없음 -> 명시적 Down_Casting 가능
		dog.legsPrint(4);     // dog는 PetAnimal 에 정의된 맴버 접근가능
		
		//dog = (PetAnimal)an2;  
		// => 컴파일오류 없음, 런타임오류_ClassCastException
		// => 위 74행 주석처리후 Test 해야 런타임오류 발생함.
		// => 그러므로 instanceof 연산자로 확인 후 Down_Casting 적용
		if ( an2 instanceof PetAnimal ) {
			  dog = (PetAnimal)an2;
			  System.out.println("** an2 는 PetAnimal 입니다.");
		}else System.out.println("** an2 는 PetAnimal 이 될 수 없습니다.");
		
		// ** 인스턴스의 Class Type 출력하기
		// => Object 에 정의된 getClass() 메서드 이용
		System.out.println("** dog 의 Class Type => "+dog.getClass().getName());
		System.out.println("** an1 의 Class Type => "+an1.getClass().getName());
		System.out.println("** an2 의 Class Type => "+an2.getClass().getName());
		
		System.out.println("** Program Stop **");

	} //main

} //class
