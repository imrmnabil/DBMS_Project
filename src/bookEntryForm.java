import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class bookEntryForm extends JFrame{
    String url = "jdbc:mysql://localhost:3306/BSK_Test";
    String username = "root";
    String password = "200227N.msql";
    private JTextField bTitleField;
    private JTextField bAuthField;
    private JTextField yearField;
    private JTextField priceField;
    private JTextField bookIDField;
    private JTextField vIDFIeld;
    private JLabel bMainLabel;
    private JLabel btitileLabel;
    private JLabel bAuthLabel;
    private JLabel bAuth;
    private JLabel vehicleIDLabel;
    private JLabel bookIDLabel;
    private JLabel priceBDTLabel;
    private JButton backButton;
    private JButton submitButton;
    private JPanel bookEntryPanel;
    private JLabel genreLabel;
    private JTextField genreField;

    public bookEntryForm() {
        setContentPane(bookEntryPanel);
        setTitle("Book Entry");
        setSize(800,500);
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
                    String bId = bookIDField.getText();
                    String authID = bAuthField.getText();
                    String  gen = genreField.getText();
                    String title = bTitleField.getText();
                    int year = Integer.parseInt(yearField.getText());
                    double price = Double.parseDouble(priceField.getText());
                    String vID = vIDFIeld.getText();
                    BookEntry entry = new BookEntry(url, username, password);
                    entry.insertBook(bId, authID, gen, title, year,price,vID);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
