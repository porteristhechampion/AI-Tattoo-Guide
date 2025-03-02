package edu.matc.entjava.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a suggestion.
 * @author ptaylor
 */
@Entity
@Table(name = "suggestions")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name = "suggestion", nullable = false)
    private String suggestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column (name = "style_id", nullable = false)
    private int styleId;

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
    public Suggestion(String suggestion, User user, int styleId, LocalDateTime createdAt) {
        this.suggestion = suggestion;
        this.user = user;
        this.styleId = styleId;
        this.createdAt = createdAt;
    }

    /**
     * Gets suggestion id.
     * @return suggestion id
     */
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
     * Gets the style id.
     * @return style id
     */
    public int getStyleId() {
        return styleId;
    }
    /**
     * Sets the style id.
     * @param styleId style id
     */
    public void setStyleId(int styleId) {
        this.styleId = styleId;
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
}
