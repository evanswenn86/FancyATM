package GUI;
import account.CheckingAcount;
import account.SavingAccount;
import backend.ATMShell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window.*;


public class guiLogin {
    public JTextField userText = new JTextField(20);
    public JPasswordField passwordText = new JPasswordField(20);

    public guiLogin() {

        JPanel panel = new JPanel();
        ATMShell.frame1.add(panel);
        ATMShell.frame1.setVisible(true);
        panel.removeAll();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(300, 230));

        JLabel userLabel = new JLabel("User:");

        userLabel.setBounds(30,25,80,25);
        panel.add(userLabel);

        userText.setBounds(100,25,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30,65,80,25);
        panel.add(passwordLabel);

        passwordText.setBounds(100,65,165,25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(20, 110, 130, 25);
        loginButton.addActionListener(new buttonListenerLogin());
        panel.add(loginButton);


        JButton createaccountButton = new JButton("create account");
        createaccountButton.setBounds(145, 110, 130, 25);
        createaccountButton.addActionListener(new buttonListenerCreate());
        panel.add(createaccountButton);


        JButton enterManager = new JButton("I'm the manager");
        enterManager.setBounds(20, 150, 255, 25);
        enterManager.addActionListener(new enterManager());
        panel.add(enterManager);

        try { Thread.sleep ( 1000 ) ;
        }
        catch (InterruptedException ie){}

        panel.revalidate();
        panel.repaint();
    }

    public class enterManager implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new guiManager();
        }
    }

    public class buttonListenerLogin implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String usrnm = userText.getText();
            String psw = String.valueOf(passwordText.getPassword());
            if(ATMShell.accounts.containsKey(usrnm)&&ATMShell.accounts.get(usrnm).getPassword().equals(psw)){
                ATMShell.CurrentUser = usrnm;
                JOptionPane.showMessageDialog(null, "Login successful!", "Info", JOptionPane.INFORMATION_MESSAGE);
                userText.setText("");
                passwordText.setText("");
                ATMShell.frame1.setVisible(false);
                ATMShell.frame1.dispose();
                new guiATM();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Username or Password!", "Info", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    class buttonListenerCreate implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String usrnm = userText.getText();
            String psw = String.valueOf(passwordText.getPassword());
            if(!ATMShell.accounts.containsKey(usrnm)&&(!usrnm.equals(""))&&(!usrnm.equals("BANK"))&&(!usrnm.equals("ATM"))){
                Object[] options = {"Checking Account","Saving Account","Cancel"};
                int response=JOptionPane.showOptionDialog(new Panel(), "Please select your account type:",
                        "Creating an account",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(response==0){
                    ATMShell.accounts.put(usrnm, new SavingAccount(usrnm,psw));
                    ATMShell.CurrentUser = usrnm;
                    JOptionPane.showMessageDialog(null, "Registered successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    userText.setText("");
                    passwordText.setText("");
                    ATMShell.frame1.setVisible(false);
//                    dispose();
                    new guiATM();
                }
                else if(response == 1){
                    ATMShell.accounts.put(usrnm, new CheckingAcount(usrnm,psw));
                    ATMShell.CurrentUser = usrnm;
                    JOptionPane.showMessageDialog(null, "Registered successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    userText.setText("");
                    passwordText.setText("");
                    ATMShell.frame1.setVisible(false);
//                    dispose();
                    new guiATM();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Request canceled", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "This user name already exists or invalid", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
