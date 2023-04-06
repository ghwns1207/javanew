package jdbc02;

//** VO (Value Object) , DTO (Data Transfer Object)
//=> 자료의 구조를 표현하는 클래스이며, 자료의 전달에 이용됨
//=> 대부분 Table 별로 만들며, Table 과 동일한 필드명을 사용한다.
//=> Table과 무관하게 자료전달용으로만 정의한 경우 DTO 라 함.

//=> 맴버변수 : private
//=> 외부에서는 setter/getter 로 접근


public class StudentVO {

	private int sno;
	private String name;
	private int age;
	private int jno;
	private String info;
	private Double point;
	private String birthday;
	private String now;
	public int getSno() {
		return sno;
	}
	// ** setter/getter
	
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}

	// ** tosting()
	@Override
	public String toString() {
		return "StudentVO [sno=" + sno + ", name=" + name + ", age=" + age + ", jno=" + jno + ", info=" + info
				+ ", point=" + point + ", birthday=" + birthday + ", now=" + now + "]";
	}
	
}//class
