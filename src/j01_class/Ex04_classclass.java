package j01_class;

// ** 클래스와 클래스 간의 관계 
// 1. 상속(is-a) : Person , student 
// 2. 집합(has-a) : ex04 와 Person
// 3. 사용(use)
public class Ex04_classclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. 상속(is-a)
		// -> 후손과 조상이 같은 type 이 될 수 있다.
		// -> 단, 조상에 정의된 멤버만 사용가능 (student에만 정의된 info, 등은 접근 불가)
		// 더 큰 자식을 받아 잘려나간 부분 캐스팅 가능

		Ex02_Person person = new Ex03_Student("홍길동1", "01032297255", "", 28, 100, 100); // 후손이 조상 타입이 될 수 있다.
		System.out.println("person Test : " + person.getName());
		((Ex03_Student) person).getSum(); // 캐스팅 하면 사용가능

		// 2. 집합(has-a) : student 와 car

		Ex03_Student student = new Ex03_Student();
		System.out.println("student car => " + student.car.color); // 집합 관계
		// System.out.println 스태틱입니다 사용가능요

		// 3. 사용(use) : ex04 와 car
		myCar(new Ex03_Car());		//실인수 부분에서 인스턴스 생성
	}

	public static void myCar(Ex03_Car car) {

		car.speedUp();
	}

}
