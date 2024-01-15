package com.edhealthbackend;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class validateDate {
public static void main(String[] args) {
    LocalDate today=LocalDate.now();
    String myDate="2023-01-15";
    LocalDate userDate=LocalDate.parse(myDate);
        long noOfYears = today.until(userDate, ChronoUnit.YEARS);
        long noOfMonths = today.until(userDate, ChronoUnit.MONTHS);
        long noOfWeeks = today.until(userDate, ChronoUnit.WEEKS);
        long noOfDays = today.until(userDate, ChronoUnit.DAYS);
        System.out.println("Years: "+noOfYears);
        System.out.println("Months: "+noOfMonths);
        System.out.println("Weeks: "+noOfWeeks);
        System.out.println("Days: "+noOfDays);
}
}
