package utp.projects.pacolibraryweb.model;

/**
 * Represents a book in the library system.
 */
public class Book {
    private String isbn;
    private String title;
    private double price;
    private Author author;
    private Publisher publisher;

    /**
     * Constructs a Book object with the specified details.
     *
     * @param isbn      the ISBN of the book
     * @param title     the title of the book
     * @param price     the price of the book
     * @param author    the author of the book
     * @param publisher the publisher of the book
     */
    public Book(String isbn, String title, double price, Author author, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn the ISBN to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the price of the book.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Returns the publisher of the book.
     *
     * @return the publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the book.
     *
     * @param publisher the publisher to set
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
