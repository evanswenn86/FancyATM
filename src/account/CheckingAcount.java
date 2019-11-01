package account;

import account.Account;
import currency.Currency;

public class CheckingAcount extends Account {
    public CheckingAcount(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.balance = new Currency();
    }
}
