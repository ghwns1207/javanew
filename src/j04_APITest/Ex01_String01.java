package j04_APITest;

//** String 1
//1) 선언(정의) 과 인스턴스
//=> 묵시적, 명시적
//=> 참조형변수 : 주소값을 가지고 있음
//=> 불변(immutable) 속성을 가짐.

public class Ex01_String01 {

	public static void main(String[] args) {
		// 1) 묵시적선언 
		String s1 = "그린";
		String s2 = "그린";
		// 2) 명시적선언
		String s3 = new String("그린");		// 처음 선언만 차이가 있고 다음 부터는 똑같은 같들은 공동으로 사용 
		String s4 = new String("그린");		// 각각의 데이터로 저장됨 
		
		// => 값 출력 비교
		System.out.printf("s1=%s, s2=%s, s3=%s, s4=%s \n",s1,s2,s3,s4);
		// => 값변경 전/후 비교
		s1="홍길동"; s3="홍길동";
		
		// 3) 인스턴스 비교
		// => 묵시와 묵시 : T
		if (s1==s2) System.out.println("s1 == s2 : True");
		else System.out.println("s1 == s2 : False");
		// => 묵시와 명시 : F
		if (s1==s3) System.out.println("s1 == s3 : True");
		else System.out.println("s1 == s3 : False");
		// => 명시와 명시 : F
		if (s3==s4) System.out.println("s3 == s4 : True");
		else System.out.println("s3 == s4 : False");

		// 4) 값(리터럴) 의 비교 
		if (s1.equals(s2)) System.out.println("s1 equals s2 : true");
		else System.out.println("s1 equals s2 : false");
		if (s3.equals(s4)) System.out.println("s3 equals s4 : true");
		else System.out.println("s3 equals s4 : false");	
		
		// 5) length(글자수), 문자열연산(+ 만가능) 
		s2="My name is Green";
		s3="안녕 하세요 ~~";
		System.out.println("** 영문 글자수 => "+s2.length()); //16
		System.out.println("** 한글 글자수 => "+s3.length()); //9
		int i=100, j=123;
		System.out.println("** 문자열연산 => "+s1+s2+s3+s4+i+j);
		System.out.println("** 문자열연산(우선순위) => "+s1+s2+s3+s4+(i+j));  // 우선순위 높여줌 ()
		
	} //main

} //class
