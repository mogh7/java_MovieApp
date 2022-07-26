package movieProject;

import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.util.Scanner;

public class movieFrame extends JFrame{

    private final Movie m;
    private JPanel imagePanel, atePanel;
    private JButton showTri, showMovie, likeMovie;

    public movieFrame(Movie m) throws HeadlessException {
        this.m = m;

        setTitle(m.getName());
        setSize(mainWindow.width, mainWindow.height);
        setLocationRelativeTo(null);
        setSize(new Dimension(mainWindow.width/2 + 200, 350));

        buildPanel();


        add(imagePanel, BorderLayout.WEST);
        add(atePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void buildPanel() {
        imagePanel = new JPanel();
        imagePanel.setBackground(Color.DARK_GRAY);

        JLabel holdImage = new JLabel(m.getImage());
        imagePanel.add(holdImage);

        JPanel movieNPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        movieNPanel.setBackground(Color.DARK_GRAY);
        JLabel nameL = new JLabel(m.getName());
        nameL.setFont(new Font("Serif", Font.BOLD, 34));
        movieNPanel.add(nameL);


        JPanel discPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        discPanel.setBackground(Color.DARK_GRAY);
        JTextArea discL = new JTextArea(m.getDisc(), 5, 25);
        discL.setEditable(false);
        discL.setBackground(Color.DARK_GRAY);
        discL.setForeground(Color.white);
        discL.setLineWrap(true);
        discL.setFont(new Font("Serif", Font.PLAIN, 24));
        discPanel.add(discL);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.DARK_GRAY);
        showMovie = new JButton("Go to movie");
        showMovie.setPreferredSize(new Dimension(100, 20));
        showTri = new JButton("Trilare");
        showTri.setPreferredSize(new Dimension(100, 20));
        likeMovie = new JButton("like");
        likeMovie.setPreferredSize(new Dimension(100, 20));
        showMovie.addActionListener(new btnLis());
        showTri.addActionListener(new btnLis());
        likeMovie.addActionListener(new btnLis());
        btnPanel.add(showTri);
        btnPanel.add(showMovie);
        btnPanel.add(likeMovie);


        atePanel = new JPanel(new BorderLayout());
        atePanel.setBackground(Color.DARK_GRAY);
        atePanel.add(movieNPanel, BorderLayout.NORTH);
        atePanel.add(discPanel, BorderLayout.CENTER);
        atePanel.add(btnPanel, BorderLayout.SOUTH);
    }

    private class btnLis implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == showTri){
                try {
                    Desktop.getDesktop().open(new File("video\\avengrsV.mp4"));
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, ioException.getMessage());
                }catch (Exception E){
                    JOptionPane.showMessageDialog(null, "File not found");
                }
            }
            if (e.getSource() == showMovie){

                if (m.getUrl() == null){
                    JOptionPane.showMessageDialog(null, "Sorry the Movie is not avi");
                } else {
                    try {
                        Desktop.getDesktop().browse(URI.create(m.getUrl()));
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, ioException.getMessage());
                    }
                }
            }

            if (e.getSource() == likeMovie){

                if (AccountFrame.isLogin){
                    JOptionPane.showMessageDialog(null, "the movie add to likeList");

                    File f = new File("Account.dat");

                    try {
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        CustomerAccount gAccount;
                        gAccount = (CustomerAccount) ois.readObject();

                        gAccount.addLikeMovie(m);

                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(gAccount);

                    } catch (IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "you should have login");
                }
            }
        }
    }
}
