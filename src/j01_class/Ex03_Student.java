package j01_class;

public class Ex03_Student extends Ex02_Person {

	private String info;
	private int java, html, sum;
	
	public Ex03_Car car = new Ex03_Car();

	public Ex03_Student(String name , String phone ,String info,int age ,int java ,int html) {
		super(name, phone,age);
		this.info = info;
		this.java = java;
		this.html = html;
		this.sum = this.java + this.html;
	}
	
	public Ex03_Student(){ }
	

	public String getInfo() {
		return info;
	}

	public int getJava() {
		return java;
	}

	public int getHtml() {
		return html;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return super.toString() + "\nEx03_Student [info=" + info + ", java=" + java + ", html=" + html + ", sum=" + sum + "]\n";
	}
	
	

}
