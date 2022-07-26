package movieProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AccountFrame extends JFrame {
    private JPanel p;
    private JButton regester;
    private JButton login;
    private JTextField nameT;
    private JTextField PassT;
    static boolean isLogin = false;

    public AccountFrame() {

        setTitle("Account");
        setSize(300, 300);
        setLocationRelativeTo(null);

        buildMethod();

        add(p, BorderLayout.CENTER);
        setVisible(true);

    }

    private void buildMethod() {

        p = new JPanel();

        JLabel userName = new JLabel("Username");
        JLabel passWord = new JLabel("Password");

        nameT = new JTextField(15);
        PassT = new JPasswordField(15);

        login = new JButton("Log in");
        regester = new JButton("Regster");

        regester.addActionListener(new Lis());
        login.addActionListener(new Lis());

        p.add(userName);
        p.add(nameT);
        p.add(passWord);
        p.add(PassT);
        p.add(login);
        p.add(regester);

    }

    private class Lis implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)  {
            if (e.getSource() == regester) {
                new RegisterF();
            }
            if (e.getSource() == login) {

                if (nameT.getText().isEmpty() || PassT.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "enter your username Or password");
                }else {

                    File f = new File("Account.dat");

                    try {
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        CustomerAccount gAccount;
                        gAccount = (CustomerAccount) ois.readObject();

                        if (gAccount.getUsername().equalsIgnoreCase(nameT.getText()) && gAccount.getPassword().equalsIgnoreCase(PassT.getText())){
                            JOptionPane.showMessageDialog(null, "Welcome " + nameT.getText());
                            mainWindow.changBtn(gAccount.getUsername());
                            isLogin = true;
                            setVisible(false);

                        }else {
                            JOptionPane.showMessageDialog(null, "you don't have account");
                        }

                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, "file not Found");
                    } catch (ClassNotFoundException classNotFoundException) {
                        JOptionPane.showMessageDialog(null, "the class wrongs");
                    }

                }

            }
        }
    }
}
