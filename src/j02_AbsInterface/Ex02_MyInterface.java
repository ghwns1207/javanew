package j02_AbsInterface;

//** interface 1.
//=> 상수, 추상메서드
//=> static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)

public interface Ex02_MyInterface {
	// ** 상수만 가능 -> public static final 는 생략 가능
	public static final int NUM = 123;
	String NAME="Green";
	
	// ** 추상 메서드만 가능 -> public abstract 는 생략 가능
	public  abstract int getNum(); 
	abstract void setNum(); // 접근범위 : public
	String getName();       // public abstract 생략
	
	// ** 생성자 허용 되지 않음
	// Ex02_MyInterface() { } -> Error
} 
