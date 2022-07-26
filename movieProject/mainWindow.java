package movieProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class mainWindow extends JFrame {

    private ArrayList<Movie> moviesList;
    private JScrollPane scrollPane;
    private JPanel upHolder;
    private static JPanel btnHold;
    private JPanel movieHolder;
    JButton creatAcount;
    JMenuItem exitItem;
    static final int width = 1080;
    static final int height = 720;


    public mainWindow(){
        setTitle("Movie App");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buildListMovie();
        buildMovieHolder();
        buildUpHolder();
        buildMenuBar();

        add(scrollPane, BorderLayout.CENTER);
        add(upHolder, BorderLayout.NORTH);

        setResizable(true);

        setVisible(true);
    }

    private void buildListMovie() {
        moviesList = new ArrayList<>();
        moviesList.add(new Movie("Avengers", "ghflhaf;laghfg;aflgha;fghpasrhglasga;sgflhas;lfglafgiahfgiiahlfhg8dfhguhrguhqrugha;lsrhgosh rhgoasfhighwehtqwiqwrg awrhg;alsrhghgerhg'qrigpweruthrt rith;rg;lgirt", new ImageIcon("image\\avengers.jpg"), "https://gray.egybest.me/movie/avengers-endgame-2019/?ref=movies-p1"));
        moviesList.add(new Movie("Black Window", "go fhad to mm", new ImageIcon("image\\blackWindw.png")));
        moviesList.add(new Movie("Assassin", "go nasser to home", new ImageIcon("image\\assassin.png")));
        moviesList.add(new Movie("Venom", "go fhad to mm", new ImageIcon("image\\Venom.jpg"), "https://gray.egybest.me/movie/venom-let-there-be-carnage-2021/?ref=home-trends"));
        moviesList.add(new Movie("Black Window", "go fhad to mm", new ImageIcon("image\\blackWindw.png")));
        moviesList.add(new Movie("Assassin", "go nasser to home", new ImageIcon("image\\assassin.png")));
        moviesList.add(new Movie("Assassin", "go nasser to home", new ImageIcon("image\\assassin.png")));
        moviesList.add(new Movie("Avengers", "ghflhaf;laghfg;aflgha;fghpasrhglasga;sgflhas;lfglafgiahfgiiahlfhg8dfhguhrguhqrugha;lsrhgosh rhgoasfhighwehtqwiqwrg awrhg;alsrhghgerhg'qrigpweruthrt rith;rg;lgirt", new ImageIcon("image\\avengers.jpg"), "https://gray.egybest.me/movie/avengers-endgame-2019/?ref=movies-p1"));
        moviesList.add(new Movie("Venom", "go fhad to mm", new ImageIcon("image\\Venom.jpg"), "https://gray.egybest.me/movie/venom-let-there-be-carnage-2021/?ref=home-trends"));
        moviesList.add(new Movie("Venom", "go fhad to mm", new ImageIcon("image\\Venom.jpg"), "https://gray.egybest.me/movie/venom-let-there-be-carnage-2021/?ref=home-trends"));
        moviesList.add(new Movie("Assassin", "go nasser to home", new ImageIcon("image\\assassin.png")));
    }

    private void buildMovieHolder() {
        movieHolder = new JPanel();
        movieHolder.setBackground(new Color(0x20364C));
        movieHolder.setPreferredSize(new Dimension(900, (moviesList.size() / 5) * 450));

        for (Movie movie : moviesList) {

            movieHolder.add(new MoviePanel(movie));
        }

        scrollPane = new JScrollPane(movieHolder);
    }

    private void buildUpHolder() {
        upHolder = new JPanel(new BorderLayout());

        JPanel nameHold, iconHold;

        nameHold = new JPanel();
        nameHold.setBackground(new Color(0, 0, 0));
        JLabel nameApp = new JLabel("Movie App");
        nameApp.setPreferredSize(new Dimension(200,50));
        nameApp.setForeground(new Color(0x697FAC));
        nameApp.setFont(new Font("Serif", Font.BOLD, 30));
        nameHold.add(nameApp);

        btnHold = new JPanel();
        btnHold.setBackground(Color.black);
        creatAcount = new JButton("Login");
        creatAcount.setBackground(new Color(0x546282));
        creatAcount.setForeground(Color.WHITE);
        creatAcount.setFont(new Font("Serif", Font.BOLD, 20));
        creatAcount.setPreferredSize(new Dimension(150, 50));
        creatAcount.addActionListener(new Lis());
        btnHold.add(creatAcount);

        iconHold = new JPanel();
        iconHold.setBackground(Color.black);
        JLabel icon = new JLabel(new ImageIcon("image\\movie.png"));
        icon.setPreferredSize(new Dimension(50,50));
        iconHold.add(icon);

        upHolder.add(nameHold, BorderLayout.CENTER);
        upHolder.add(btnHold, BorderLayout.EAST);
        upHolder.add(iconHold, BorderLayout.WEST);
    }

    private class Lis implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == creatAcount){
                new AccountFrame();
            }
            if (e.getSource() == exitItem){

                File f = new File("Account.dat");

                try {
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    CustomerAccount gAccount;
                    gAccount = (CustomerAccount) ois.readObject();

                    if (gAccount.getLike() == null) {
                        JOptionPane.showMessageDialog(null, "don't have like movie");
                    }else {
                        movieHolder.removeAll();
                        for (int i = 0; i < gAccount.getLike().size(); i++) {

                            movieHolder.add(new MoviePanel(gAccount.getLike().get(i)));
                        }
                        pack();
                    }
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "file not Found");
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, "the class wrongs");
                }
            }

        }
    }

    static void changBtn(String name) {
        btnHold.removeAll();
        JLabel accName = new JLabel("Welcome " + name, JLabel.CENTER);
        accName.setFont(new Font("Serif", Font.BOLD, 24));
        accName.setForeground(new Color(0x697FAC));
        btnHold.add(accName);

    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.DARK_GRAY);

        JMenu menu = new JMenu("test");

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new Lis());
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new mainWindow();
    }



}
