package form;

import javax.swing.*;
import java.lang.reflect.Array;

public class outAvailableBooks {

    public outAvailableBooks(String[] title,int n) {
        JFrame frame = new JFrame("Available Book List");
        JList<String> list = new JList<>(title);
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
