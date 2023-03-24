package j06_collection;

import java.util.HashSet;
import java.util.Iterator;

//** Set
//=> 원소의 중복을 허용하지 않고, 순서가 없음
//=> HashSet, TreeSet, LinkedHashSet

//** HashSet
//=> HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수,
// 하지만 원소들의 순서가 일정하지 않은 단점이 있다.

//** Iterator 클래스 를 이용한 처리 (출력등..)
//=> 배열 -> Set
//=> Set -> Iterator : 순차 처리 적용

public class Ex04_HashSet {

	public static void main(String[] args) {
		// 1. 정의
		// => 원소의 중복을 허용하지 않고, 순서가 없음
		// => 동일성 Test
		// 제네릭을 적용하지 않거나, Object Type 인경우
		// 값은 같지만 Type 이 다른 경우 Test (다른 데이터로 취급)

		// 1.1) Object
		Object[] ob = { "가나다", '가', "123", new Integer(123), 123, "성남", "Green" };
		HashSet<Object> oSet = new HashSet<Object>();
		for (Object o : ob) {
			if (!oSet.add(o))
				System.out.println("** 중복자료 =>" + o); // 해쉬셋에 오버라이딩 된 add 리턴 boolean

		}
		System.out.println("** oSet ->" + oSet); // set 에는 oSet.toString() 오버리아딩 되어 있음

		// 1.2) String
		HashSet<String> set = new HashSet<String>();

		// 2. 초기화

		set.add("JAVA");
		set.add("HTML");
		set.add("CSS");
		set.add("REACT");
		set.add("SPRING");
		set.add("JAVA");
//		set.add(123);  String으로  PE 제한 

		// 3. 출력
		System.out.println("** set ->" + set);
		System.out.println("** set의 size ->" + set.size());

		// 4. 활용
		// => 삭제 (반복문 처리가 필요)
		// => 반복문 처리가 가능하도록 해춰야함 (즉 , Iterator를 사용)
		// => Iterator 활용
		// -> 순차적으로 비교하면서 우너하는 값 찾기, 삭제하기
		// -> 변경된 사항들은 원 원본에 반영됨

		Iterator<String> iset = set.iterator();

		while (iset.hasNext()) {

			// => 비교 (오류구문)
			// -> 반복문 내부에서 HTML이 아닌 경우 next가 두번 일어남
			// HTML 이 삭제되지 않는 경우가 가능해짐 .바람직하지 않음
//			if( iset.next().equals("HTML")) iset.remove();
//			else if( iset.next().contains("A")) iset.remove();

			String data = iset.next();
			if (data.equals("HTML"))
				iset.remove();
			if (data.contains("A"))
				iset.remove();

			// => iset을 처리하는 반복문 내부에서 set으로 접근하면 런타임 오루 발생
			// java.util.ConcurrentModificationException
//			set.add("MYSQL");
		}
		set.add("ORACLE");
		System.out.println("** iset-> " + iset);
		System.out.println("** After set-> " + set);
		System.out.println("** After set.size ->" + set.size());

		// 5. Iterator 인스턴스 재사용
		// => Iterator 는 한번 사용을 마치면 자료를 포인트하는 커서가
		// 끝에 가 있어 hasNext()가 false 를 return 하기 떄문에
		// 재할당해야 한다
		iset = set.iterator();
		while (iset.hasNext()) {
			String data = iset.next();
			if (data.contains("R"))
				System.out.println("**  Iterator 인스턴스 재사용 Test => " + data);
		}

		// 6. set 과 반복문
		// => set 은 인덱스를 이용해서 차례대로 꺼내어 사용하는것이 불가능한 것이지,
		// 무조건 반복문 내에서 사용할 수 없다는것은 아님
		for (int i = 1; i < 4; i++) {
			set.add("JAVA" + i);			
			set.add("JAVA" + String.valueOf(i));  //set.add("JAVA" + i); 자동형 변환 
			// => set.add("JAVA1"), set.add("JAVA2"), set.add("JAVA3")
			
		}
		System.out.println("** for set -> " +set);
		System.out.println("** for set.size -> " +set.size());

	}// main

}// class
