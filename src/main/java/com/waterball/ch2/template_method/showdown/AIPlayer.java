package com.waterball.ch2.template_method.showdown;

public class AIPlayer extends Player {

    @Override
    public void nameHimSelf(int i) {
        String name = "AI-" + i;
        setName(name);
        System.out.println(String.format("P%d: %s", i, name));
    }

    @Override
    public Card showCard() {
        int size = getHand().getCards().size();
        int random = (int) (Math.random() * size);
        return getHand().show(random);
    }
}
