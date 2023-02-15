package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pablo Fernández Serrano
 */

public class PersonTest {

	@Test
	void goodNameGetters() {
		 String obtainedValue = new Person("González", 11, "male").name();
		 String expectedValue = new String("González");
		 assertEquals(expectedValue, obtainedValue);
	}

	@Test
	void noExceptions() {
		assertDoesNotThrow(() -> new Person("María", 21, "Female"));
		assertDoesNotThrow(() -> new Person("juan", 15, "maLe"));
		assertDoesNotThrow(() -> new Person("Pepe", 22, "MALE"));
	}

	@Test
	void emptyName() {
		assertThrows(RuntimeException.class, () ->
				new Person("", 20, "male"),
				"Name cannot be empty.");
	}

	@Test
	void badAge() {
		assertThrows(RuntimeException.class, () ->
				new Person("Juan", -40, "male"),
				"Age cannot be negative.");
	}

	@Test
	void unknownGender() {
		assertThrows(RuntimeException.class, () ->
						new Person("Juan", 50, "malee"),
				"Gender unknown.");
	}

	@Test
	void noFemale() {
		List<Person> l = new ArrayList<Person>();
		l.add(new Person("a",2,"male"));
		l.add(new Person("b",8,"male"));
		l.add(new Person("c",4,"male"));
		double obtainedValueMale = Person.averageAgePerGender(l)[0];
		double obtainedValueFemale = Person.averageAgePerGender(l)[1];
		double expectedValueMale = 4.66666667;
		double expectedValueFemale = 0;
		assertEquals(expectedValueMale, obtainedValueMale, 0.001);
		assertEquals(expectedValueFemale, obtainedValueFemale, 0.001);
	}

	@Test
	void noMale() {
		List<Person> l = new ArrayList<Person>();
		l.add(new Person("a",2,"female"));
		l.add(new Person("b",8,"female"));
		l.add(new Person("c",4,"female"));
		double obtainedValueMale = Person.averageAgePerGender(l)[0];
		double obtainedValueFemale = Person.averageAgePerGender(l)[1];
		double expectedValueMale = 0;
		double expectedValueFemale = 4.66666667;
		assertEquals(expectedValueMale, obtainedValueMale, 0.001);
		assertEquals(expectedValueFemale, obtainedValueFemale, 0.001);
	}

	@Test
	void mixGender() {
		List<Person> l = new ArrayList<Person>();
		l.add(new Person("a",3,"male"));
		l.add(new Person("b",47,"female"));
		l.add(new Person("c",32,"male"));
		l.add(new Person("d",11,"female"));
		l.add(new Person("e",13,"female"));
		double obtainedValueMale = Person.averageAgePerGender(l)[0];
		double obtainedValueFemale = Person.averageAgePerGender(l)[1];
		double expectedValueMale = 17.5;
		double expectedValueFemale = 23.66666667;
		assertEquals(expectedValueMale, obtainedValueMale, 0.001);
		assertEquals(expectedValueFemale, obtainedValueFemale, 0.001);
	}


	@Test
	void bigAgeValues() {
		List<Person> l = new ArrayList<Person>();
		l.add(new Person("a",915349731,"male"));
		l.add(new Person("b",851974505,"male"));
		l.add(new Person("c",415496151,"male"));
		double obtainedValueMale = Person.averageAgePerGender(l)[0];
		double obtainedValueFemale = Person.averageAgePerGender(l)[1];
		double expectedValueMale = 727606795.7;
		double expectedValueFemale = 0;
		assertEquals(expectedValueMale, obtainedValueMale, 0.1);
		assertEquals(expectedValueFemale, obtainedValueFemale, 0.1);
	}

	@Test
	void zeroAgeValues() {
		List<Person> l = new ArrayList<Person>();
		l.add(new Person("a",0,"male"));
		l.add(new Person("b",0,"male"));
		l.add(new Person("c",0,"female"));
		double obtainedValueMale = Person.averageAgePerGender(l)[0];
		double obtainedValueFemale = Person.averageAgePerGender(l)[1];
		double expectedValueMale = 0;
		double expectedValueFemale = 0;
		assertEquals(expectedValueMale, obtainedValueMale, 0.001);
		assertEquals(expectedValueFemale, obtainedValueFemale, 0.001);
	}
}
