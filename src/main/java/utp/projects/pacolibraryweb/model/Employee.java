package utp.projects.pacolibraryweb.model;

import java.util.Date;

/**
 * Represents an employee in the library system.
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private EmployePosition position;
    private String libraryCode;

    /**
     * Constructs an Employee object with the specified details.
     *
     * @param id            the employee ID
     * @param firstName     the first name of the employee
     * @param lastName      the last name of the employee
     * @param email         the email address of the employee
     * @param birthDate     the birth date of the employee
     * @param position      the position of the employee
     * @param libraryCode   the library code of the employee
     */
    public Employee(int id, String firstName, String lastName, String secondLastName, String email, Date birthDate, EmployePosition position, String libraryCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.position = position;
        this.libraryCode = libraryCode;
    }

    /**
     * Returns the ID of the employee.
     *
     * @return the employee ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the employee.
     *
     * @param id the employee ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the employee.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the employee.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the email address of the employee.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the employee.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the birth date of the employee.
     *
     * @return the birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the employee.
     *
     * @param birthDate the birth date to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Returns the position of the employee.
     *
     * @return the position
     */
    public EmployePosition getPosition() {
        return position;
    }

    /**
     * Sets the position of the employee.
     *
     * @param position the position to set
     */
    public void setPosition(EmployePosition position) {
        this.position = position;
    }

    /**
     * Returns the library code of the employee.
     *
     * @return the library code
     */
    public String getLibraryCode() {
        return libraryCode;
    }

    /**
     * Sets the library code of the employee.
     *
     * @param libraryCode the library code to set
     */
    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
    }
}
