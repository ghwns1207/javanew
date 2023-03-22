package j03_Exception;

//** try ~ catch ~ finally
//=> finally 블럭은 무조건 시행 

public class Ex03_finally {

	public static void main(String[] args) {

		int[] price = {100, 200, 300};
		// 1. 정상실행
		//for (int i=0; i<price.length; i++) {
		
		// 2. Exception, finally Test
		// => ArrayIndexOutOfBoundsException, continue, break, return
		for (int i=0; i<=price.length; i++) {
			try {
//				if (i==1) return;  // 더이상 수행하지 않고 메서드 종료 (void 메서드의 경우) 
//				if (i==2) break;   // 더이상 수행하지 않고 반복문 종료
				if (i==3) continue;// 이하를 수행하지않고 다음반복으로
				System.out.printf("** price[%d]=%d \n",i,price[i]);
			} catch (Exception e) {
				System.out.println("** Exception => "+e.toString());
			} finally {
				System.out.println("** finally_무조건 실행 , i => "+i);		// 리턴을 만나도 실행됨 
			}
			System.out.println("** for_endLine , i => "+i);
		} //for

		System.out.println("** Program 정상종료 **");
	} //main
} //class
