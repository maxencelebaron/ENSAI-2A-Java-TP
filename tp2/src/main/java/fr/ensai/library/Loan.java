package fr.ensai.library;

import java.util.Date;

public class Loan {
    private Student student;
    private Item item;
    private Date startDate;
    private Date returnDate;

    // Constructor
    public Student(Student student, Item item, Date startDate, Date returnDate) {
        this.student = student;
        this.item = item;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }
}
