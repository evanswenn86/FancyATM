package account;

import account.Account;
import currency.Currency;

public class SavingAccount extends Account {

    public SavingAccount(String username,String password){
        this.userName = username;
        this.password = password;
        this.balance = new Currency();
    }

}
