package run;

import controller.Charger;
import controller.Gate;
import model.vo.card.Card;
import repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class Station {
    public static int userId; // 입력받은 사용자의 id

    public static void main(String[] args) {
        Station station = new Station();
        station.userMenu();
    }

    public void userMenu() {
        UserRepository userRepository = new UserRepository();
        List<Card> userList = userRepository.savedUser();

        Scanner sc = new Scanner(System.in);
        Gate gate = new Gate();
        Charger charger = new Charger();

        System.out.print("ID를 입력하세요 : ");
        userId = sc.nextInt();
        int selected = 0; // 선택지

        while(true) {
            System.out.print("1. 지하철 승차 / 2. 충전 / 3. 종료 : ");
            selected = sc.nextInt();
            
            switch (selected) {
                case 1:
                    gate.menu(userList.get(userId));
                    // Gate의 menu로 사용자의 Card 객체를 전달합니다.
                    break;
                case 2:
                    charger.menu(userList.get(userId));
                    // Charger menu로 사용자의 Card 객체를 전달합니다.
                    break;
                case 3:
                    System.out.println("> 종료되었습니다...");
                    return;
                default:
                    System.out.println("> 잘못 입력하셨습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
