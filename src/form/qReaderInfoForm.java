package form;

import query.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class qReaderInfoForm extends JFrame{
    String url = "jdbc:mysql://localhost:3306/BSK_Test";
    String username = "root";
    String password = "200227N.msql";
    private JTextField rIDField;
    private JButton findButton;
    private JButton backButton;
    private JPanel qReaderPanel;

    public qReaderInfoForm() {
        setContentPane(qReaderPanel);
        setSize(800,500);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String reader_id = rIDField.getText();
                    qReaderInfo qReaderInfo = new qReaderInfo(url, username, password);
                    qReaderInfo.queryReaderID(reader_id);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainMenu m = new mainMenu();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
