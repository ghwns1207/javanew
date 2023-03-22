package j04_APITest;

public class Ex05_PersonTest {
	
	public static void pSort(Ex05_Person[] ars) {
		for (int i=0; i<ars.length; i++) {
			for (int j=i+1; j<ars.length; j++) {
				if (ars[i].getAge() < ars[j].getAge()) {
					Ex05_Person temp = ars[i];
					ars[i] = ars[j];
					ars[j] = temp;
				} //if
			} //for_j
		} //for_i
	} //pSort

	public static void main(String[] args) {
		// => 생성과 동시에 초기화
		Ex05_Person p1 = new Ex05_Person("090909-3234567","홍길동");
		p1.infoPrint();
		System.out.println("** toString => "+p1);
		
		Ex05_Person p2 = new Ex05_Person("890909-1234567","이길동");

		// ** Person Type 의 배열에 5명을 채우고 age 가 많은 순서로 출력하기 
		// => age 순 descending(내림차순)
		// => 순서 : Person Type 배열 정의, 5명으로 초기화, 정렬, 출력
		Ex05_Person[] pps = {p1, p2, new Ex05_Person("990909-2234567","이그린") 
							, new Ex05_Person("950909-1234567","김철수")
							, new Ex05_Person("000909-4234567","오영이") };
		pSort(pps); // 내림차순정렬
		for (Ex05_Person p:pps) {
			System.out.println("*-------------------*");
			p.infoPrint();
		}
		
	} // main

} //class
