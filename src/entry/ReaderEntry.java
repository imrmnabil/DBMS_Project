package entry;

import java.sql.*;

public class ReaderEntry {
    private Connection conn;

    public ReaderEntry(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void insertReader(String reader_id, String vehicle_id, String reader_name, String email, int age, String membership_status) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO reader (reader_id, vehicle_id, reader_name, email, age, membership_status) " +
                        "VALUES (?, ?, ?, ?, ?, ?)"
        );

        stmt.setString(1, reader_id);
        stmt.setString(2, vehicle_id);
        stmt.setString(3, reader_name);
        stmt.setString(4, email);
        stmt.setInt(5, age);
        stmt.setString(6, membership_status);

        int rows = stmt.executeUpdate();
        System.out.println(rows + " row(s) inserted");

        stmt.close();
    }

    public void close() throws SQLException {
        conn.close();
    }
}