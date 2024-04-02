package run;

import controller.Charger;
import controller.Gate;
import model.vo.User;
import model.vo.card.Card;

import java.util.List;
import java.util.Scanner;

public class Stationgit {
    public static void main(String[] args) {
        User user = new User();
        List<Card> userList = user.saveUser();

        Scanner sc = new Scanner(System.in);
        Gate gate = new Gate();
        Charger charger = new Charger();

        System.out.print("ID를 입력하세요 : ");
        int userId = sc.nextInt();
        System.out.println("1. 지하철 이용 / 2. 충전 : ");
        int selected = sc.nextInt();

        switch (selected) {
            case 1 : gate.menu(); break;
            case 2 :
                charger.menu(userList.get(userId), userId);
                System.out.println(userList.get(userId).getName() +"님의 카드현황 입니다.");
                if (userList.get(userId).getCard().equals("climate")) {
                    System.out.println(userList.get(userId).getClimateCards()[userId]);
                } else if (userList.get(userId).getCard().equals("prepaid")) {
                    System.out.println(userList.get(userId).getPrepaidCards()[userId]);
                } else if (userList.get(userId).getCard().equals("deferred")) {
                    System.out.println(userList.get(userId).getDeferredCards()[userId]);
                }
        }
    }
}
