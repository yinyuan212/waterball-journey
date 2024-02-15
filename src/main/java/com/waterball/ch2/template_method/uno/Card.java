package com.waterball.ch2.template_method.uno;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Card {

    private Color color;
    private int number;

    public enum Color {
        RED,
        BLUE,
        GREEN,
        YELLOW
    }

    @Override
    public String toString() {
        return String.format("%s %d", color, number);
    }


}
