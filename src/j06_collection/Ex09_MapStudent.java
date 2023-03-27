package j06_collection;

import java.util.*;

import j01_class.Ex03_Student;

//** Student HashMap Test 
// => HashMap 에 Student 객체 5개를 담고 출력하기 
// => <String , Student> 키는 String id로 "banana" , "apple" 
// => HashMap <String , Ex03_Student>
public class Ex09_MapStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. HaspMap 정의 
		Map<String, Ex03_Student> smap = new HashMap<String, Ex03_Student>();
		
		// 2.초기화 
		smap.put("banana", new Ex03_Student("김호준1", "11111111","배고파",271,70,80));
		smap.put("orange", new Ex03_Student("김호준2", "22222222","배고파",272,70,80));
		smap.put("apple", new Ex03_Student("김호준3", "33333333","배고파",273,70,80));
		smap.put("green", new Ex03_Student("김호준4", "4444444","배고파",274,70,80));
		smap.put("coffee", new Ex03_Student("김호준5", "555555","배고파",275,70,80));
		
		
		// 3.출력 
		System.out.println("** HashMap -> " + smap);
		
//		System.out.println("** set by entrySet() =>" + set);

		// 4. 활용
		// => 수정, 활용
		smap.get("green").setName("김그린");
		smap.remove("orange");
		System.out.println("** 수정, 삭제 결과 **");
		System.out.println(smap);
		
		// => 총합계, 반평균 
		// => map 순차처리 -> .values() 메서드로 Collection type으로 
		//  -> .iterator() 메서드를 이용 Iterator로 변경하면 반복적용 가능 
		Collection<Ex03_Student> sValues = smap.values();
		Iterator<Ex03_Student> itValues = sValues.iterator();
		int sum = 0;
		while(itValues.hasNext()) {		// (Integer)it.next(); next 리턴 오브젝트 타입 
			sum += itValues.next().getSum();	//next()메서드 사용 객체의 값 뽑기 
		}
		
		System.out.println("** 총합계 :" + sum);
		System.out.println("** 평균 :" + (float)sum/ smap.size());
		
		
	}//main

}//class
