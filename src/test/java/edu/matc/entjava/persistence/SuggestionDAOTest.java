package edu.matc.entjava.persistence;

import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.util.Database;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuggestionDAOTest {

    SuggestionDAO suggestionDAO;

    @BeforeEach
    void setUp() {
        Database db = new Database();
        db.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        suggestionDAO = new SuggestionDAO();
        Suggestion suggestionRetrieved = suggestionDAO.getById(1);
        assertNotNull(suggestionRetrieved);
    }

}