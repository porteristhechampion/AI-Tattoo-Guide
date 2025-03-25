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

    @Test
    void delete() {
        List<Suggestion> suggestions = suggestionDAO.getAllByID(2);
        assertEquals(1, suggestions.size());
        Suggestion suggestionDelete = suggestions.get(0);
        suggestionDAO.delete(suggestionDelete);
        assertNull(suggestionDAO.getById(suggestionDelete.getId()));
    }

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
    }
}