package entry;

import java.sql.*;
public class RecordEntry {
    private Connection connection;

    public RecordEntry(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void insertRecord(String record_number, String return_date, String borrow_status, String borrow_date, String book_id, String reader_id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO borrow_record (record_number, return_date, borrow_status, borrow_date) " +
                        "VALUES (?, ?, ?, ?)"
        );

        stmt.setString(1, record_number);
        stmt.setString(2, return_date);
        stmt.setString(3, borrow_status);
        stmt.setString(4, borrow_date);

        int rows = stmt.executeUpdate();
        System.out.println(rows + " row(s) inserted");

        stmt.close();

        PreparedStatement stmt2 = connection.prepareStatement(
                "INSERT INTO borrowed_by (reader_id, record_number) " +
                        "VALUES (?, ?)"
        );

        stmt2.setString(1, reader_id);
        stmt2.setString(2, record_number);

        rows = stmt2.executeUpdate();
        System.out.println(rows + " row(s) inserted");

        stmt2.close();

        PreparedStatement stmt3 = connection.prepareStatement(
                "INSERT INTO book_status (book_id, record_number) " +
                        "VALUES (?, ?)"
        );

        stmt3.setString(1, book_id);
        stmt3.setString(2, record_number);

        rows = stmt3.executeUpdate();
        System.out.println(rows + " row(s) inserted");

        stmt3.close();
    }

    public void close() throws SQLException {
        connection.close();
    }
}
