package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import query.qAvailableBooks;

public class mainMenu extends JFrame {
    private JButton bookButton;
    private JButton userButton;
    private JButton recordButton;
    private JButton allAvailableBooksButton;
    private JButton findReaderInformationButton;
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

        allAvailableBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    qAvailableBooks q = new qAvailableBooks();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        findReaderInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                qReaderInfoForm q = new qReaderInfoForm();
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
