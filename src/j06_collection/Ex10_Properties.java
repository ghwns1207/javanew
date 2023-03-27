package j06_collection;

import java.util.Enumeration;
import java.util.Properties;

//** Properties
//=> Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로, 
// Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 
// Properties는 (String, String)형태로 저장하는 보다 단순화된 컬렉션 클래스 이다. 

//=> Properties SourceCode header
// public class Properties extends Hashtable<Object,Object> {...

//=> 주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 
// 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다. 
// 그래서 간단한 입출력은 Properties를 활용하면 몇 줄의 코드로 쉽게 해결할 수 있다.

public class Ex10_Properties {

	public static void main(String[] args) {
	    // 1. 정의 & 초기화
	    // => 동일Key 허용되지않고, 입력시에는 나중값이 적용됨. 
		// => 순서는 무관
		Properties pp = new Properties();
		
		pp.setProperty("list", "StudentList.java");
		pp.setProperty("detail", "StudentDetail.java");
		pp.setProperty("insert", "StudentInsert.java");
		pp.setProperty("update", "StudentUpdate.java");
		pp.setProperty("delete", "StudentDelete.java");
		pp.put("delete", "StudentDelete.java");
//		pp.setProperty("test", 112);  -> 컴파일 오류 String , String 형식만 허용됨
		
		System.out.println("** Properties Test**");
		System.out.println(pp);
		
		// 2. 순차처리 
		// Enumeration 이용  Iterator의 구버전 
		// propertyNames() 키값만 
		Enumeration<?> ep = pp.propertyNames();		// Properties의 키 값들만 리턴 
		
		//Iterator hasnext()와 똑같음 
		while(ep.hasMoreElements()) {
			String ekey = (String)ep.nextElement();   // 오브젝트 타입 형 변환 
			System.out.printf("KEY = %s , getProperty = %s , get = %s \n" , ekey, pp.getProperty(ekey), pp.get(ekey));
		}
		
	}//main

}//class
