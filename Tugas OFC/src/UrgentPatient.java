
public class UrgentPatient {
	String name, blood_type;
	int age, weight;
	
	public UrgentPatient() {
		System.out.println("Input data success!");
	}

	public UrgentPatient(String name, int age, int weight, String blood_type) {
		super();
		this.name = name;
		this.blood_type = blood_type;
		this.age = age;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlood_type() {
		return blood_type;
	}

	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
