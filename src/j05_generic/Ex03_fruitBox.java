package j05_generic;

//** Generic Class Test 
//** FruitBox 만들기
//=> Apple, Banana 등 모든 과일을 담을수 있는 Generic FruitBox class 를 만들어 보세요.
//   단 과일들만 담을 수 있어야 함.
//   ( 자율적으로 해보시면 됩니다. )
//   힌트: Apple, Banana 등 각종 과일들이 class 이고, 
//   이들은 과일(Fruit) 로 구분 될 수 있어야함.   

//=> 실습
//-> 1) Fruit 만들기
//-> 2) 과일 클래스들 만들기 (3개)
//-> 3) FruitBox 만들기 : 과일들담기_setter, 과일들출력메서드_fruitPrint()
//-> 4) main 완성하기

class Fruit {
	public String toString() {
		return "i am Fruit";
	}
}

class Apple extends Fruit {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "i am Apple";
	}
}

class Banana extends Fruit{
	
	public String toString() {
	return "i am Banana";
	}
}

class Orange extends Fruit{
	private String color; 
	Orange(String color){
		this.color = color;
	}
	
	public String toString() {
		return "i am " + color + "Orange";
		}
}

class  Tomato {
	public String toString() {
	return "i am Tomato";
	}
}

// ** 과일들만 담을 수 있는 FruitBox 만들기
// => Fruit Type 이 될 수 있는 객체들은 모두 허용
// Fruit 의 후손들만 사용가능 하도록 Generic Type 제한 
// => Generic 으로 Fruit 의 후손들만 담을 수 있는 배열에 set & printFruit Type 이 될 수 있는 

class FruitBox<T extends Fruit> {

	private T[] fruit;

	public void setFruit(T[] fruit) {
		this.fruit = fruit;
	}

	public void fruitPrint() {
		for(T f:fruit ) {
			System.out.println(f);
		}
	}

}

public class Ex03_fruitBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1.FruitBox
		FruitBox<Fruit> f1 = new FruitBox<Fruit>();
		Fruit[] fa = {new Apple() , new Banana() , new Orange("노랑") , new Fruit()}; // 토마토는 오류 Fruit 상속 못받음 
		f1.setFruit(fa);
		f1.fruitPrint();
		
		// 2.OrangeBox
		FruitBox<Orange> or = new FruitBox<Orange>();
		Orange[] ora = { new Orange("빨") ,new Orange("주 "), new Orange("노"), new Orange("초") };
		or.setFruit(ora);
		or.fruitPrint();
		
		
	}//main

}// class
