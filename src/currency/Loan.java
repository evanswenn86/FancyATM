package currency;

import date.Date;

public class Loan {
    public String userName;
    public Currency currency;
    public Date startDate;
    public int termMonth;
    public Currency interest;
    public boolean isPaid;
    public Loan(String username, Currency currency, int termMonth){
        this.startDate = new Date();
        this.userName = username;
        this.currency = currency;
        this.termMonth = termMonth;
        this.interest = new Currency(currency.getCur_Cur(), calculateInterest(currency.getValue(), termMonth));

    }

    public Double calculateInterest(Double val, int termMonth){
        Double interest = 2 * val;

        if (termMonth <= 3){
            interest = val * 0.2;
        }

        else if (termMonth <= 6){
            interest = val * 0.45;
        }
        else if (termMonth <= 12){
            interest = val;
        }
        return interest;
    }

    public void payLoan(){
        isPaid = true;
    }

}
