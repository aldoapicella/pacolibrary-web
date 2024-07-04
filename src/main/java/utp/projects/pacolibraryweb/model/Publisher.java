package utp.projects.pacolibraryweb.model;

/**
 * Represents an publisher in the library system.
 */
public class Publisher {
    private int id;
    private String name;

    /**
     * Constructs a publisher object with the specified details.
     *
     * @param id the publisher ID
     * @param name the name of the publisher
     */
    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the ID of the publisher.
     *
     * @return the publisher ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the publisher.
     *
     * @param id the publisher ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the publisher.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the publisher.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
