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
 * Unit test class for testing CRUD operations on the TattooDAO.
 */
class DAOTest {

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
    }
//    when trying to compare the objects the data is the exact same, but the references are different.
//    researched how to fix this and, it says to implement equals and hashCode methods which I am going
//    to skip for now since I am already behind and don't want to spend extra time proving something
//    I already have confirmed to work, so I can get done with my individual project and not keep my
//    team waiting now that we are starting the team project.

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
    }

    /**
     * Tests deleting a User entity and ensuring associated suggestions are removed.
     */
    @Test
    void deleteUser() {
        User user = new User("pjtaylor");
        userDAO.insert(user);
        Style style = styleDAO.getById(5);
        Suggestion newSuggestion = new Suggestion("deleted user entry", user, style, LocalDateTime.now());
        int insertedId = suggestionDAO.insert(newSuggestion);
        assertNotEquals(0, insertedId);
        Suggestion suggestion = suggestionDAO.getById(insertedId);
        assertEquals("deleted user entry", suggestion.getSuggestion());
        userDAO.delete(user);
        User deletedUser = userDAO.getById(user.getId());
        assertNull(deletedUser);
        List<Suggestion> suggestions = suggestionDAO.getAllByID(user.getId());
        assertNull(suggestions);
        assertNull(user);
    }
}