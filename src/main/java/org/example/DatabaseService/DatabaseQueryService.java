package org.example.DatabaseService;

import org.example.Database;
import org.example.FileReader.SQLFileReader;
import org.example.model.MaxProjectCountClient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private final SQLFileReader sqlFileReader = new SQLFileReader();
    private Statement stm;


    public DatabaseQueryService() {
        try {
            stm = Database.getInstance().getConnection().createStatement();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> listMaxProjectCountClient = new ArrayList<>();
        ResultSet rs = stm.executeQuery(sqlFileReader.readSQLFile("SQL/find_max_projects_client.sql"));
        while (rs.next()) {
            String name = rs.getString("name");
            int projectCount = rs.getInt("project_count");
            listMaxProjectCountClient.add(new MaxProjectCountClient(name, projectCount));
        }
        return listMaxProjectCountClient;
    }
}
