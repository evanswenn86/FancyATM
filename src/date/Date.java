package date;

import java.util.Calendar;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(){
        Calendar cal = Calendar.getInstance();

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString(){
        return day + "/" + month + "/" + year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public boolean equals(Date day){
        if(this.day == day.getDay() && this.month == day.getMonth() && this.year == day.getYear()){
            return true;
        }
        return false;
    }


}
