package org.example;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Days implements Serializable {
    private transient FileManager fileManager = new FileManager();
    private ArrayList<ThisDay> daysList = new ArrayList<>();
    private transient Scanner sc = new Scanner(System.in);

    public ThisDay getToday() {
        LocalDate today = LocalDate.now();

        for (ThisDay day : daysList) {
            if (day.getToday().equals(today)) {
                return day;
            }
        }

        ThisDay newDay = new ThisDay();
        daysList.add(newDay);
        fileManager.saveDays();
        return newDay;
    }

    public void initTransient() {
        this.fileManager = new FileManager();
        this.sc = new Scanner(System.in);
    }

    public void addDay(ThisDay day) {
        daysList.add(day);
        fileManager.saveDays();
    }

    public void getDaysList() {
        if(daysList.isEmpty()) {
            System.out.println("Лист пуст");
            return;
        }

        for (ThisDay day : daysList) {
            System.out.println(day.getTotalEatenCalories());
        }
    }
}
