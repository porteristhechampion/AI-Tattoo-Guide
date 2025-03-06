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
@Table(name="styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name = "style", nullable = false)
    private String style;

    @OneToMany(mappedBy = "style", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Suggestion> suggestions = new ArrayList<>();

    /**
     * Instantiates a new style.
     */
    public Style() {
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


    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public void addSuggestion(Suggestion suggestion) {
        suggestions.add(suggestion);
        suggestion.setStyle(this);
    }

    public void removeSuggestion(Suggestion suggestion) {
        suggestions.remove(suggestion);
        suggestion.setUser(null);
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", style='" + style + "', suggestions=" + suggestions.size() + "}";
    }
}
