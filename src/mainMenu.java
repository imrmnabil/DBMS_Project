import javax.swing.*;

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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
