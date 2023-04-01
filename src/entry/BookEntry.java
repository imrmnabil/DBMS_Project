package entry;

import java.sql.*;

public class BookEntry {
    private Connection conn;

    public BookEntry(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void insertBook(String book_id, String author_id, String genre, String title, int year, double price, String vehicle_id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO book (book_id, author_id, genre, title, year, price, vehicle_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setString(1, book_id);
        stmt.setString(2, author_id);
        stmt.setString(3, genre);
        stmt.setString(4, title);
        stmt.setInt(5, year);
        stmt.setDouble(6, price);
        stmt.setString(7, vehicle_id);

        int rows = stmt.executeUpdate();
        System.out.println(rows + " row(s) inserted");

        stmt.close();
    }

    public void close() throws SQLException {
        conn.close();
    }
}
