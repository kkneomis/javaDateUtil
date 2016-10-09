/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateutil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author simeonkakpovi
 */
public class DateUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(isLeapYear(1996));
        //getLastDayOfMonth(02,1997);
        //System.out.println(getLastDayOfMonth(3,1996));
        //System.out.println(toString(3,24,1996,"MM/dd/yyyy"));
        //getDaysBetweenDates(3,24,1995, 3,24,1996);
        System.out.println(getDayofWeek(10, 9,2016));
    }
    

    public static int getDayofWeek(int month, int day, int year){
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }
    
    public static int getDaysBetweenDates(int month1, int day1, int year1, int month2, int day2, int year2){
        int diff=0;
        Calendar d1 = Calendar.getInstance();
        d1.set(year1, month1 - 1, day1);
        Calendar d2 = Calendar.getInstance();
        d2.set(year2, month2 - 1, day2);
        
        while (d1.before(d2)){
            d1.add(Calendar.DATE, 1);
            diff +=1;
        }
        
        return diff - 1;
    }
    
    public static int getLastDayOfMonth(int month, int year){
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        
        //SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy");
        int lastDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        //System.out.println(sdf.format(c.getTime()));
        //System.out.println(lastDayOfMonth);
        return lastDayOfMonth;
    } 
    
    public static String toString(int month, int day, int year, String delimiter){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        String date = sdf.format(c.getTime());
        return date;
    } //prints the date as mm/dd/yyyy
    
    public static boolean isLeapYear(int year){
    //returns t/f if the year is a leap year
    // leap years are all years divisible by 4 but not 100
    // years that are divisible by 400 are leap years, too
    // is it divisible by 4?
    // Note that the year is not passed as an argument. It could be but 
    // I choose to use the class level private variable for my method.
    boolean bLeapYear = false;
    bLeapYear = (year % 4 == 0);
    // is it divisible by 4 and not 100
    bLeapYear = bLeapYear && (year % 100 != 0);
    // is it divisible by 4 and not 100 unless it's divisible by 400
    bLeapYear = bLeapYear || (year % 400 == 0);
    return bLeapYear;
    }

}
