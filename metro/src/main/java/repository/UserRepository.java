package repository;

import model.vo.card.Card;
import model.vo.card.ClimateCard;
import model.vo.card.DeferredCard;
import model.vo.card.PrepaidCard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository {
    public List<Card> savedUser() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(0, "정예진", 24, "climate", new ClimateCard()));
        cardList.add(new Card(1, "나지영", 24, "prepaid", new PrepaidCard()));
        cardList.add(new Card(2, "박수빈", 25, "deferred", new DeferredCard()));
        cardList.add(new Card(3, "김동현", 35, "deferred", new DeferredCard(LocalDate.of(2024,3,15), 50000)));

        return userList;
    }
}
