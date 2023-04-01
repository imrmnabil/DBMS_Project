import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RecordEntryForm extends JFrame{

    String url = "jdbc:mysql://localhost:3306/BSK_Test";
    String username = "root";
    String password = "200227N.msql";
    private JTextField readerIDField;
    private JTextField bookIDField;
    private JTextField borrowDateField;
    private JTextField borrowStatusField;
    private JTextField returnDateField;
    private JTextField recordNumberField;
    private JLabel readerIDLabel;
    private JLabel bookIDLabel;
    private JLabel borrowDateLabel;
    private JLabel borrowStatusLabel;
    private JLabel returnDateLabel;
    private JLabel recordNumberLabel;
    private JButton submitButton;
    private JButton backButton;
    private JPanel recordPanel;

    public RecordEntryForm() {
        setContentPane(recordPanel);
        setSize(800,500);
        setTitle("Record Entry");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainMenu m = new mainMenu();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String record_number = recordNumberField.getText();
                    String return_date = returnDateField.getText();
                    String borrow_status = borrowStatusField.getText();
                    String borrow_date = borrowDateField.getText();
                    String book_id = bookIDField.getText();
                    String reader_id = readerIDField.getText();
                    RecordEntry recordEntry = new RecordEntry(url, username, password);
                    recordEntry.insertRecord(record_number, return_date, borrow_status, borrow_date, book_id,reader_id);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
