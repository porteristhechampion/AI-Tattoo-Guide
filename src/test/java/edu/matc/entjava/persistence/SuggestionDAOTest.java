package edu.matc.entjava.persistence;

import edu.matc.entjava.entity.Style;
import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.entity.User;
import edu.matc.entjava.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
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
        User user = userDAO.getById(1);
        List<Suggestion> suggestions = user.getSuggestions();
        assertNotNull(suggestions);
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
        assertEquals(suggestionUpdate, suggestion);
    }

    /**
     * Tests inserting a new Suggestion entity.
     */
    @Test
    void insert() {
        User user = userDAO.getById(2);
        Style style = styleDAO.getById(1);
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        Suggestion newSuggestion = new Suggestion("testing", user, style, now);
        int insertedId = suggestionDAO.insert(newSuggestion);
        assertNotEquals(0, insertedId);
        Suggestion suggestion = suggestionDAO.getById(insertedId);
        assertEquals(newSuggestion, suggestion);
    }

    /**
     * Tests deleting a Suggestion entity.
     */
    @Test
    void deleteSuggestion() {
        User user = userDAO.getById(2);
        List<Suggestion> suggestions = user.getSuggestions();
        assertEquals(2, suggestions.size());
        Suggestion suggestionDelete = suggestions.get(0);
        Style style = suggestionDelete.getStyle();
        suggestionDAO.delete(suggestionDelete);
        assertNull(suggestionDAO.getById(suggestionDelete.getId()));
        assertNotNull(user);
        assertNotNull(style);
    }

    /**
     * Tests retrieving by a property.
     */
    @Test
    void getByPropertyLike() {
        List<User> users = userDAO.getByPropertyLike("username", "ptaylor");
        assertEquals(1, users.size());
        List<Suggestion> suggestions = suggestionDAO.getByPropertyLike("suggestion", "testing");
        assertEquals(2, suggestions.size());
        List<Style> styles = styleDAO.getByPropertyLike("style", "Blackwork");
        assertEquals(1, styles.size());
    }

}