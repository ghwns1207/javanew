package j01_class;

public class Ex02_Person {
	// 멤버 변수
	private String name;
	private String phone;
	private int age;

	// 생성자

	public Ex02_Person(String name , String phone  ,int age) {
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	//디폴트 생성자 
	public Ex02_Person() { }
	

	// get/set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// toString()
	@Override
	public String toString() { // 오브젝트 상속 받음
		return "Ex02_Person [name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}

}// class
