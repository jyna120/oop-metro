package model.vo.card;

import model.vo.User;

import java.io.Serializable;

public class Card extends User implements Serializable {
    ClimateCard climateCard = new ClimateCard();
    PrepaidCard prepaidCard = new PrepaidCard();
    DeferredCard deferredCard = new DeferredCard();

    public Card(int userId, String name, int age, String card, ClimateCard climateCard) {
        super(userId, name, age, card);
        this.climateCard = climateCard;
    }

    public Card(int userId, String name, int age, String card, PrepaidCard prepaidCard) {
        super(userId, name, age, card);
        this.prepaidCard = prepaidCard;
    }

    public Card(int userId, String name, int age, String card, DeferredCard deferredCard) {
        super(userId, name, age, card);
        this.deferredCard = deferredCard;
    }

    public ClimateCard getClimateCard() {
        return climateCard;
    }

    public void setClimateCard(ClimateCard climateCard) {
        this.climateCard = climateCard;
    }

    public PrepaidCard getPrepaidCard() {
        return prepaidCard;
    }

    public void setPrepaidCard(PrepaidCard prepaidCard) {
        this.prepaidCard = prepaidCard;
    }

    public DeferredCard getDeferredCard() {
        return deferredCard;
    }

    public void setDeferredCard(DeferredCard deferredCard) {
        this.deferredCard = deferredCard;
    }

    @Override
    public String toString() {
        return
                getUserId() + "," + getName() + "," + getAge() + "," + getCard() + "," + getPrice() + "," + climateCard + "," + prepaidCard + "," + deferredCard + '\n';
    }
}
