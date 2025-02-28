package edu.matc.entjava.entity;

/**
 * A class to represent a user.
 * @author ptaylor
 */
public class User {
    private int id;
    private String username;
    private String password;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Gets the user id.
     * @return user id
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the user id.
     * @param id user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username.
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Sets the username.
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets the password.
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
