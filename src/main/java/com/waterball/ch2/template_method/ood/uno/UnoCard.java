package com.waterball.ch2.template_method.ood.uno;

import com.waterball.ch2.template_method.ood.base.Card;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UnoCard extends Card {

    private Color color;
    private int number;

    public UnoCard(Color color, int number) {
        this.color = color;
        this.number = number;
    }

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
