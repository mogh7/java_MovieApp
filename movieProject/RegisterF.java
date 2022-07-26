package movieProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;



public class RegisterF extends JFrame {

    private JPanel p;
    private JButton register;
    private JTextField passT;
    private JTextField userT;
    
    public RegisterF(){
        
        setTitle("Register");
        setSize(400,300);
        setLocationRelativeTo(null);

        
        buildMethod();

        add(p, BorderLayout.CENTER);
        add(register, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void buildMethod() {

        p = new JPanel();

        JLabel email = new JLabel("E-mail  ");
        JLabel user = new JLabel("Username");
        JLabel pass = new JLabel("Password");

        JTextField emailT = new JTextField(25);
         userT = new JTextField(25);
         passT = new JPasswordField(25);

        register = new JButton("Register");
        register.addActionListener(new Lis());

        p.add(email);
        p.add(emailT);
        p.add(user);
        p.add(userT);
        p.add(pass);
        p.add(passT);


    }

    private class Lis implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if (userT.getText().isEmpty() || passT.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter username and password");
            }else {

                File f = new File("Account.dat");

                try {
                    FileOutputStream outS = new FileOutputStream(f);
                    ObjectOutputStream ObS = new ObjectOutputStream(outS);

                    CustomerAccount account = new CustomerAccount(userT.getText(), passT.getText());

                    ObS.writeObject(account) ;

                    JOptionPane.showMessageDialog(null, "thanks for Register " + userT.getText());

                    ObS.close();

                    setVisible(false);

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }
    }
}
