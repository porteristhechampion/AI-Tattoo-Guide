package edu.matc.entjava.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a style in the system.
 * This class maps to the "styles" table in the tattoo database which contains
 * information about the style design, and can modify and return all suggestions
 * associated with the given style.
 * @author ptaylor
 */
@Entity
@Table(name="styles")
public class Style extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name = "style", nullable = false)
    private String style;

    @OneToMany(mappedBy = "style", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Suggestion> suggestions = new ArrayList<>();

    /**
     * Instantiates a new style.
     */
    public Style() {
    }

    /**
     * Constructor to initialize the fields.
     */
    public Style(String style) {
        this();
        this.style = style;
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
     * Gets the style name.
     * @return style name
     */
    public String getStyle() {
        return style;
    }
    /**
     * Sets the style name.
     * @param style style name
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Returns list of associated suggestions.
     * @return list of suggestions
     */
    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    /**
     * Sets list of associated suggestions.
     * @param suggestions list of suggestions
     */
    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    /**
     * Adds a suggestion to list of associated suggestions.
     * @param suggestion an associated suggestion
     */
    public void addSuggestion(Suggestion suggestion) {
        suggestions.add(suggestion);
        suggestion.setStyle(this);
    }

    /**
     * Removes a suggestion from list of associated suggestions.
     * @param suggestion an associated suggestion
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
        return "User{id=" + id + ", style='" + style + "', suggestions=" + suggestions.size() + "}";
    }
}
