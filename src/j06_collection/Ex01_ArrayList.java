package j06_collection;

import java.util.ArrayList;
import java.util.List;

import j01_class.Ex02_Person;

//** ArrayList<E>
//=> 데이터가 증가하면 메서드 호출하지 않아도 저장용량은 자동증가 함
//=> 필요시엔 미리 설정가능
//1) 생성자 
//	-> 초기값 지정 가능 :  new ArrayList<>(100) ;
//2) 메서드 이용
//	-> public void ensureCapacity(int minCapacity) : ArrayList 에 정의

//** 계층도
//=> Collection(i) -> List(i) -> LinkedList , ArrayList

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.정의
		//ArrayList list = new ArrayList();
		
		//리스트에 정의된 메서드만 사용하겠다 
		List list = new ArrayList();
		
	    // 2. 저장용량
	    // => 필요시에 자동으로 늘려줌
	    //    (매우 비효율적 : 큰공간을 할당하고 기존의 값들을 이동함 )
	    // => 생성시에 할당가능 : 생성자 매개변수로 지정
	    //    생성시에 필요한 충분한 용량을 할당하는것이 바람직함.
		
	    // => 비교
		// 사이즈는 리스트의 요소의 수,
	    // 용량은 리스트는 잠재적으로 그 내부구조를 재 할당없이 수용할 수있는 요소의 수
		System.out.println("**생성후 default size =>" + list.size());
//		list.ensureCapacity(20);			// 선언시 사이즈 할당, 자동으로 늘어나는거 매우 비효율적, ArrayList에만 정의된 메서드 
		System.out.println("**ensureCapacity(20) 지정후 size =>" + list.size());
		
		// 3. 초기화 
		list.add("홍길동");
		list.add(123456);
		
		// 기본 자료형 사용불가 int로 넣어도 컴파일러가 객체 형태로 형변환 
		list.add(new Integer(100));
		
		int sum = (int)list.get(1) + (int)list.get(2);		// 사용 : get 인덱스 번호로 값 뽑기 Integer로 나옴 계산시 형변환 필수 
		list.add(1 , sum);			// 끼워넣기		인덱스 번호 이용해 위치 선정
		list.set(3, 333);			// 수정하기 			
		list.add("홍길동2");			// 인덱스 번호 미 사용시 맨뒤로 들어감 
		list.add(123.415);
		
		list.remove(4);				// 삭제하기 
		
		System.out.println("**add 후 size =>" + list.size());
		
		// 4. 출력
		for(Object o : list) {System.out.print(o + " ");}
		System.out.println();
		
		// 5. Person 추가
		list.add(new Ex02_Person("홍길동" , "1010" , 111));
		
		for(Object o : list) {System.out.print(o + " ");}
		System.out.println();
		
		// 6. Type 지정해서 생성 
		ArrayList<Ex02_Person> list2 = new ArrayList<Ex02_Person>();
		list2.add(new Ex02_Person("홍길동1" , "1010" , 1111));
		list2.add(new Ex02_Person("홍길동2" , "2020" , 2222));
		list2.add(new Ex02_Person("홍길동3" , "3030" , 3333));
//		list2.add(12312);      // Ex02_Person 타입임  Error
		// -> 나이의 합을 출력하세요
		int tot = 0;
		for(Ex02_Person o : list2) {
			System.out.println(o);
			tot += o.getAge();
		}
		
		 tot = 0;
		for(int i = 0 ; i< list2.size() ; i++){
			System.out.println(list2.get(i));
			tot += list2.get(i).getAge();
		}
		System.out.println(tot);
		
		
	}//main

}//class
