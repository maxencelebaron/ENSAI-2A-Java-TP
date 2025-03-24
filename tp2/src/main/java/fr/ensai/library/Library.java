package fr.ensai.library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    // Attributes
    private String name;
    private List<Item> items;
    private List<Loan> activeLoans;
    private List<Loan> completedLoans;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.activeLoans = new ArrayList<>();
        this.completedLoans = new ArrayList<>();
    }

    // Method
    public void addItem(Item item) {
        this.items.add(item);
    }

    public void displayItems(){
        if (this.items.isEmpty()){
            System.out.println("There is no item");
        }
        else{
            for (Item item: this.items){
                System.out.println(item);
            }
        }
    }
    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName, 0, "");
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(isbn, author, title, year, pageCount);

                    this.addItem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public Loan findActiveLoanForItem(Item item){
        if (activeLoans != null){
            for (Loan loan : this.activeLoans){
                if (loan.getItem().equals(item)){
                    return loan;
                }
            }
            return null;
        }
    }

    public List<Book> getBooksByAuthor(Author author){
        ArrayList<Book> result = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Book) { // Check if the item is a Book
                Book book = (Book) item; // Cast the item to a Book
                if (book.getAuthor().equals(author)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public boolean loanItem(Item item, Student student){

    }
}