package currency;

import java.util.HashMap;
import java.util.Map;

public class Currency {
    public Map<String,Double> rate = new HashMap<>();
//    private Double transactionProfit;
    private String Cur_Cur;
    private Double lastCharge;
    private Double value;

    public Currency(){
        rate.put("USD",6.6798);
        rate.put("CHF",6.6831);
        rate.put("CNY",1.0);
        rate.put("HKD",0.8511);
        rate.put("EUR",7.5775);
        rate.put("JPY",0.060352);
        rate.put("MOP",0.8259);
        rate.put("SEK",0.7158);
        rate.put("CAD",5.0847);
        rate.put("SGD",4.9469);
        rate.put("GBP",8.7298);
        rate.put("NOK",0.7769);
        rate.put("DKK",1.0155);
        rate.put("AUD",4.778);
        rate.put("NZD",4.5923);
        Cur_Cur = "";
        value = new Double(0);
        lastCharge = new Double(0);
//        transactionProfit = new Double(0);
    }

    public Currency(Currency c){
        rate.put("CNY",1.0);
        rate.put("USD",6.6798);
        rate.put("HKD",0.8511);
        rate.put("EUR",7.5775);
        rate.put("JPY",0.060352);
        rate.put("GBP",8.7298);
        rate.put("CHF",6.6831);
        rate.put("CAD",5.0847);
        rate.put("AUD",4.778);
        rate.put("SGD",4.9469);
        rate.put("SEK",0.7158);
        rate.put("NOK",0.7769);
        rate.put("DKK",1.0155);
        rate.put("MOP",0.8259);
        rate.put("NZD",4.5923);
        Cur_Cur = c.Cur_Cur;
        value = c.value;
        lastCharge = c.lastCharge;
//        transactionProfit = c.transactionProfit;
    }

    public Currency(String cur, Double val){
        rate.put("CNY",1.0);
        rate.put("USD",6.6798);
        rate.put("HKD",0.8511);
        rate.put("EUR",7.5775);
        rate.put("JPY",0.060352);
        rate.put("GBP",8.7298);
        rate.put("CHF",6.6831);
        rate.put("CAD",5.0847);
        rate.put("AUD",4.778);
        rate.put("SGD",4.9469);
        rate.put("SEK",0.7158);
        rate.put("NOK",0.7769);
        rate.put("DKK",1.0155);
        rate.put("MOP",0.8259);
        rate.put("NZD",4.5923);
        Cur_Cur = cur;
        value = val;
        lastCharge = new Double(0);
//        transactionProfit = new Double(0);
    }

    public boolean setCurrency(String s){
        if(Cur_Cur.equals("")&&rate.containsKey(s)){
            Cur_Cur = s;
            return true;
        }
        else if(rate.containsKey(s)){
            lastCharge = value * 0.05*rate.get(Cur_Cur)/rate.get(s);
            value = value*0.95*rate.get(Cur_Cur)/rate.get(s);
            Cur_Cur = s;
//            transactionProfit += lastCharge;
            return true;
        }
        return false;
    }


    public boolean addValue(String s, Double val){
        if(val<=0)
            return false;
        if(Cur_Cur.equals("")){
            setCurrency(s);
        }
        if(Cur_Cur.equals(s)){
            lastCharge = val * 0.05;
            value += (val*0.95);
//            transactionProfit += lastCharge;
            return true;
        }
        else if(rate.containsKey(s)){
            lastCharge = val*0.1*rate.get(s)/rate.get(Cur_Cur);
            value += (val*0.9*rate.get(s)/rate.get(Cur_Cur));
//            transactionProfit += lastCharge;
            return true;
        }
        return false;
    }


    public boolean declineValue(String s,Double val){
        if(val<=0)
            return false;
        if(Cur_Cur.equals("")){
            return false;
        }
        if(Cur_Cur.equals(s)){
            Double v = value - val*1.05;
            if(v<0){
                return false;
            }
            lastCharge = val*0.05;
            value = v;
            return true;
        }
        else if(rate.containsKey(s)){
            Double v = value - (val*1.1*rate.get(s)/rate.get(Cur_Cur));
            if(v<0){
                return false;
            }
            lastCharge = val*0.1*rate.get(s)/rate.get(Cur_Cur);
            value = v;
            return true;
        }
        return false;
    }


    public Currency mergeCur(Currency c){
        if(!Cur_Cur.equals(c.Cur_Cur)){
            return this;
        }
        return new Currency(Cur_Cur,this.value+c.value);
    }


    public String toString(){
        return Cur_Cur + value;
    }

    public String getCur_Cur(){
        return this.Cur_Cur;
    }

    public Double getLastCharge() {
        return lastCharge;
    }

    public Double getValue() {
        return this.value;
    }

    public Double toDouble() { return this.value; }
}
