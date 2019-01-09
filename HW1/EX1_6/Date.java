import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date{

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static LocalDate localDate = LocalDate.now();
    private static final int[] validDates = {31,28,31,30,31,30,31,31,30,31,30,31};
    private int month;
    private int day;
    private int year;
    boolean isLeapYear = false;

    //initalize
    public Date(){
        Default();
    }

    public Date(int month, int day, int year){
        if(isValidDate(month, day, year)){
            this.month = month;
            this.day = day;
            this.year = year;
        }
        else{
            System.out.println("Error: Invalid Date. Date set to 1/1/1970");
            Default();
        }
    }

    private void Default(){
        month = 1;
        day = 1;
        year = 1970;
    }

    //check if date is real
    public boolean isValidDate(int month, int day, int year){
        if ((month < 1) || (month > 12) || (day < 1) || (day > 31)){ //check if month and day are within possible ranges
            System.out.println("Invalid Date Error");
            return false;
        }
        
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))//check leap year
            isLeapYear = true;
        
        if (validDates[month - 1] >= day)
            return true;
        else if (isLeapYear && month == 1 && day == 29)
            return true;
        else{
            System.out.println("Invalid Date Error"); 
            return false;
        }
    }

    public String toString(){
        return String.format(month + "/" + day + "/" + year);
    }

    String getCurrentDate(){
        return String.format(dtf.format(localDate));
    }
    //get functions
    int getMonth(){ return month; }
    int getDay(){ return day; }
    int getYear(){ return year; }

    //set functions
    void setMonth(int month){
        if(isValidDate(month,this.day,this.year)){
            this.month = month;
        }
    }
    void setDay(int day){
        if(isValidDate(this.month,day,this.year)){
            this.day = day;
        }
    }
    void setYear(int year){
        if(isValidDate(this.month,this.day,year)){
            this.year = year;
        }
    }
    
    //PT -- missing difference. -3
}
