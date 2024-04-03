import model.vo.card.Card;
import model.vo.card.ClimateCard;
import model.vo.card.DeferredCard;
import model.vo.card.PrepaidCard;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    File target = new File("C:\\Workspaces\\oop-metro\\metro\\src\\userList.txt");
    List<Card> userList = null;
    Card card;
    public static void main(String[] args) {
        UserRepository u = new UserRepository();
        u.bringUserlist();
        u.savedUser();
    }
    public void savedUser() {
        // 입출력 형식으로 userList.txt에 user 정보 저장
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            List<Card> users= new ArrayList<>();
            if(userList == null) {
                users.add(new Card(0, "정예진", 24, "climate", new ClimateCard()));
                users.add(new Card(1, "나지영", 24, "prepaid", new PrepaidCard()));
                users.add(new Card(2, "박수빈", 25, "deferred", new DeferredCard()));
            }else {
                switch(card.getCard()) {
                    case "climate": users.set(card.getUserId(), new Card(card.getUserId(), card.getName(), card.getAge(), card.getCard(), new ClimateCard())); break;
                    case "prepaid": users.set(card.getUserId(), new Card(card.getUserId(), card.getName(), card.getAge(), card.getCard(), new PrepaidCard())); break;
                    case "deferred": users.set(card.getUserId(), new Card(card.getUserId(), card.getName(), card.getAge(), card.getCard(), new DeferredCard())); break;
                }
            }
            oos.writeObject(users);
            System.out.println("userList : " + oos.toString());
            System.out.println("output users : " + users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Card> bringUserlist() {
        // 입출력 형식으로 userList.txt에 저장된 값 가져오기
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)))) {
            Object object = ois.readObject();

            List<Card> users = (List<Card>) object;
            userList = users;
            System.out.println("Input userList : " + userList);
            return userList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
