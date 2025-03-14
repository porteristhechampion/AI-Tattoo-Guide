package edu.matc.entjava.persistence;

import edu.matc.entjava.entity.Style;
import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.entity.User;
import edu.matc.entjava.util.Database;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SuggestionDAOTest {

    TattooDAO<Suggestion> suggestionDAO;
    TattooDAO<User> userDAO;
    TattooDAO<Style> styleDAO;

    @BeforeEach
    void setUp() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        userDAO = new TattooDAO<>(User.class);
        styleDAO = new TattooDAO<>(Style.class);
        Database db = new Database();
        db.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        Suggestion suggestionRetrieved = suggestionDAO.getById(1);
        assertNotNull(suggestionRetrieved);
        assertEquals(1, suggestionRetrieved.getId());
    }

    @Test
    void getAllByUser() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        List<Suggestion> suggestions = suggestionDAO.getAllByID(1);
        assertEquals(4, suggestions.size());
    }

    @Test
    void update() {
        Suggestion suggestionUpdate = suggestionDAO.getById(2);
        suggestionUpdate.setSuggestion("test");
        suggestionDAO.update(suggestionUpdate);
        Suggestion suggestion = suggestionDAO.getById(2);
        assertEquals("test", suggestion.getSuggestion());
    }


    @Test
    void insert() {
        User user = userDAO.getById(1);
        Style style = styleDAO.getById(1);
        Suggestion newSuggestion = new Suggestion("testing", user, style, LocalDateTime.now());
        int insertedId = suggestionDAO.insert(newSuggestion);
        assertNotEquals(0, insertedId);
        Suggestion suggestion = suggestionDAO.getById(insertedId);
        assertEquals("testing", suggestion.getSuggestion());
    }

    @Test
    void delete() {
        User user = new User();
        Suggestion suggestion = suggestionDAO.getById(11);
        suggestionDAO.delete(suggestion);
        assertNull(suggestionDAO.getById(11));
    }
}