package org.example;

import java.util.List;

/**
 * Class representing a person with a name, age and gender,
 *
 * @author Pablo Fernández Serrano
 */

public class Person {

	private final String name;

	private final int age;

	private final String gender; // Male, Female

	/**
	 * Constructs a person with a name, age and gender.
	 *
	 * @param name the name of the person
	 * @param age the age of the person
	 * @param gender the gender of the person
	 */

	public Person(String name, int age, String gender) {
		if (name.equals(new String(""))) throw new RuntimeException("Name cannot be empty.");
		if (age < 0) throw new RuntimeException("Age cannot be negative.");
		if (!gender.toLowerCase().equals(new String("female")) && !gender.toLowerCase().equals(new String("male")))
			throw new RuntimeException("Gender unknown.");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String name() {
		return name;
	}

	public int age() {
		return age;
	}

	public String gender() {
		return gender;
	}

	/**
	 * Computes the average age of male and female persons in a list and returns the result in
	 * an array of two elements (the first element is the male mean age and the second one is the * female mean age)
	 *
	 * @param persons list of persons to calculate their mean by their gender.
	 * @return double[2] where first element is average by male and the second is by female.
	 */

	public static double[] averageAgePerGender (List<Person> persons) {
		double agePerGender[] = {0,0};
		int maleCount = 0;
		int femaleCount = 0;
		for (Person person: persons) {
			if (person.gender().equals(new String("male"))) {
				maleCount++;
				agePerGender[0] += person.age();
			} else {
				femaleCount++;
				agePerGender[1] += person.age();
			}
		}
		if (maleCount != 0)
			agePerGender[0] /= maleCount;
		if (femaleCount != 0)
			agePerGender[1] /= femaleCount;;
		return agePerGender;
	}
}
