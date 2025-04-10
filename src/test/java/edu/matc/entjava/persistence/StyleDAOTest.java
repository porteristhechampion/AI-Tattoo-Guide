package edu.matc.entjava.persistence;

import edu.matc.entjava.entity.Style;
import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.entity.User;
import edu.matc.entjava.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class StyleDAOTest {

    TattooDAO<Suggestion> suggestionDAO;
    TattooDAO<User> userDAO;
    TattooDAO<Style> styleDAO;

    /**
     * Sets up the test environment by initializing DAO objects and resetting the database.
     */
    @BeforeEach
    void setUp() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        userDAO = new TattooDAO<>(User.class);
        styleDAO = new TattooDAO<>(Style.class);
        Database db = new Database();
        db.runSQL("cleanDB.sql");
    }

    /**
     * Tests retrieval of a Style entity by its ID.
     */
    @Test
    void getById() {
        Style styleRetrieved = styleDAO.getById(1);
        assertNotNull(styleRetrieved);
        assertEquals("Traditional", styleRetrieved.getStyle());
    }

    /**
     * Tests updating an existing Style entity.
     */
    @Test
    void update() {
        Style styleToUpdate = styleDAO.getById(11);
        styleToUpdate.setStyle("testUpdate");
        styleDAO.update(styleToUpdate);
        Style updatedStyle = styleDAO.getById(11);
        assertEquals("testUpdate", updatedStyle.getStyle());
    }

    /**
     * Tests inserting and deleting a Style entity and ensuring associated suggestions are
     * removed when deleted.
     */
    @Test
    void deleteStyle() {
        Style style = new Style("testStyle");
        styleDAO.insert(style);
        User user = userDAO.getById(2);
        Suggestion newSuggestion = new Suggestion("test style delete", user, style, LocalDateTime.now());
        int insertedId = suggestionDAO.insert(newSuggestion);
        assertNotEquals(0, insertedId);
        Suggestion suggestion = suggestionDAO.getById(insertedId);
        assertEquals("test style delete", suggestion.getSuggestion());
        styleDAO.delete(style);
        Style deletedStyle = styleDAO.getById(style.getId());
        assertNull(deletedStyle);
        assertNull(suggestionDAO.getById(insertedId));
    }

}
