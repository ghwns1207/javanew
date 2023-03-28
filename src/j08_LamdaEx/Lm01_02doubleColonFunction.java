package j08_LamdaEx;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Function;

//** 메서드 참조  람다식 ::
//:: ( double conlon operator , 정식 명칭은 method reference )
//=> 람다를 더 간결하게 표현하는 문법.
//=> 람다식이 하나의 메서드만을 호출하는 경우 메소드 참조로 람다식을 간단하게 표현.
//   메소드를 참조해서 매개변수의 정보 및 리턴타입을 미리 알아내어,
//   람다식에서 사용하는 매개 변수를 생략하는 방식의 표현법.

//=> 대상::메소드 (대상은 클래스 또는 참조변수가 될수있음)
//  대상에서 메소드의 정보를 추출하여 람다식 처럼 익명 구현객체를 생성하는것.
// 참조하는 메소드의 매개변수를 생략할 수 있음.
//=> ppt 4p 
//=> https://myhappyman.tistory.com/65

//** Generic 타입제한 (Wildcards_와일드카드타입 이용으로)

//=> <?>
// Unbounded Wildcards (제한없음_모든 클래스나 인터페이스 타입 가능)

//=> <? extends ...>
// Upper Bounded Wildcards (상위클래스 제한_같거나 하위 타입 가능)

//=> <? super ...>
// Lower Bounded Wildcards (하위클래스 제한_ 같거나 상위타입 가능)


public class Lm01_02doubleColonFunction {

	public static void main(String[] args) {
		// 1. 단순한 반복문 출력 
		List<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Orange");
		colors.add("Yellow");
		colors.add("Green");
		colors.add("Blue");
		System.out.println("** 1. 단순 반목문 출력 **");
		
		for(int i = 0 ; i < colors.size(); i++) {
			System.out.println(colors.get(i));
		}//for
		
		// 2. forEach 메서드를 이용해 Lamda 적용
	    // 2. forEach 메서드를 이용해 Lamda 적용
		// => void forEach(Consumer<? super String> action) 스트링, 오브젝트만 . 자신과 동급과 상위만 허락 , String은 종단 클래스
	    // => Consumer<? super String> : 같거나 상위타입 가능
	    // => Consumer 클래스 소스 확인   
		//    - @FunctionalInterface		// 추상 메소드 하나만 존재 
	    //    - void accept(T t);   
		//    - 인자는 전달 받지만 return 하지않는 즉, 인자를 소비하는 형태의 추상메서드
		//    - 그러므로 인자를 가지고 어떤 결과를 보여야 할때 유용하게 사용할 수 있음.   
		
		/* => forEach 메서드의 매개변수로는 다음식의 우측 코드가 전달되어야한다 
		 Consumer<String> cc = new Consumer<String>(){
		 		@Override
		 		void accept(String s){
		 			System.out.println(s);
		 		}  
			}
			=> 이코드를 람다식으로 정리하면 아래처럼됨 
				마치 메서드가 매개변수로 전될되는것돠 같은 효과를 줌 
		*/
		
		System.out.println("** 2. forEach & Lamda **");
		// => forEach는 리스트의 Data를 하나씩 매개변수로 전달해줌 
		// 	  forEach 메서드는 Iterable 인터페이스 default 메서드이고,
		//    Collection 인터페이스에서 Iterable 인터페이스를 상속하고 있기에 호출가능함 
		colors.forEach( s ->  System.out.println(s) );
		
		// 3. 메서드 참조 (::) 적용
		// => 위 2번의 매개변수 s 생략 가능 
		System.out.println("**  3. 메서드 참조 (::) **");
		colors.forEach( System.out::println );
		
		
		// 4. Function <T ,R > 사용 
	    // => T type 의 값을 받아 R type 으로 Return 하는 apply 추상메서드를 가지고 있음.
		//    R apply(T t); 
		
//		Function<String,Integer> f1 = new Function<String, Integer>() {
//			@Override
//			public Integer apply(String t) {
//				// TODO Auto-generated method stub
//				return Integer.parseInt(t);
//			}
//		};
		
		Function<String, Integer> f1 = t ->  Integer.parseInt(t);
		Function<String, Integer> f2 = Integer::parseInt;
		System.out.println("** 4.Function <T ,R >");
		System.out.println("** f1 + f2 =>" + f1.apply("1234")+ f2.apply("5678"));
		System.out.println("**( f1 + f2) =>" + (f1.apply("1000")+ f2.apply("2000")));

	}//main

}//class 
