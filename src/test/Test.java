package test;

import exception.DayHalfException;
import exception.HourException;
import exception.MinuteException;
import exception.TimeException;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        getTime();
    }

    public static void getTime() {
        TimeOfDay timeOfDay = new TimeOfDay();
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter time in the format [hh:mm(am/pm)] >> ");
        try {
            timeOfDay.setTimeTo(input.next());
            System.out.println("Added Successfully ^_^");
            return;
        } catch (HourException ex) {
            System.out.println("Invalid hour try again >_<");
        } catch (MinuteException ex) {
            System.out.println("Invalid Minute try again >_<");
        } catch (DayHalfException ex) {
            System.out.println("Invalid Day half try again >_<");
        } catch (TimeException ex) {
            System.out.println("Invalid Format try again >_<");
        }
        getTime();
    }
}
