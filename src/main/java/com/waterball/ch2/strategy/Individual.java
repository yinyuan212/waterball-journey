package com.waterball.ch2.strategy;

import lombok.Data;

import java.util.List;

@Data
public class Individual {

    private int id;
    private String gender;
    private int age;
    private String intro;
    private List<String> habits;
    private Coord coord;
    private Individual matched;

    public Individual(int id, String gender, int age, String intro, List<String> habits, Coord coord) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.intro = intro;
        this.habits = habits;
        this.coord = coord;
    }
}
