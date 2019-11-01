package currency;
import date.Date;

public class Transaction {
    public Date date;
    public String fromUser;
    public String toUser;
    public Currency value;
    public Currency charge;
    public Currency balanceLeft;
    public String description;

    public Transaction(String from, String to, Currency val, Currency cha, Currency ba, String des){
        this.date = new Date();
        this.fromUser = from;
        this.toUser = to;
        this.value = val;
        this.charge = cha;
        this.balanceLeft = ba;
        this.description = des;
    }
}
