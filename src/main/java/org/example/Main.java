package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> l = new ArrayList<Person>();
        l.add(new Person("a",2,"male"));
        l.add(new Person("a",8,"male"));
        l.add(new Person("a",4,"female"));
        System.out.println(Person.averageAgePerGender(l)[0] + " : " + Person.averageAgePerGender(l)[1]);
    }
}