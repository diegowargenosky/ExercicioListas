package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employe;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Employe> employes = new ArrayList<>();

		System.out.println("How many employes will be registered?:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Employe #" + (i + 1) + ":");
			System.out.print("Id:");
			int id = sc.nextInt();
			
			while(hasId(employes, id)) {
				System.out.println("This Id already exist! Try again:");
				id = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			Employe employe = new Employe(name, id, salary);
			employes.add(employe);

		}

		System.out.println("Enter the employee id that will have salary increase:");
		int idv = sc.nextInt();

		Employe employe = employes.stream().filter(x -> x.getId() == idv).findFirst().orElse(null);

		if (employe == null) {
			System.out.println("This Id does not exist!");
		} else {
			System.out.println("Enter the percentage:");
			double per = sc.nextDouble();
			employe.increaseSalary(per);
		}

		System.out.println("List of employes: " + "\n");

		for (Employe emp : employes) {

			System.out.println(emp);

		}

	}

	public static Boolean hasId(List<Employe> list, int id) {

		Employe emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		return emp!=null;
	}

}
