package jdbc02;

import java.util.List;

//** Controller
//=> 요청 : 요청분석 -> 담당 서비스를 호출 -> 서비스는 DAO 
//=> 결과 : DAO -> Service -> Controller 
//=> 출력 VIEW : Controller -> View처리 담당 (Java : Console , Web : JSP , HTML.. ,React)

public class StudentController {
	// ** 전역변수 
	StudentService service = new StudentService();
	
	public void printList(List<StudentVO>  list) {
		System.out.println("----------------------------------------------");
		System.out.println("** StudentList **");
		System.out.println("----------------------------------------------");
		if(list != null) {
			// ** list 출력 
			for(StudentVO s : list) {
				System.out.println(s);
			}
		}else {
			System.out.println("** SelectList : 출력할 자료 없음 ");
		}
	}
	
	public void printDetail(StudentVO vo) {
		System.out.println("----------------------------------------------");
		System.out.println("** StudentOne Detail **");
		System.out.println("----------------------------------------------");
		if(vo != null) {			
			System.out.println("* 번호 : " + vo.getSno());
			System.out.println("* 이름 : " + vo.getName());
			System.out.println("* 나이 : " + vo.getAge());
			System.out.println("* jno : " + vo.getJno());
			System.out.println("* info : " + vo.getInfo());
			System.out.println("* Birthday : " + vo.getBirthday());
		}else {
			System.out.println("** 출력할 자료 없음. ");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		StudentController sc = new StudentController();
		StudentVO vo = new StudentVO();
		
		// 1 . StudenList
		// => service의 결과물인 Student_list를 view 처리할수 있도록 전달 ,sc.service.selectList()결과물은 Student List 
		sc.printList(sc.service.selectList());
		
		// 2. StudentOne Detail (상세정보 )
		vo.setSno(3);
		sc.printDetail(sc.service.selectOne(vo));
		
		// 3. insert, update, delete 
		
		// => insert 
		vo.setSno(23);
		vo.setName("홍길동");
		vo.setAge(22);
		vo.setJno(9);
		vo.setInfo("JDBC Test");
		vo.setPoint(300.33);
		vo.setBirthday("2000-02-02");
		
		System.out.println("** insert Test => " + sc.service.insert(vo));		// return 숫자 확인 
		sc.printDetail(sc.service.selectOne(vo));   // insert 확인
		
		// => update
		vo.setSno(23);		// 현재 코드상 필요 없지만 각각 처리하는 경우에는 필요함 
		vo.setName("HongGil");
		vo.setAge(99);
		
		System.out.println("** update Test => " + sc.service.update(vo)); // return 숫자 확인 
		sc.printDetail(sc.service.selectOne(vo));   // update 확인
		
		// => delete 
		vo.setSno(23);		// 현재 코드상 필요 없지만 각각 처리하는 경우에는 필요함 
		System.out.println("** delete Test => " + sc.service.delete(vo));
		sc.printDetail(sc.service.selectOne(vo));   // delete 확인
		sc.printList(sc.service.selectList());
		
	}//main

}//class 
