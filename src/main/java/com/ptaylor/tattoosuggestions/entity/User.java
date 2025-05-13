package com.ptaylor.tattoosuggestions.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class to represent a user in the system.
 * This class maps to the "users" table in the tattoo database which contains
 * information about the username, and can modify and return all suggestions
 * associated with the given style.
 * @author ptaylor
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name = "username", nullable = false)
    private String username;

    @Column (name = "is_admin", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isAdmin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Suggestion> suggestions = new ArrayList<>();

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Constructor to initialize the fields.
     */
    public User(String username) {
        this();
        this.username = username;
    }

    /**
     * Gets the user id.
     * @return user id
     */
    @Override
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
     * Gets the current authorization of
     * the user.
     * @return isAdmin
     */
    public boolean isAdmin() { return isAdmin; }
    /**
     * Sets the admin authorization.
     * @param isAdmin admin authorization
     */
    public void setAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }

    /**
     * Gets all suggestions for a given user.
     * @return all suggestions for a given user
     */
    public List<Suggestion> getSuggestions() {
        return suggestions;
    }
    /**
     * Sets the suggestions for a user.
     * @param suggestions all suggestions for a given user
     */
    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }
    /**
     * Adds a single suggestion for the user.
     * @param suggestion suggestion object
     */
    public void addSuggestion(Suggestion suggestion) {
        suggestions.add(suggestion);
        suggestion.setUser(this);
    }
    /**
     * Removes a single suggestion for the user.
     * @param suggestion suggestion object
     */
    public void removeSuggestion(Suggestion suggestion) {
        suggestions.remove(suggestion);
        suggestion.setUser(null);
    }

    /**
     * Converts object data into a string.
     * @return string containing object data
     */
    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', suggestions=" + suggestions.size() + "}";
    }

    /**
     * Checks to see if object values match.
     * @param o object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username);
    }

    /**
     * Generates hash code based on object values.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
