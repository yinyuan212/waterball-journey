package com.waterball.ch2.template_method.uno;


import java.util.ArrayList;
import java.util.List;


public class AIPlayer extends Player {

    @Override
    public void nameHimSelf(int i) {
        String name = "AI-" + i;
        setName(name);
        System.out.println(String.format("P%d: %s", i, name));
    }

    @Override
    public Card showCard(Card card) {
        List<Integer> canShowCards = new ArrayList<>();
        System.out.println("current card: " + card);

        System.out.println(getName() + " cards in hand: ");
        for (int i = 0; i < getHand().getCards().size(); i++) {
            Card cardInHand = getHand().getCards().get(i);
            if (cardInHand.getColor() == card.getColor() || cardInHand.getNumber() == card.getNumber()) {
                canShowCards.add(i);
                System.out.println(String.format("%d: %s", i, cardInHand));
            }
        }

        if (canShowCards.size() > 0) {
            int random = (int) (Math.random() * canShowCards.size());
            return getHand().show(canShowCards.get(random));    
        } else {
            return null;
        }
    }
}
