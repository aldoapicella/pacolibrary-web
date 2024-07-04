package utp.projects.pacolibraryweb.model;

/**
 * Represents an author in the library system.
 */
public class Author {
    private int id;
    private String fullName;

    /**
     * Constructs an Autor object with the specified details.
     *
     * @param id
     * @param fullName
     */
    public Author(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    /**
     * Returns the ID of the author.
     *
     * @return the author ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the author.
     *
     * @param id the author ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the full name of the author.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the author.
     *
     * @param fullName the full name to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
