package j01_class;

public class Ex03_StudentUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0; 
		
		Ex03_Student st1 = new Ex03_Student("김호준" , "01032297255" , "잘 부탁드려요" , 28 , 80 , 80);
		Ex03_Student st2 = new Ex03_Student("홍길동1" , "01032297255" , "" , 28 , 100 , 100);
		Ex03_Student st3 = new Ex03_Student("홍길동2" , "01032297255" , "" , 28 , 80 , 50);
		Ex03_Student st4 = new Ex03_Student("홍길동3" , "01032297255" , "" , 28 , 70 , 80);
		Ex03_Student st5 = new Ex03_Student("홍길동4" , "01032297255" , "" , 28 , 50 , 40);
		

		Ex03_Student[] ar = new Ex03_Student[] { st1, st2, st3, st4, st5};
//		Ex03_Student[] t = new Ex03_Student[1];
		
		for(int i = 0 ; i < ar.length - 1; i++) {
			for(int j = i + 1; j < ar.length; j++ ) {
				if(ar[i].getSum() < ar[j].getSum() ) {
					Ex03_Student temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		
		for(Ex03_Student i : ar) {
			
			System.out.println("출력 번호 : " + ++count);
			System.out.println(i);
		}
		
	}

}
