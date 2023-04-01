package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends JFrame {
    private JButton bookButton;
    private JButton userButton;
    private JButton recordButton;
    private JButton allAvailableBooksButton;
    private JButton findBookInformationButton;
    private JPanel mainPanel;
    private JLabel label1;
    private JLabel label2;


    public mainMenu() {
        setContentPane(mainPanel);
        setTitle("Main Menu");
        setSize(800,500);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                bookEntryForm b = new bookEntryForm();
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                newUserEntryForm u = new newUserEntryForm();
            }
        });

        recordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RecordEntryForm r = new RecordEntryForm();
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
