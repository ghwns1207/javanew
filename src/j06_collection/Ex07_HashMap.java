package j06_collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

//*** 해싱과 해시함수 => 정석 651p
//해싱 => 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고
//     검색하는 기법

//*** Map ( Key, Value )
//=> HashMap (Key 값의 중복을 허용하지 않고, 순서 유지를 보장받지 못한다.) 
//=> TreeMap (Key 값의 중복을 허용하지 않고, 키값으로 오름차순 정렬이 된다.)
//=> LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)

//*** HashMap : Key, Value 정보 지정
//=> key 는 유일, Value 는 중복 허용 
//=> null 값 허용 추가  map.put(null, null) 또는 map.get(null(키)) 가능

public class Ex07_HashMap {

	public static void main(String[] args) {
		
		// HashMap
		// 1.1 정의 					<키 타입 , 벨류 타입 > 
		Map<Integer, String> hm = new HashMap<Integer, String>();
		
		// 1.2 put
		// key 는 유일 , value 는 중복 허용 
		// 중복 입력시 오류는 없고, 나중값 (value)이 보관됨 
		hm.put(1, "Java");
		hm.put(10, "Java");
		hm.put(2, "Spring");
		hm.put(20, "Python");
		hm.put(new Integer(3), "MySql");
		hm.put(5, "Mybatis");
//		hm.put(null, "Oracle");     // 변환 과정에서 널포인트 에러 출력 
		hm.put(5, "Hibernate");			// 중복값은 맨 마지막 값이 남음 
			
		// 1.3 출력
		System.out.println("**HahMap -> "+hm);
		
		
		// 1.4 활용 
		// => get, remove, size : key로 접근 
		System.out.println("**HahMap size -> "+hm.size());
		System.out.println("**HahMap get(키값) -> "+hm.get(2)); 	 	// 키 값이 20인 자료 
		System.out.println("**HahMap remove -> "+hm.remove(2));	// 삭제후 value return
		System.out.println("**After HahMap -> "+hm);
		System.out.println("**After HahMap size -> "+hm.size());
		
		// 2. 각종 Map 비교 
		// => 생성자 매개변수로 위의 HashMap 을 사용
		// => 단, key 값이 null 인 경우에는 전당과정에서 런타임 오류
		Map<Integer, String> tm = new TreeMap<Integer, String>(hm);		// 키 값 오름차순 정렬 
		System.out.println("** TreeMap -> "+tm);					
		
		Map<Integer, String> lm = new LinkedHashMap<Integer, String>(hm);		// 해쉬맵이 전달해준 순서 
		System.out.println("** LinkedHashMap -> " + lm);				// 입력순을 유지 : hm 에서 전달받은 순서를 유지
		// => 입력순 확인 
		lm =  new LinkedHashMap<Integer, String>();
		// 중복 입력시 오류는 없고, 나중값 (value)이 보관됨 
		lm.put(1, "Java");
		lm.put(10, "Java");
		lm.put(2, "Spring");
		lm.put(20, "Python");
		lm.put(5, "Mybatis");
		lm.put(3, "MySql");
		System.out.println("** LinkedHashMap -> " + lm);
		
		
		
	}//main

}//class
