package j06_collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//** List 인터페이스 (ppt 18, 23)
//=> List의 특징 : 순서가 있으며 중복된 원소를 가질 수 있다.
//=> 구현 클래스 : ArrayList, LinkedList

//** LinkedList<E>  
//=> ArrayList 및 배열의 단점을 보완하여 고안됨.   
//=> 장점 
// 1) 저장공간을 늘리는 과정이 간단.
// 2) 자료 입력 & 삭제 과정이 단순.
//=> 단점 : 순차처리의 access time 이 ArrayList 보다 느리다.
//=> 빈번하게 삽입과 삭제가 일어나는 경우에 사용 

//** ArrayList<E> 
//=> 순서를 유지하며 중복을 허용하는 자료구조  
//=> 배열(Array)의 향상된 버전 또는 가변 크기의 배열이라고 생각하면 된다. 
//=> 장점 : 자료구조가 간단하며 사용이 쉽고 순차처리의 access time이 가장 빠르다.
//=> 단점
//1) 크기 변경시 새로운 배열을 생성하고 모든자료를 복사해서 옮겨야 하므로 비효율적
//2) 비순차적인 자료의 추가,수정,삭제시에 복사 및 이동 때문에 비효율적
//=> 크기가 일정하고 비순차적인 자료 수정이 발생하지 않는 경우 유리. 

//---------------------------------
//** source Code class header 참고
//public class LinkedList<E>
// extends AbstractSequentialList<E>
// implements List<E>, Deque<E>, Cloneable, java.io.Serializable
//{

//public class ArrayList<E> extends AbstractList<E>
// implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//{
//---------------------------------

//** 계층도
//=> Collection(i) -> List(i) -> ArrayList
//=> Collection(i) -> List(i), Deque(i) -> LinkedList 





public class Ex02_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 정의 
		
		LinkedList<String> list = new LinkedList<String>();
		
		// => 다형성
		//new ArrayList<String>() , new LinkedList<String>() 모두 가능  
		List<String> list2 = new LinkedList<String>();  
		
		// 2. 초기화 
		// -> int , double 등 기본자료형은 자동형변환 적용됨 
		list.add("JAVA");
		//list.add("1231"); 	    //type 제한 
		list.add("MYSQL");
		list.add("Servlet");
		list.add("JAVA");			// 중복 갑 허용 
		list.add("JSP");
		list.add("Spring");
		
		// 3. 사용 
		// -> get, set(수정), remove(삭제)
		list.remove(1); 		// mysql 제거 
		list.set(2 , "MYSQL"); 	// Servlet -> "홍길동"
		list.add("React");
		
		// 4. 출력 
		
		for(String s: list) {
			System.out.println(s);
		}
		
		// 5. 배열 -> List -> Iterator(순차 처리를 지원하는 클래스)로 변환.   List 빼고는 순차처리 지원 안함
		// 리스트는 add 사용을 해서 초기화 해야됨 귀찮아서 배열 만들고 그 배열을 리스트로 변경함
		String[] menu = {"짜장면","짬뽕","냉면","파스타","칼국수"}; 
		// 배열 -> list
		list2 = Arrays.asList(menu);
		
		// ** 변환된 리스트에 추가
		// 변환된 리스트는 원본 변경 불가 
		// 런타임 오류 발생 :  java.lang.UnsupportedOperationException
//		list2.add("탕수육");			
		
		// ** Iterator : 순차처리를 편리하게 지원해주는 클래스
	    // => hasNext(), next() 메서드를 이용	
		Iterator iMenu = list2.iterator();
		
		while(iMenu.hasNext()) {				//hasNext 다음 데이터가 있는지 검사 boolean 타입, next는 데이터 리턴 
			System.out.println(iMenu.next());
		}
		
}//main

}//class
