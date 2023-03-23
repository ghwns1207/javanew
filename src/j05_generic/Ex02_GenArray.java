package j05_generic;

import j01_class.Ex02_Person;
//** 호준이 쀠;ㅇ쀵6
//** 과제
//=> 배열을 출력해주는 제네릭 클래스 만들기
// 배열정의, setter/getter, arrayPrint()
//=> 실행시에 원하는 타입을 결정 & 출력
//=> 배열 타입 Generic

class GenArray<T>{
	private T[] ar;

	public T[] getAr() {return ar;}
	
	public void setAr(T[] ar) {this.ar = ar;}
	
	public void arrayPrint() {
		for(T i : ar) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

public class Ex02_GenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int
		GenArray<Integer> intar = new GenArray<Integer>();
		intar.setAr(new Integer[] { 010, 3477, 12,8 ,5});		// 제네릭 사용시 선언에 사용한 타입으로 사용해야됨 
		intar.arrayPrint();
		
		//String
		GenArray<String> strar = new GenArray<String>();
		strar.setAr(new String[] { "갱호쭌" , "종쪼 " , "민우성" , "파크민수"});
		strar.arrayPrint();
		
		// Char
		GenArray<Character> charar = new GenArray<Character>();
		charar.setAr(new Character[] { '바' , '보', '멍', '청'});
		charar.arrayPrint();
		
		//Person
		GenArray<Ex02_Person> perar = new GenArray<Ex02_Person>();
		perar.setAr(new Ex02_Person[] {new Ex02_Person("호잇" , "둘리" ,123) , new Ex02_Person("호잇1" , "나나1" ,1010)});
		perar.arrayPrint();
	}//main

}//class
