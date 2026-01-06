package com.iga.util;

import java.sql.*;

public class DbClient {
    private static final String JDBC_URL = "jdbc:h2:mem:target_sys;DB_CLOSE_DELAY=-1";

    public static void initDatabase() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, "sa", "")) {
            Statement stmt = conn.createStatement();
            // This creates the table that was "missing" in your error log
            stmt.execute(
                    "CREATE TABLE ACCOUNTS (EMP_ID VARCHAR(50) PRIMARY KEY, DEPT VARCHAR(50), STATUS VARCHAR(20))");
            System.out.println("[DB] Target System Initialized Successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, "sa", "");
    }
}