package edu.matc.entjava.entity;

/**
 * A class to represent a user.
 * @author ptaylor
 */
public class Style {
    private int id;
    private String style;

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
}
