package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pablo Fernández Serrano
 */

public class PersonTest {
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
}
