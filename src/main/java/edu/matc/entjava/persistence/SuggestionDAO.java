package edu.matc.entjava.persistence;


import edu.matc.entjava.entity.Suggestion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuggestionDAO {

    private static final Logger logger = LogManager.getLogger(Database.class);

    private Database db;

    public Connection getConnected() throws Exception {
        db = Database.getInstance();
        db.connect();
        return db.getConnection();
    }

    public List<Suggestion> getSuggestionsByUserID(String userID) {
        List<Suggestion> suggestions = new ArrayList<>();
        Connection connection = null;
        String sql = "SELECT * FROM suggestions WHERE user_id=?";

        try {
            connection = getConnected();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();

        } catch (SQLException sqlException) {
            logger.error("SQL Exception: ", sqlException);
        } catch (Exception exception) {
            logger.error("Exception: ", exception);
        }

        return suggestions;
    }



}
