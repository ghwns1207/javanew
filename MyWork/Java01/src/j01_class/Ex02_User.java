package j01_class;

public class Ex02_User  {

	public static void main(String[] args) {
		Ex02_Person p1 = new Ex02_Person();
		p1.setName("홍길동");
		p1.setPhone("01011111111");
		p1.setAge(200);
		
		System.out.println("** 기본생성자 Test** ");
		System.out.println("** Person =>" + p1.toString());
		System.out.println("** Person =>" + p1);   // 출력문에서 인스턴스 이름만 사용하면 디폴트로 toString() 메서드 호출 
													// => object에서 toString()는 객체의 주소를 return
													// toString()을 오버라이딩 하지 않으면 참조 주소를 반환 
		
		System.out.println("\n** 초기화 생성자 Test** ");
		Ex02_Person p2 = new Ex02_Person("홍길동" , "0102222222" , 150);		
		System.out.println("** Person2 =>" + p2);
		
	}//main
	
}//class
