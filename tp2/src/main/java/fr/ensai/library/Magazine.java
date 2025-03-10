package fr.ensai.library;

public class Magazine extends Item {
    // Attributes
    private String issn;
    private String issueNumber;

    /**
     * Constructs a new Book object.
     */
    public Magazine(String issn, String issueNumber, String title, int year, int pageCount) {
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    public String toString(){
        return "Magazine" + this.title;
    }
}
