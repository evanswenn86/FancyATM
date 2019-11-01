package backend;

import GUI.guiATM;
import account.Account;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;


public class ATMShell {
    public static String CurrentUser = "";
    public static Map<String, Account> accounts = new HashMap<>();
    public static JFrame frame1 = new JFrame("Fancy ATM Terminal");
    public static JFrame frame2 = new JFrame("Query");

    public static void main(String[] args){
        frame1.setSize(300, 230);
        frame1.setBounds(700, 300, 300, 230);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(350, 200);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new guiATM();
    }
}
