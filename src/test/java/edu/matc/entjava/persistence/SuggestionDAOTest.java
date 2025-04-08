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

/**
 * Unit test class for testing CRUD operations for the Suggestion entity
 * in the DAO.
 */
public class SuggestionDAOTest {

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
     * Tests retrieval of a Suggestion entity by its ID.
     */
    @Test
    void getById() {
        Suggestion suggestionRetrieved = suggestionDAO.getById(1);
        assertNotNull(suggestionRetrieved);
        assertEquals(1, suggestionRetrieved.getId());
    }

    /**
     * Tests retrieval of all Suggestion entities associated with a specific user ID.
     */
    @Test
    void getAllByUser() {
        List<Suggestion> suggestions = suggestionDAO.getAllByID(1);
        assertEquals(4, suggestions.size());
    }

    /**
     * Tests updating an existing Suggestion entity.
     */
    @Test
    void update() {
        Suggestion suggestionUpdate = suggestionDAO.getById(2);
        suggestionUpdate.setSuggestion("test");
        suggestionDAO.update(suggestionUpdate);
        Suggestion suggestion = suggestionDAO.getById(2);
        assertEquals("test", suggestion.getSuggestion());
    }

    /**
     * Tests inserting a new Suggestion entity.
     */
    @Test
    void insert() {
        User user = userDAO.getById(2);
        Style style = styleDAO.getById(1);
        Suggestion newSuggestion = new Suggestion("testing", user, style, LocalDateTime.now());
        int insertedId = suggestionDAO.insert(newSuggestion);
        assertNotEquals(0, insertedId);
        Suggestion suggestion = suggestionDAO.getById(insertedId);
        assertEquals("testing", suggestion.getSuggestion());
        assertEquals(2, suggestion.getUser().getId());
        assertEquals(1, suggestion.getStyle().getId());
    }

    /**
     * Tests deleting a Suggestion entity.
     */
    @Test
    void delete() {
        List<Suggestion> suggestions = suggestionDAO.getAllByID(2);
        assertEquals(1, suggestions.size());
        Suggestion suggestionDelete = suggestions.get(0);
        suggestionDAO.delete(suggestionDelete);
        assertNull(suggestionDAO.getById(suggestionDelete.getId()));
        User user = userDAO.getById(2);
        assertNotNull(user);
    }

}