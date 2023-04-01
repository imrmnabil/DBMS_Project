package form;

import javax.swing.*;

public class outReaderInfo extends JFrame{
    private JLabel nameLabel;
    private JLabel rIDLabel;
    private JLabel emailLabel;
    private JLabel ageLabel;
    private JLabel mstLabel;
    private JLabel vIDLabel;
    private JPanel outReaderInfoPanel;
    private JButton closeButton;

    public outReaderInfo(String readerId,String vehicleId,String readerName,String email, int age, String membershipStatus) {
        setContentPane(outReaderInfoPanel);
        setSize(500,800);
        setTitle("User Info");
        nameLabel.setText(readerName);
        rIDLabel.setText(readerId);
        emailLabel.setText(email);
        ageLabel.setText(String.valueOf(age));
        mstLabel.setText(membershipStatus);
        vIDLabel.setText(vehicleId);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
