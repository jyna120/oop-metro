package repository;

import model.vo.card.Card;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<Card> saveUser() {
        List<Card> userList = new ArrayList<>();
        userList.add(new Card(0, "정예진", 24, "climate"));
        userList.add(new Card(1, "나지영", 24, "prepaid"));
        userList.add(new Card(2, "박수빈", 25, "deferred"));

        return userList;
    }
}
