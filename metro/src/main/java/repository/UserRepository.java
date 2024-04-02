package repository;

import model.vo.card.Card;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<Card> saveUser() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(0, "정예진", 24, "climate"));
        cardList.add(new Card(1, "나지영", 24, "prepaid"));
        cardList.add(new Card(2, "박수빈", 25, "deferred"));

        return cardList;
    }
}
