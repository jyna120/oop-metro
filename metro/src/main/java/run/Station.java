package run;

import controller.Charger;
import controller.Gate;
import model.vo.card.Card;
import repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class Station {
    public static void main(String[] args) {
        Station station = new Station();
        station.userMenu();
    }

    public void userMenu() {
        UserRepository userRepository = new UserRepository();
        List<Card> userList = userRepository.saveUser();

        Scanner sc = new Scanner(System.in);
        Gate gate = new Gate();
        Charger charger = new Charger();

        System.out.print("ID를 입력하세요 : ");
        int userId = sc.nextInt();
        System.out.print("1. 지하철 승차 / 2. 충전 : ");
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
