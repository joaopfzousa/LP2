package edu.projeto;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {

  private int day;

  private int month;

  private int year;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }



  public Date() {
    Calendar gregCalendar = new GregorianCalendar();
    this.day=gregCalendar.get(Calendar.DAY_OF_MONTH);
    this.month=gregCalendar.get(Calendar.MONTH)+1;
    this.year=gregCalendar.get(Calendar.YEAR);
  }

  public boolean beforeDate(Date d) {
    if(this.year < d.year)
    return true;
    if(this.year==d.year){
      if(this.month < d.month)
        return true;
      if(this.month == d.month){
        return this.day < d.day;
      }
    }
    return false;
  }

  public boolean isLeapYear() {
    return((this.year%4==0)&&(this.year%100!=0||this.year%400==0));
  }

  public int daysMonth() {
      switch (month) {
          case 1:
          case 3:
          case 5:
          case 7:
          case 8:
          case 10:
          case 12:
              return 31;
          case 4:
          case 6:
          case 9:
          case 11:
              return 30;
          case 2:
              if (isLeapYear() == true) {
                  return 29;
              } else {
                  return 28;
              }
          default:
              return 0;
      }
  }

  public boolean afterDate(Date d) {
    if(this.day == d.day && this.month == d.month && this.year == d.year)
      return false;
    return !beforeDate(d);
  }

  public void incrementDate() {
    if(this.day == this.daysMonth()){
        this.day = 1;
        if (this.month == 12){
            this.year++;
            this.month = 1;
        } else {
            this.month++;
        }
    } else {
        this.day++;
    }
  }

  public int differenceYears(Date d) {
    return Math.abs(this.year-d.year);
  }

  public int compareTo(Date d){
      if(this.day==d.day && this.month==d.month && this.year==d.year)
          return 0;
      return this.beforeDate(d)?-1:1;
  }

  @Override
  public String toString(){

    return this.day+"/"+this.month+"/"+this.year;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}