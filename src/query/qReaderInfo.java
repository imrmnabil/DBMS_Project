package query;

import java.sql.*;
import form.outReaderInfo;

public class qReaderInfo {
    private Connection connection;
    public qReaderInfo(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void queryReaderID(String reader_id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT reader_id, vehicle_id, reader_name, email, age, membership_status FROM reader WHERE reader_id = ?");
        statement.setString(1, reader_id);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String readerId = resultSet.getString("reader_id");
            String vehicleId = resultSet.getString("vehicle_id");
            String readerName = resultSet.getString("reader_name");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            String membershipStatus = resultSet.getString("membership_status");
            outReaderInfo o = new outReaderInfo(readerId, vehicleId, readerName, email, age, membershipStatus);
            System.out.printf("%-12s %-8s %-30s %-50s %-3d %-10s\n", readerId, vehicleId, readerName, email, age, membershipStatus);
        }
        else {
            System.out.println("Data Not found!");
        }
        resultSet.close();
        statement.close();
    }

    public void close() throws SQLException {
        connection.close();
    }

}
