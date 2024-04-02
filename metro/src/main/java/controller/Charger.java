package controller;

import model.vo.card.Card;

public class Charger {
    public void menu(Card card, int userId) {
        System.out.printf("%s님의 카드는 %s 입니다.", card.getName(), card.getCard());
        if (card.getCard().equals("climate")){
            card.getClimateCards()[userId].chargeClimate();
        } else if (card.getCard().equals("deferred")) {
            card.getDeferredCards()[userId].chargeDeferred();
        } else if (card.getCard().equals("prepaid")) {
            card.getPrepaidCards()[userId].chargePrepaid();
        }
    }
}
