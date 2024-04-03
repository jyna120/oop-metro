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
        userList.add(new Card(0, "정예진", 24, "climate", new ClimateCard()));
        userList.add(new Card(1, "나지영", 24, "prepaid", new PrepaidCard()));
        userList.add(new Card(2, "박수빈", 25, "deferred", new DeferredCard()));
        userList.add(new Card(3, "김동현", 35, "deferred", new DeferredCard(LocalDate.of(2024,3,15), 50000)));

//        File target = new File("C:\\Workspaces\\oop-metro\\metro\\src\\userList.txt");
//
//        // 입출력 형식으로 userList.txt에 user 정보 저장
//        try(ObjectOutputStream userList = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
//            List<Card> users= new ArrayList<>();
//            users.add(new Card(0, "정예진", 24, "climate", new ClimateCard()));
//            users.add(new Card(1, "나지영", 24, "prepaid", new PrepaidCard()));
//            users.add(new Card(2, "박수빈", 25, "deferred", new DeferredCard()));
//            userList.writeObject(users);
//            System.out.println("userList : " + userList);
//            System.out.println("output users : " + users);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 입출력 형식으로 userList.txt에 저장된 값 가져오기
//        try(ObjectInputStream userList = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)))) {
//            Object object = userList.readObject();
//
//            List<Card> users = (List<Card>) object;
//            System.out.println("Input users : " + users);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        return userList;
    }
}
