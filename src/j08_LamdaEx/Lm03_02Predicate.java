package j08_LamdaEx;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

//** Predicate Test
//=> boolean test(T t);
//=> 전달된 인자를 대상으로 true, false 판단할 때
//=> 제네릭 타입이므로 필요시 원하는 타입으로 정의히여 사용함.  

public class Lm03_02Predicate {

	public static int sum1(Predicate<Integer> p, List<Integer> list) {
		// => list의 자료들을 p로 테스트 하고 i에 누적
		int i = 0;
		for (int l : list) {
			if (p.test(l))
				i += l;
		}

		return i;
	}

	// ** IntPredicate
	// => int Type 전용 제네릭 지원하지 않음
	public static int sum2(IntPredicate ip, List<Integer> list) {
		// => list의 자료들을 p로 테스트 하고 i에 누적
		int i = 0;
		for (int l : list) {
			if (ip.test(l))
				i += l;
		}

		return i;
	}

	public static void main(String[] args) {
		// ** 준비
		// => List, Array 를 이용
		List<Integer> list = Arrays.asList(1, 6, 5, 0, 3, 8, -2);
		int sum = 0;
		// 1. Predicate sum1 Test 제네릭으로 타입 설정 가능
		System.out.println("** 1. Predicate sum1 Test  **");
		// => 짝수들의 합
		sum = sum1(n -> n % 2 == 0, list);
		System.out.println("** 1.1 짝수들의 합 => " + sum);
		// => 양수들의 합
		sum = 0; // clear
		System.out.println("** 1.2 양수들의 합 => " + sum1(n -> n > 0, list));

		// 2.IntPredicate_sum2 Test
		// => 홀수들의 합, int만 가능
		System.out.println("** 2.IntPredicate_sum2 Test **");
		sum = 0;
		System.out.println("** 1.2 홀수들의 합 => " + sum1(n -> n % 2 == 1, list));

		// 3. BiPredicate
		// => 두개의 인자를 받아 true, false 를 결정할 수 있음
		// boolean test(T t, U u);
		System.out.println("** 3. BiPredicate Test **");
		BiPredicate<String, Integer> bip = (s, i) -> {
			if(s.length() > i) return true;
			else return false;
		}; 
		
		if(bip.test("banana",3)) System.out.println("** 문자열 길이는 3을 초과 **");
		else System.out.println("** 문자열 길이는 3 이하 **");
		
		if(bip.test("BiPredicate",5)) System.out.println("** 문자열 길이는 5을 초과 **");
		else System.out.println("** 문자열 길이는 5 이하 **");
		
	}

}
