package org.example;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        SQLFileReader sqlFileReader = new SQLFileReader();

        try(Statement stm = Database.getInstance().getConnection().createStatement()) {
            stm.execute(sqlFileReader.readSQLFile("SQL/init_db.sql"));
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }
}