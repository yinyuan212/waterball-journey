package com.waterball.ch2.template_method.ood.uno;

public abstract class Player extends com.waterball.ch2.template_method.ood.base.Player {
    @Override
    public abstract void nameHimself(int i);

    public abstract UnoCard showCard(UnoCard card);

    public boolean isNoHand() {
        return getHand().getCards().size() == 0;
    }
}
