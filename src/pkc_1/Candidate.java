package pkc_1;

abstract class Candidate {
	String name;
	int age;

	public Candidate(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void display() {
		System.out.println("Name: " + name + " --- Age: " + age);
	}
}
