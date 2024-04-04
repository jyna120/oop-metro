package repository;

import model.vo.User;
import model.vo.card.Card;
import model.vo.card.ClimateCard;
import model.vo.card.DeferredCard;
import model.vo.card.PrepaidCard;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<Card> savedUser() {
        List<Card> userList = new ArrayList<>();
        userList.add(new Card(0, "정예진", 24, "climate", new ClimateCard(LocalDate.of(2024,4,1))));
        userList.add(new Card(1, "나지영", 24, "prepaid", new PrepaidCard()));
        userList.add(new Card(2, "박수빈", 25, "deferred", new DeferredCard()));
        userList.add(new Card(3, "김동현", 35, "deferred", new DeferredCard(LocalDate.of(2024,3,15), 50000)));
        userList.add(new Card(4, "옥주현", 44, "climate", new ClimateCard(LocalDate.of(2024,3,1))));
        userList.add(new Card(5, "청소년", 18, "prepaid", new PrepaidCard(2000)));
        userList.add(new Card(6, "어린이", 3, "deferred", new DeferredCard(LocalDate.of(2024,3,1), 2500)));
        userList.add(new Card(7, "노약자", 66, "prepaid", new PrepaidCard()));

        return userList;
    }

    public Card save(Card card) {
        return card;
    }
}
