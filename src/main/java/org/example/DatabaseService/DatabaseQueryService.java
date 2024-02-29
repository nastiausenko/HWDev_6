package org.example.DatabaseService;

import org.example.Database;
import org.example.FileReader.SQLFileReader;
import org.example.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
        ResultSet rs = stm.executeQuery(sqlFileReader.readSQLFile("find_max_projects_client.sql"));
        while (rs.next()) {
            String name = rs.getString("name");
            int projectCount = rs.getInt("project_count");
            listMaxProjectCountClient.add(new MaxProjectCountClient(name, projectCount));
        }
        return listMaxProjectCountClient;
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject> listLongestProject = new ArrayList<>();
        ResultSet rs = stm.executeQuery(sqlFileReader.readSQLFile("find_longest_project.sql"));
        while (rs.next()) {
            int id = rs.getInt("project_id");
            int monthDiff = rs.getInt("month_diff");
            listLongestProject.add(new LongestProject(id, monthDiff));
        }
        return listLongestProject;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryWorker> listMaxSalaryWorker = new ArrayList<>();
        ResultSet rs = stm.executeQuery(sqlFileReader.readSQLFile("find_max_salary_worker.sql"));
        while (rs.next()) {
            String name = rs.getString("name");
            int salary = rs.getInt("salary");
            listMaxSalaryWorker.add(new MaxSalaryWorker(name, salary));
        }
        return listMaxSalaryWorker;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers> listYoungestEldestWorkers = new ArrayList<>();
        ResultSet rs = stm.executeQuery(sqlFileReader.readSQLFile("find_youngest_eldest_workers.sql"));
        while (rs.next()) {
            String type = rs.getString("TYPE");
            String name = rs.getString("name");
            LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
            listYoungestEldestWorkers.add(new YoungestEldestWorkers(type, name, birthday));
        }
        return listYoungestEldestWorkers;
    }

    public List<ProjectPrices> printProjectPrices() throws SQLException {
        List<ProjectPrices> listProjectPrices = new ArrayList<>();
        ResultSet rs = stm.executeQuery(sqlFileReader.readSQLFile("print_project_prices.sql"));
        while (rs.next()) {
            int id = rs.getInt("id");
            int price = rs.getInt("project_price");
            listProjectPrices.add(new ProjectPrices(id, price));
        }
        return listProjectPrices;
    }
}
