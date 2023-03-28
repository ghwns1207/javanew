package j08_LamdaEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

//** Supplier <T>
//=> 단순히 무언가를 반환할 때 유용.
// T get();

public class Lm03_03Supplier {
	
	// 1. Supplier를 이용해서 크기가 i 인 list를 만들어 준다
	// => sp의 get()이 return하는 값을 list에 add, n 번을 반복 
	// 	  즉, get()의 구현 내용에 따라서 return하는 값은 달라짐 
	public static  List<Integer> makeList(Supplier<Integer> sp, int n){
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0 ; i < n ; i++) { list.add(sp.get()); }
		
		return list;
	}
	
	// 2. DoubleSupplier
	public static  List<Double> makeDoubleList(DoubleSupplier sp, int n){
		List<Double> list = new ArrayList<Double>();
		
		for(int i = 0 ; i < n ; i++) { list.add(sp.getAsDouble()); }
		
		return list;
	}
	

	public static void main(String[] args) {
		// 1.  Supplier Test 
		// => get() : 0 ~ 50 사이의 랜덤 값을 리턴 
		
		Supplier<Integer> sp = () -> { 
			return new Random().nextInt(50);
		}; 
		
		// => 반복하여 list 만들기 
		System.out.println("**Supplier 5회 => " + makeList(sp, 5));
		System.out.println("**Supplier 10회 => " + makeList(sp, 10));
		
		// 2. DoubleSupplier Test 
		DoubleSupplier dsp = () -> {
			return new Random().nextDouble()* 50.0 + 0.0;
		};
		System.out.println("**DoubleSupplier 5회 => " + makeDoubleList(dsp, 5));
		
	}//main

}//class 
