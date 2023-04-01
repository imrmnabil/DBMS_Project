import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class newUserEntryForm extends JFrame {
    String url = "jdbc:mysql://localhost:3306/BSK_Test";
    String username = "root";
    String password = "200227N.msql";
    private JTextField nameField;
    private JTextField emailField;
    private JTextField ageField;
    private JTextField mstField;
    private JTextField rIDField;
    private JLabel newUserRegistrationFormLabel;
    private JLabel nameLabel;
    private JButton backButton;
    private JButton submitButton;
    private JLabel emailLabel;
    private JLabel ageLabel;
    private JLabel membershipStatusLabel;
    private JLabel readerIDNoLabel;
    private JPanel userPanel;
    private JLabel vIDLabel;
    private JTextField vFIeld;

    public newUserEntryForm() {
        setContentPane(userPanel);
        setTitle("User Registration");
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
                    String name = nameField.getText();
                    String email = emailField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    String memst = mstField.getText();
                    String rid = rIDField.getText();
                    String vid = vFIeld.getText();
                    ReaderEntry readerEntry = new ReaderEntry(url,username,password);
                    readerEntry.insertReader(rid,vid, name, email, age, memst );
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
