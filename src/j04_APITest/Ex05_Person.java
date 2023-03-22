package j04_APITest;

import java.util.Calendar;

//** Person
//=> 주민등록번호, 이름을 전달받으면
//=> 주민등록번호를 이용해서, age, 성별을 set 하고
//=> info 출력하기 

//=> 맴버필드(private) : idNo(String), name(String), age(int), gender(char)
//=> 생성자 2개
//		* default
//		* 주민등록번호,이름을 매개변수로 전달받아 초기화 
//		-> 나이 계산, 성별도 찾아서 set
//=> setter/getter
// 		이름만 수정 가능, 
//		모든필드를 사용가능 (그러나 주민번호는 뒷자리는 * 로표시)
//=> infoPrint()
//=> toString 은 오버라이딩

//** info
//이름 : 000
//번호 : 090909-*******
//나이 : 20세
//성별 : "남" 또는 "여"

public class Ex05_Person {
	// 1) 맴버필드(private)
	private String idNo;
	private String name;
	private int age;
	private char gender;
	// 2) 생성자 2개
	// => default
	public Ex05_Person() { System.out.println("** Person Default 생성자 **"); }
	// => 초기화 생성자
	public Ex05_Person(String idNo, String name) {
		System.out.println("** Person 초기화 생성자 **"); 
		this.idNo=idNo;
		this.name=name;
		
		// idNo : 6자리-7자리 총14 자리 -> 900909-1022333 , 010101-3011222
		// ** 성별
		this.gender=idNo.charAt(idNo.indexOf("-")+1);
		
		// ** age : 올해 - 태어난해 
		// => 올해 : Date(지원하지 않음) , Calendar(많이사용됨)
		// => 태어난해: idNo 의 앞2자리와 뒤 첫자리
		//            ( 1,2 -> +1900 / 3,4 -> +2000 )
		
		// => Calendar 사용
		//Calendar now = Calendar.getInstance();
		//int year = now.get(Calendar.YEAR); 
		int year = Calendar.getInstance().get(Calendar.YEAR);
		age = year-Integer.parseInt(idNo.substring(0,2)); // 2022-(01+2000) 
		
		if (gender=='1' || gender=='2') age-=1900;
		else  age-=2000;
	}
	
	// 3) setter
	public void setName(String name) { this.name=name; }  
	// 4) getter
	public String getIdNo() {
		// 090909-1234567 -> 090909-*******
		if ( idNo != null )
			 return idNo.substring(0, idNo.indexOf("-"))+"-*******" ;
		else return null;
	}
	public String getName() { return name; }
	public int getAge() { return age; }
	public char getGender() { 
		if (gender=='1' || gender=='3') return '남'; 
		else if (gender=='2' || gender=='4') return '여';
		else return ' '; // char Type 은 '' 허용하지않음
	}
	// 5) 출력
	public void infoPrint() {
		System.out.println("** info Print **");
		System.out.println("** 번호 : "+getIdNo());
		System.out.println("** 이름 : "+getName());
		System.out.println("** 나이 : "+getAge());
		System.out.println("** 성별 : "+getGender());
	}
	@Override
	public String toString() {
		return "Ex05_Person [idNo=" + idNo + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	// => 개발자용	 (입력된 원시 Data 그대로 출력) 

} //class
