package account;

import java.util.List;
import java.util.ArrayList;
import currency.Currency;
import currency.Loan;
import currency.Transaction;

public abstract class Account {
    String password;
    String userName;

    public Currency balance;
    public boolean transAvailability;
    public Currency checkingBalance;
    public Currency savingBalance;
    public boolean hasLoan;
    public Loan loan;
    public List<Transaction> transactions;

    public Account(){
        this.userName = "";
        this.password = "";
        this.hasLoan = false;
        transactions = new ArrayList<Transaction>();
    }

    public String getPassword(){
        return password;
    }

    public String getUserName(){
        return userName;
    }

    public boolean setLoan(Loan l){
        if(!hasLoan){
            loan = l;
            hasLoan = true;
            return true;
        }
        return false;
    }

    public boolean payLoan(){
        if(hasLoan && balance.declineValue(loan.currency.getCur_Cur(), loan.currency.getValue() + loan.interest.getValue())){
            loan.payLoan();
            hasLoan = false;
            return true;
        }
        return false;
    }


}
