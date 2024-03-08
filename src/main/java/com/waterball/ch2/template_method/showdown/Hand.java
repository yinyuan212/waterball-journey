package com.waterball.ch2.template_method.showdown;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hand {

    private List<Card> cards = new ArrayList<>();

    public Card show(int i) {
        return cards.remove(i);
    }
}
