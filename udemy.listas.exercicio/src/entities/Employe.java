package entities;

public class Employe {

	private String Name;
	private Integer Id;
	private Double Salary;

	public Employe(String name, Integer id, Double salary) {

		Name = name;
		Id = id;
		Salary = salary;
	}

	public void increaseSalary(double percentage) {

		double increase = Salary * percentage / 100;
		Salary += increase;

	}

	public String getName() {
		return Name;
	}

	public Integer getId() {
		return Id;
	}

	public Double getSalary() {
		return Salary;
	}

	@Override
	public String toString() {

		String s = this.Id + ", " + this.Name + ", " + this.Salary;
		return s;
	}

}
