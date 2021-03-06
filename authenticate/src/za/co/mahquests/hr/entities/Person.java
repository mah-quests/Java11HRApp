package za.co.mahquests.hr.entities;

import java.util.regex.Pattern;

public abstract class Person {
    private String fullNames;
    private String IDNumber;
    private int age;

    public Person(String fullNames, String IDNumber, int age) {
        this.fullNames = fullNames;
        this.IDNumber = IDNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person\n" +
                "{" +
                "    Full Names = " + fullNames + ",\n" +
                "    ID Number = " + IDNumber + ",\n" +
                "    Age = " + age + ",";

    }

    public String getFullNames() {
        return fullNames;
    }
    public String getIDNumber() {
        return IDNumber;
    }
    public int getAge() {
        return age;
    }

}
