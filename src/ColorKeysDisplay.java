import javax.swing.JFrame;

import java.awt.Dimension;

import net.miginfocom.swing.*;

public class Display extends JFrame {

    public static void initialize() {

        JFrame frame = new JFrame("Color Keys - Demo");
        frame.setMinimumSize(new Dimension(960, 540));
        frame.setMaximumSize(new Dimension(1920, 1080));
        frame.setPreferredSize(new Dimension(1280, 720));
        frame.setLayout(new MigLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
