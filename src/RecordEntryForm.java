import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordEntryForm extends JFrame{
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
                    String
                }
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
