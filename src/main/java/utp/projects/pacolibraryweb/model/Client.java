package utp.projects.pacolibraryweb.model;

/**
 * Represents a client in the system.
 */
public class Client {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String password;
    private String email;

    /**
     * Constructs a Client object with the specified details.
     *
     * @param id            the client ID
     * @param firstName     the first name of the client
     * @param middleName    the middle name of the client
     * @param lastName      the last name of the client
     * @param secondLastName the second last name of the client
     * @param password      the password of the client
     * @param email         the email address of the client
     */
    public Client(int id, String firstName, String middleName, String lastName, String secondLastName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.password = password;
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
     * Returns the middle name of the client.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name of the client.
     *
     * @param middleName the middle name to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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
     * Returns the second last name of the client.
     *
     * @return the second last name
     */
    public String getSecondLastName() {
        return secondLastName;
    }

    /**
     * Sets the second last name of the client.
     *
     * @param secondLastName the second last name to set
     */
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    /**
     * Returns the password of the client.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the client.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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