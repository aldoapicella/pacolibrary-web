package utp.projects.pacolibraryweb.model;

/**
 * Represents a client in the system.
 */
public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructs a Client object with the specified details.
     *
     * @param id            the client ID
     * @param firstName     the first name of the client
     * @param lastName      the last name of the client
     * @param email         the email address of the client
     */
    public Client(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Returns the ID of the client.
     *
     * @return the client ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the client.
     *
     * @param id the client ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the client.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the client.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the client.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the client.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the email address of the client.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the client.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}