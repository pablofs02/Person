package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pablo Fernández Serrano
 */

public class PersonTest {
	@Test
	void test1() {
		Person person = new Person("Pablo", 20, "male");
		assertEquals(1,1);
	}

	@Test
	void test2() {
		Person person = new Person("María", 21, "female");
		assertEquals(1,1);
	}
}
