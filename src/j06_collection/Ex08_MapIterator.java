package j06_collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//** HashMap 의 순차처리 ( Iterator , Entry ) 
//1) 키와 값 같이 읽어 순차처리
//2) 키와 값을 따로 읽어 순차처리

public class Ex08_MapIterator {

	public static void main(String[] args) {
		// 1. HashMap 정의
		// <이름 키, 점수 벨루>
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		hm.put("구준표", 90);
		hm.put("금잔디", 70);
		hm.put("홍길동", 50);
		hm.put("유지희", 80);
		hm.put("구영표", 70);
		System.out.println("** hm => " + hm);

		// 2. 순차처리
		// 2.1) 키와 값 같이 읽어 순차처리
		// HashMap : entryset() -> set 메서드 이용 -> Iterator
		// 키와 값을 하나로 묶어 하나의 데이터 (Entry)로 set에 저장

		// *** ?
		// <?> => 모든 자료형 을 의미 , 내부적으로는 Object
		// <? super 객체형 > => 명시된 객체형의 상위 객체
		// <? extends 객체형 > => 명시된 객체형과 객체형을 상속한 하위 객체
		Set<?> set = hm.entrySet();
		System.out.println("** set by entrySet() =>" + set);

		// set -> Iterator
		Iterator<?> it = set.iterator();

		while (it.hasNext()) {
//	          System.out.println("** while : "+it.next()); 
			// => key 와 value 구분없음 (set 의 Data 를 읽어오는것에 불과)
			// => key, value 구분을 하려면
			// => Entry: set 의 Entry 객체를 Key 와 Value 로 구별
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) it.next(); // Map 안에 Entry 내부인터페이스
			// .entrySet(); 메서드로 합쳐진 키와 벨류를 (Map.Entry<?, ?>)it.next(); 형변환을 통해 키와 값으로 분리
			// 인스턴스 e 를 통해 key 와 value get 가능
			System.out.println("** Entry: key=" + e.getKey() + ", Value=" + e.getValue());

		}

		// 2.2) 키와 값을 따로 읽어 순차처리
		// 2.2.1 ) key 값 가져오기 
		// => HashMap : keyset() -> set -> Iterator
		set = hm.keySet();
		System.out.println("** set by keySet() =>" + set);
		
		// => 반복문1 적용 
		// set -> Iterator
		it = set.iterator();
		
		while(it.hasNext()) {
			String hmKey = (String)it.next();  // 형변환 
			System.out.println("**  keySet : key = " + hmKey + ", valu = " + hm.get(hmKey));	// 키를 통해 HashMap의 value를 뽑음 
		}
		
		// => 반복문2 적용
		for( String s : hm.keySet()) {
			
			System.out.println("**  for keySet : key = " + s  + ", valu = " + hm.get(s));	// 키를 통해 HashMap의 value를 뽑음 
		}
		
		// 2.2.2) value 값 가져오기 
		Collection<Integer> vs =  hm.values();
		// ** 순차처리 
		// Collection -> Iterator
		it = vs.iterator();  
		//it = hm.values().iterator(); 
		
		int sum = 0 ; 
		while(it.hasNext()) {
			sum += (Integer)it.next();        
		}
		System.out.println("** 총합계 :" + sum);
		System.out.println("** 평균 :" + (float)sum/ hm.size());
		System.out.println("** 최고점 :" + Collections.max(vs));    // Collection 타입이라 가능, Collections 래퍼 사용 
		System.out.println("** 최저점 :" + Collections.min(vs));
		
		
		
	}// main

}// clas

//** Entry
//Map 인터페이스는 내부에 내부인터페이스 Entry를 가지고 있고, 
//Object key, Object value는 Entry 인터페이스에 선언되어 있음.
//그러므로 Map의 key와 value는 각각의 Object 이며 Map.Entry타입으로 저장됨. 
//그래서 Map의 key와 value에 접근 할때는
//=> 먼저 Map의 인스턴스에서 entrySet으로 키와 value를 둘다 가져온다. 
//=> entrySet은 Set타입이므로 Set타입 인스턴스에 저장
//=> Set타입으로 가져온 인스턴스에서 iterator()메소드 호출해서 iterator가져옴
//=> 얻어온 iterator에서 hasNext메소드를 호출하여 HashMap 내부 요소에 접근.
//=> HashMap의 각 key와 value값은 결국 Map.Entry 타입의 배열에 들어있으므로    
//HashMap에서 각 key와 value값에 접근하기위해서는  
//Map.Entry 타입 인스턴스에 iterator의 next()메소드로 key와 value값 가져온다.
