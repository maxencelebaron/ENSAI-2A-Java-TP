package fr.ensai.library;

public class Student {
    private String name;
    private int age;
    private int academicYear;
    private boolean isClassDelegate;

    // Constructor
    public Student(String name, int age, int academicYear, boolean isClassDelegate) {
        this.name = name;
        this.age = age;
        this.academicYear = academicYear;
        this.isClassDelegate = false;
    }
}
