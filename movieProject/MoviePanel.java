package movieProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoviePanel extends JPanel {

    private final Movie m;

    public MoviePanel(Movie m) {
        this.m = m;
        buildPanel();

    }


    private void buildPanel() {
        JButton goTri = new JButton();
        goTri.setBackground(Color.DARK_GRAY);
        goTri.setIcon(m.getImage());
        goTri.setPreferredSize(new Dimension(180, 300));

        setLayout(new BorderLayout());
        setBackground(Color.darkGray);

        goTri.addActionListener(new movieSelecte());
        add(goTri, BorderLayout.CENTER);
    }



    private class movieSelecte implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new movieFrame(m);

        }
    }
}
