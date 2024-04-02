package model.vo.card;

import model.vo.User;

import java.util.Arrays;

public class Card extends User {
    ClimateCard[] climateCards = new ClimateCard[3];
    PrepaidCard[] prepaidCards = new PrepaidCard[3];
    DeferredCard[] deferredCards = new DeferredCard[3];

    public Card() {}
    public Card(int userId, String name, int age, String card) {
        super(userId, name, age, card);
        if (card.equals("climate")) {
            this.climateCards[userId] = new ClimateCard(userId, name, age, card);
            this.prepaidCards[userId] = null;
            this.deferredCards[userId] = null;
        }
        if (card.equals("prepaid")) {
            this.climateCards[userId] = null;
            this.prepaidCards[userId] = new PrepaidCard(userId, name, age, card);
            this.deferredCards[userId] = null;
        }
        if (card.equals("deferred")) {
            this.climateCards[userId] = null;
            this.prepaidCards[userId] = null;
            this.deferredCards[userId] = new DeferredCard(userId, name, age, card);
        }
    }

    public ClimateCard[] getClimateCards() {
        return climateCards;
    }

    public PrepaidCard[] getPrepaidCards() {
        return prepaidCards;
    }

    public DeferredCard[] getDeferredCards() {
        return deferredCards;
    }

    @Override
    public String toString() {
        return "Card{" +
                "climateCards=" + Arrays.toString(climateCards) +
                ", prepaidCards=" + Arrays.toString(prepaidCards) +
                ", deferredCards=" + Arrays.toString(deferredCards) +
                '}';
    }
}
