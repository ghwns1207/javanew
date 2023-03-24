package j06_collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//** HashSet 을 이용한 로또번호 생성하기
//=> 중복자료가 허용안되는 Set 의 특징을 이용하여 로또 번호 생성하기
//=> Random 또는 Math 로 1 ~ 45 범위내의 정수를 중복되지 않도록 
// 6개를 추출후 출력하기
//=> 오름차순으로 출력하기   

public class Ex05_SetLotto {

	public static void main(String[] args) {
		// 1. Set, 필요한 인스턴스 or 변수 정의
		// => HashSet , Ramdom

		HashSet<Integer> set = new HashSet<Integer>();
		Random rm = new Random();

		// 2. 번호 생성 & set에 담기
		// => 반복문: for or while
		// => 반복문조건 : set.size() < 6

		while (set.size() < 6) {
			// => nextInt(45) + 1 : 1~45의 범위내에서 임의의 정수 1개를 추출
			set.add(rm.nextInt(45) + 1);

		}

		// 3. 출력
		System.out.println("** 정렬전 => " + set);

		// 4. for Test : 반복문 비교 와 중복확인
		int i;
		set = new HashSet<Integer>();
		for (i = 0; set.size() < 6; i++) {
			if (!set.add(rm.nextInt(45) + 1))
				System.out.println("중복 발생 => " + i);
		}
		System.out.println("반복횟수 => " + i);
		System.out.println("** for Lotto => " + set);

		// 5. 오름차순정렬
		// 5.1) Arrays 활용
		// set -> Array로 
		
		Object[] setarr  = set.toArray();
		
		Arrays.sort(setarr);    //오름차순 
		System.out.println("** After sort setArr => " + Arrays.toString(setarr));
		System.out.println("** After sort set => " + set);			//원본은 유지됨 
		
		// 5.2) Collections는 Collection WrapperClass, Collection은 인터페이스
		// => Collection 들의 WrapperClass
		// Collection 과 관련된 편리한 메서드를 제공
		// 단, interface Collection 과 구별
		// interface Collector 의 구현클래스 Collectors 와 구별
		// => Collections.sort(List<T> list)
		// 인자로 List 타입이 필요함

		// ** 오름차순 출력
		// => Set -> 순차구조 (Iterator , List)
		// => Set -> List
		// LinkedList 의 생성자중에 set을 매개변수로 사용하면
		// 이 set 을 list 생성해주는 생성자가 있음.
		
		List<Integer> list = new LinkedList<Integer>(set);   //생성자 set을 LinkedList 매겨변수로 받아 리스트로 변경 해줌 
		Collections.sort(list);
		System.out.println("**Collections.sort => " +list);
		
//		Iterator<Integer> iset = set.iterator();
//		
//		while(iset.hasNext()) {
//			System.out.print(iset.next() + " ");
//		}

	}// main

}// class
