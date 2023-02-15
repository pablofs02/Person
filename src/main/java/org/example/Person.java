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
		if (gender.toLowerCase().equals(new String("male")) || gender.toLowerCase().equals(new String("female")))
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
	 * @param persons
	 * @return
	 */

	public double[] averageAgePerGender (List<Person> persons) {
		return null;
	}
}
