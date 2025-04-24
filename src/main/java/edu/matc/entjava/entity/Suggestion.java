package edu.matc.entjava.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A class to represent a suggestion in the system.
 * This class maps to the "suggestions" table in the tattoo database which contains
 * information about the suggestion text, the user who created it, its associated
 * style, and the creation time.
 * @author ptaylor
 */
@Entity
@Table(name = "suggestions")
public class Suggestion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name = "suggestion", nullable = false)
    private String suggestion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "style_id", nullable = false)
    private Style style;

    @Column (name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    /**
     * Instantiates a new suggestion.
     */
    public Suggestion() {
    }

    /**
     * Constructor to initialize the fields.
     */
    public Suggestion(String suggestion, User user, Style style, LocalDateTime createdAt) {
        this();
        this.suggestion = suggestion;
        this.user = user;
        this.style = style;
        this.createdAt = createdAt;
    }

    /**
     * Gets suggestion id.
     * @return suggestion id
     */
    @Override
    public int getId() {
        return id;
    }
    /**
     * Sets suggestion id.
     * @param id the suggestion id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the suggestion text.
     * @return given suggestion
     */
    public String getSuggestion() {
        return suggestion;
    }
    /**
     * Sets the suggestion text.
     * @param suggestion suggestion text
     */
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    /**
     * Gets the user object.
     * @return user object
     */
    public User getUser() {
        return user;
    }
    /**
     * Sets the user object.
     * @param user user object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the style object.
     * @return style object
     */
    public Style getStyle() {
        return style;
    }
    /**
     * Sets the style object.
     * @param style style object
     */
    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * Gets the time suggestion was created.
     * @return time created
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the time suggestion was created.
     * @param createdAt time created
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Converts object data into a string.
     * @return string containing object data
     */
    @Override
    public String toString() {
        return "Suggestion{id=" + id + ", suggestion='" + suggestion + "', user=" + user.getId() + "', style=" + style.getId() + ", created= " + createdAt + "}";
    }

    /**
     * Checks to see if object values match.
     * @param o object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Suggestion that = (Suggestion) o;
        return id == that.id && Objects.equals(suggestion, that.suggestion) && Objects.equals(user, that.user) && Objects.equals(style, that.style) && Objects.equals(createdAt, that.createdAt);
    }

    /**
     * Generates hash code based on object values.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, suggestion, user, style, createdAt);
    }
}
