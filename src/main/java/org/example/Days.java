package org.example;

import java.util.ArrayList;

public class Days {
    private ArrayList<ThisDay> daysList = new ArrayList<>();

    public void addDay(ThisDay day) {
        daysList.add(day);
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
