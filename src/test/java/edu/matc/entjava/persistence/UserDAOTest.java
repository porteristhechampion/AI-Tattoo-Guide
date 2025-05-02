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
 * Unit test class for testing CRUD operations for the User entity
 * in the DAO.
 */
public class UserDAOTest {

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
     * Tests retrieval of a User entity by its ID.
     */
    @Test
    void getById() {
        User userRetrieved = userDAO.getById(1);
        assertNotNull(userRetrieved);
        assertEquals(1, userRetrieved.getId());
    }

    /**
     * Tests retrieval of all User entities in the users table.
     */
    @Test
    void getAll() {
        List<User> users = userDAO.getAll();
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    /**
     * Tests updating an existing Suggestion entity.
     */
    @Test
    void update() {
        User userUpdate = userDAO.getById(2);
        userUpdate.setUsername("testUpdate");
        userDAO.update(userUpdate);
        User user = userDAO.getById(2);
        assertEquals("testUpdate", user.getUsername());
    }

    /**
     * Tests inserting and deleting a User entity and ensuring associated suggestions are
     * removed when deleted.
     */
    @Test
    void deleteUser() {
        User user = new User("pjtaylor");
        userDAO.insert(user);
        Style style = styleDAO.getById(5);
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        Suggestion newSuggestion = new Suggestion("deleted user entry", user, style, now);
        int insertedId = suggestionDAO.insert(newSuggestion);
        assertNotEquals(0, insertedId);
        Suggestion suggestion = suggestionDAO.getById(insertedId);
        assertEquals(newSuggestion, suggestion);
        userDAO.delete(user);
        User deletedUser = userDAO.getById(user.getId());
        assertNull(deletedUser);
        List<Suggestion> suggestions = user.getSuggestions();
        assertEquals(0, suggestions.size());
        assertNotNull(user);
    }
}
