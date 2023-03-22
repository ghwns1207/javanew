package j02_AbsInterface;

//** 추상클래스 와 intertrace 의 활용 
//=> 일반적인 경우 사례
//=> 실무에서는 interface가 많이 사용되고 (다중구현의 장점) ,  
//   API 의 계층도에서는 추상클래스도 많이 이용됨 

//** 과제
//=> 게시판을 종류별로 10개 이상 만든다고 가정.
//=> 기본 기능 (interface) : insert, update, delete, listPrint, detail, replyInsert
//=> 게시판 종류별로 : 일반게시판(i,u,d,l,detail,r), QnA(i,r,l), 공지사항(i,l,detail)
//=> 모든 게시판은 interface 를 구현해야한다면
//   게시판 종류에 따라 필요없는 메서드도 오버라이딩 해야함.
//   이런 경우 interface 를 구현하는 추상 클래스를 작성하고
//   게시판은 이 추상클래스를 구현한다면 의무적 구현에서 벗어나 필요한 메서드만 구현 할 수 있음.

//** 추상메서드만
interface Boardi {
	void insert();
	void update();
	void delete();
	void listPrint();
	void detail();
	void replyInsert();
}
//** 추상클래스 : 일반메서드, 추상메서드
// => 추상 클래스는 추상메서드를 포함 할 수 있으므로 오버라이딩 의무는 없음
// => 선택적으로 오버라이딩 가능
// => 의무구현 메서드(i,l)는 추상메서드로 두고, 선택적 구현메서드 들은 미리 구현해놓음
//    그러므로 구현 클래스들의 의무구현 코드를 줄여줌
abstract class BoardA implements Boardi {
	@Override
	public void replyInsert() {}
	@Override
	public void delete() {}
	@Override
	public void update() {}
	@Override
	public void detail() {}
}

class QnABoard implements Boardi {
	@Override
	public void insert() { System.out.println("** QnA Insert **"); }
	@Override
	public void listPrint() { System.out.println("** QnA List **"); }
	@Override
	public void replyInsert() { System.out.println("** QnA replyInsert **"); }
	@Override
	public void delete() {}
	@Override
	public void update() {}
	@Override
	public void detail() {}
} //QnABoard

// => 추상 클래스를 상속 받도록 하여 의무를 줄여줌 
class QnABoard2 extends BoardA {
	@Override
	public void insert() { System.out.println("** QnA2 Insert **"); }
	@Override
	public void listPrint() { System.out.println("** QnA2 List **"); }
	@Override
	public void replyInsert() { System.out.println("** QnA2 replyInsert **"); }
} //QnABoard2

class MyBoard extends BoardA {
	@Override
	public void insert() { System.out.println("** MyBoard Insert **"); }
	@Override
	public void listPrint() { System.out.println("** MyBoard List **"); }
}

public class Ex05_AbsInter {

	public static void main(String[] args) {
		Boardi board = new QnABoard(); 
		// Boardi 의 후손들은 모두 가능 
		// => MyBoard, QnABoard2, QnABoard
		board.delete();
		board.detail();
		board.insert();
		board.listPrint();
		board.replyInsert();
		board.update();
		
		BoardA ba = new MyBoard(); 
		// => QnABoard는 implements Boardi -> BoardA 와는 무관 
		// => 그러나 BoardA를 상속받은 MyBoard, QnABoard2 는 모두 가능 
		ba.delete();
		ba.detail();
		ba.insert();
		ba.listPrint();
		ba.replyInsert();
		ba.update();

	} //main

} //class
