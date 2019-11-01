package GUI;
import account.Account;
import backend.ATMShell;
import currency.Transaction;
import date.Date;
import sun.font.TrueTypeFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;

public class guiManager extends JFrame{
    private JTextField numberField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;

    private JButton viewTransactionButton;
    private JButton viewDayTransaction;
    private JButton viewUser;
    public Boolean isManager;

    public guiManager(){
        this.setTitle("Manager Terminal");
        this.setBounds(600, 200, 570, 300);
        this.setLayout(null);
        this.isManager = true;


        JLabel numberLable = new JLabel("Enter Account ID:");
        numberField = new JTextField(10);
        numberLable.setBounds(30, 30, 110, 25);
        numberField.setBounds(150, 30, 250, 25);
        this.add(numberLable);
        this.add(numberField);

        Date date = new Date();

        JLabel dayLabel = new JLabel("Enter date");
        dayField = new JTextField(10);
        dayLabel.setBounds(30,80,100,25);
        dayField.setBounds(150,80,50,25);
        dayField.setText(Integer.toString(date.getDay()));
        this.add(dayLabel);
        this.add(dayField);

        JLabel monthLabel = new JLabel("    month");
        monthField = new JTextField(10);
        monthLabel.setBounds(200,80,50,25);
        monthField.setBounds(250,80,50,25);
        monthField.setText(Integer.toString(date.getMonth()));
        this.add(monthLabel);
        this.add(monthField);

        JLabel yearLabel = new JLabel("       year");
        yearField = new JTextField(10);
        yearLabel.setBounds(300,80,50,25);
        yearField.setBounds(350,80,50,25);
        yearField.setText(Integer.toString(date.getYear()));
        this.add(yearLabel);
        this.add(yearField);

        viewUser=new JButton("Check User");
        viewUser.setBounds(420, 30, 130, 30);
        viewUser.addActionListener(new ViewUserAction());
        this.add(viewUser);

        viewDayTransaction=new JButton("Check Day Trans");
        viewDayTransaction.setBounds(420, 75, 130, 30);
        viewDayTransaction.addActionListener(new ViewDayTransAction());
        this.add(viewDayTransaction);

        viewTransactionButton=new JButton("View All Transactions");
        viewTransactionButton.setBounds(30, 120, 500, 30);
        viewTransactionButton.addActionListener(new ViewTransAction());

        this.add(viewTransactionButton);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }


    class ViewUserAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String theAccount = numberField.getText();
            if(ATMShell.accounts.containsKey(theAccount)){
                new Report(ATMShell.accounts.get(theAccount).transactions, isManager);
            }
            else{
                JOptionPane.showMessageDialog(null,"Account doesn't exist. Try again.");
            }
        }
    }

    class ViewDayTransAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input_day = dayField.getText();
            String input_month = monthField.getText();
            String input_year = yearField.getText();
            try {
                int day = Integer.parseInt(input_day);
                int month = Integer.parseInt(input_month);
                int year = Integer.parseInt(input_year);

                Date theDay = new Date(day,month,year);

                List<Transaction> allTrans = new ArrayList<>();
                for(Account entry : ATMShell.accounts.values()){
                    allTrans.addAll(entry.transactions);
                }
                new Report(allTrans,theDay, isManager);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid date input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    class ViewTransAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Transaction> allTrans = new ArrayList<>();
            for(Account entry : ATMShell.accounts.values()){
                allTrans.addAll(entry.transactions);
            }
            new Report(allTrans, isManager);
        }
    }



}
