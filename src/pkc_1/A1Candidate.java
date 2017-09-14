package pkc_1;

class A1Candidate extends Candidate{
	
	String country;
	String university;
	
	public A1Candidate(String name, int age, String country, String university) {
		super(name, age);
		this.country = country;
		this.university = university;
	}

	@Override
	void display() {
		super.display();
		System.out.println("Country: " + country + " --- University: " + university);
	}
	
}
