package GUI;
import currency.Transaction;
import date.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Report extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton return_button;
    private JButton managerView;
    private JLabel profitLabel;
    public Double totalProfit;
    private List transactions;
//    private JPanel profitPanel;

    Report(List<Transaction> transactions,Date date, boolean isManager){
        this.transactions = transactions;
        this.setTitle("Report");
        this.setBounds(500, 400, 603, 500);
        this.setLayout(null);
        table=new JTable();
        model=new DefaultTableModel();
        table.setModel(model);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(1, 0, 600, 300);
        this.add(jsp);
        return_button=new JButton("Return");
        return_button.setBounds(1, 310, 310, 30);
        return_button.addActionListener(new ReturnButtonAction());
        this.add(return_button);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        managerView = new JButton("View your Profit");
        managerView.setBounds(400, 310, 210, 30);
//        managerView.addActionListener(new ManagerViewButtonAction());
        this.add(managerView);
        managerView.setVisible(isManager);
        profitLabel = new JLabel("Your current profit is: ");
        profitLabel.setVisible(isManager);
        profitLabel.setBounds(1, 350, 500, 50);
        this.add(profitLabel);
        totalProfit = calculateProfit(transactions, profitLabel);
        profitLabel.setText("current profit is: " + totalProfit.toString());




        model.addColumn("Time");
        model.addColumn("From");
        model.addColumn("To");
        model.addColumn("Currency");
        model.addColumn("Charge");
        model.addColumn("Balance Left");
        model.addColumn("Description");
        String[] row=new String[7];
        for(int i = 0;i<transactions.size();i++){
            row[0]=transactions.get(i).date.toString();
            row[1]=transactions.get(i).fromUser;
            row[2]=transactions.get(i).toUser;
            row[3]=transactions.get(i).value.toString();
//            String valueString = transactions.get(i).getCharge();
//            int valueInt = Integer.parseInt(valueString) / 10;
//            String presentVal = Integer.toString(valueInt);
//            row[4] = presentVal;
            row[4]=transactions.get(i).charge.toString();
            row[5]=transactions.get(i).balanceLeft.toString();
            row[6]=transactions.get(i).description;
            model.addRow(row);
        }
    }

    Report(List<Transaction> transactions, Boolean isManager){
        this.setTitle("Report");
        this.setBounds(500, 400, 603, 500);
        this.setLayout(null);
        table=new JTable();
        model=new DefaultTableModel();
        table.setModel(model);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(1, 0, 600, 300);
        this.add(jsp);
        return_button=new JButton("Return");
        return_button.setBounds(10, 310, 210, 30);
        return_button.addActionListener(new ReturnButtonAction());
        this.add(return_button);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        managerView = new JButton("View your Profit");
        managerView.setBounds(400, 310, 210, 30);
//        managerView.addActionListener(new ManagerViewButtonAction());
        this.add(managerView);
        managerView.setVisible(isManager);
        profitLabel = new JLabel("Your current profit is: ");
        profitLabel.setVisible(isManager);
        profitLabel.setBounds(1, 350, 500, 50);
        this.add(profitLabel);
        calculateProfit(transactions, profitLabel);
        profitLabel.setText("current profit is: " + totalProfit);

        model.addColumn("Time");
        model.addColumn("From");
        model.addColumn("To");
        model.addColumn("Currency");
        model.addColumn("Charge");
        model.addColumn("Balance Left");
        model.addColumn("Description");
        String[] row=new String[7];
        for(int i = 0;i<transactions.size();i++){
            row[0]=transactions.get(i).date.toString();
            row[1]=transactions.get(i).fromUser;
            row[2]=transactions.get(i).toUser;
            row[3]=transactions.get(i).value.toString();
//            String valueString = transactions.get(i).getCharge();
//            int valueInt = Integer.parseInt(valueString) / 10;
//            String presentVal = Integer.toString(valueInt);
//            row[4] = presentVal;
            row[4]=transactions.get(i).charge.toString();
            row[5]=transactions.get(i).balanceLeft.toString();
            row[6]=transactions.get(i).description;
            model.addRow(row);
        }
    }


    private Double calculateProfit(List<Transaction> transactions, JLabel profitLabel){
        for(int i = 0;i<transactions.size();i++){
            String s = transactions.get(i).charge.getValue().toString();
            Double d = Double.parseDouble(s);
            totalProfit += d;
        }
        profitLabel.setText("current profit is: " + totalProfit.toString());
        return totalProfit;
//        return totalProfit;
    }

    class ReturnButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
