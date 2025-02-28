package edu.matc.entjava.entity;

import java.time.LocalDateTime;

/**
 * A class to represent a suggestion.
 * @author ptaylor
 */
public class Suggestion {
    private int id;
    private String suggestion;
    private int userId;
    private int styleId;
    private LocalDateTime createdAt;

    /**
     * Instantiates a new suggestion.
     */
    public Suggestion() {
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
     * Gets the user id.
     * @return user id
     */
    public int getUserId() {
        return userId;
    }
    /**
     * Sets the user id.
     * @param userId user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
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
