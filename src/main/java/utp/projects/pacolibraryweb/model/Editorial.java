package utp.projects.pacolibraryweb.model;

/**
 * Represents an editorial in the library system.
 */
public class Editorial {
    private int id;
    private String name;

    /**
     * Constructs an Editorial object with the specified details.
     *
     * @param id the editorial ID
     * @param name the name of the editorial
     */
    public Editorial(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the ID of the editorial.
     *
     * @return the editorial ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the editorial.
     *
     * @param id the editorial ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the editorial.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the editorial.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
