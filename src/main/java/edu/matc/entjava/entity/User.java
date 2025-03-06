package edu.matc.entjava.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a user.
 * @author ptaylor
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name = "username", nullable = false)
    private String username;

    @Column (name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Suggestion> suggestions = new ArrayList<>();

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


    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public void addSuggestion(Suggestion suggestion) {
        suggestions.add(suggestion);
        suggestion.setUser(this);
    }

    public void removeSuggestion(Suggestion suggestion) {
        suggestions.remove(suggestion);
        suggestion.setUser(null);
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', suggestions=" + suggestions.size() + "}";
    }

}
