package fr.ensai.library;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                tolkien,
                "The Fellowship of the Ring",
                1954,
                423);

        System.out.println(fellowshipOfTheRing.toString());
        Library maxlib = new Library("MaxLib");
        Magazine maxmag = new Magazine("03177471", "1", "maxmag", 0, 0);
        Magazine pakomag = new Magazine("02025050", "5", "pakomag", 0, 0);
        maxlib.addItem(maxmag);
        maxlib.addItem(pakomag);
        maxlib.displayItems();
    }
}
