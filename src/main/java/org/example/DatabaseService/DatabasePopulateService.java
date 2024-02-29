package org.example.DatabaseService;

import org.example.Database;
import org.example.FileReader.SQLFileReader;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        SQLFileReader sqlFileReader = new SQLFileReader();

        try(Statement stm = Database.getInstance().getConnection().createStatement()) {
            stm.execute(sqlFileReader.readSQLFile("populate_db.sql"));
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }
}
