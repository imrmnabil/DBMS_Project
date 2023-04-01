package query;

import java.sql.*;
import form.outAvailableBooks;

public class qAvailableBooks {
    private String url = "jdbc:mysql://localhost:3306/BSK_Test";
    private String username = "root";
    private String password = "200227N.msql";
    private Connection connection;
    public qAvailableBooks() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT(title) FROM book b, book_status bs, borrow_record br WHERE b.book_id = bs.book_id and bs.record_number = br.record_number and br.borrow_status = 0");
        ResultSet resultSet = statement.executeQuery();
        String[] title = new String[25];
        int i = 0;
        while(resultSet.next())
        {
            title[i] = resultSet.getString("title");
            System.out.println(title[i]);
            i++;
        }
        outAvailableBooks outAvailableBooks = new outAvailableBooks(title,i);
    }
}
