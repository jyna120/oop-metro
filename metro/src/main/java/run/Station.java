package run;

import controller.Charger;
import controller.Gate;
import model.vo.card.Card;
import repository.UserRepository;

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Station {
    public static void main(String[] args) {

        Station station = new Station();
        station.userMenu();
    }

    public void userMenu() {
        String info = """
                ===========🚇🚇🚇전철역에 오신 여러분 환영합니다🚇🚇🚇===========
                당신은 1️⃣지하철에 승차하거나 2️⃣교통카드를 충전할 수 있습니다.
                💰지하철 기본 요금은 일반 1,400원, 청소년 800원, 어린이 500원, 노약자는 무료입니다.
                💳교통카드의 종류로 선불카드, 후불카드, 기후동행카드가 있습니다.
                ============================================================
                """;
        System.out.println(info);
        List<Card> userList = readRepository();
        System.out.println();
//        UserRepository userRepository = new UserRepository();
//        userList = userRepository.savedUser();
//        if (userList != null) {
//            userList = readRepository();
//        } else {
//            userRepository.savedUser();
//        }

        Scanner sc = new Scanner(System.in);
        Gate gate = new Gate();
        Charger charger = new Charger();

        System.out.print("당신의 ID를 입력하세요 : ");
        int userId = sc.nextInt(); // 입력받은 사용자의 id
        System.out.printf("> 당신의 이름은 %s, 나이는 %d, 카드는 %s", userList.get(userId).getName(), userList.get(userId).getAge(), userList.get(userId).getCard());
        switch(userList.get(userId).getCard()) {
            case "prepaid":
                System.out.printf(", 잔액은 %d원 입니다.\n\n", userList.get(userId).getPrepaidCard().getBalance());
                break;
            case "climate":
                if(userList.get(userId).getClimateCard().getBegin() != null)
                    System.out.printf(", 카드의 시작 날짜는 %s, 만료 날짜는 %s입니다.\n\n", userList.get(userId).getClimateCard().getBegin(), userList.get(userId).getClimateCard().getEnd());
                else
                    System.out.println(", 유효하지 않은 카드입니다.\n");
                break;
            case "deferred":
                System.out.println(" 입니다.\n");
                break;
        }
//        if (userList.get(userId).getCard().equals("deferred")) {
//            userList.get(userId).getDeferredCard().checkValid();
//        }
        int selected = 0; // 메뉴 선택지

        while(true) {
            System.out.println("======😊메뉴를 선택해주세요😊======");
            System.out.print("1. 지하철 승차 / 2. 충전 / 0. 종료 : ");
            selected = sc.nextInt();
            System.out.println();
            
            switch (selected) {
                case 1:
                    // Gate의 menu로 사용자의 Card 객체를 전달합니다.
                    gate.menu(userList.get(userId));
//                     System.out.println(userList.get(userId));
                    saveRepository(userList);
                    if(gate.isStopover()) // 하차한 경우 프로그램 종료
                        return;
                    break;
                case 2:
                    // Charger menu로 사용자의 Card 객체를 전달합니다.
                    charger.menu(userList.get(userId));
//                     System.out.println(userList.get(userId));
                    saveRepository(userList);
                    break;
                case 0:
                    System.out.println("> 전철역에서 퇴장하셨습니다. 안녕히 가세요...");
                    return;
                default:
                    System.out.println("> 잘못 입력하셨습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void saveRepository(List<Card> userList) {
        File target = new File("C:\\Workspaces\\oop-metro\\metro\\src\\userList.txt");

        // 입출력 형식으로 userList.txt에 user 정보 저장
        try(ObjectOutputStream listToText = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            listToText.writeObject(userList);
//            System.out.println("userList : " + userList);
//             System.out.println("output users : " + userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Card> readRepository() {
        File target = new File("C:\\Workspaces\\oop-metro\\metro\\src\\userList.txt");
        UserRepository userRepository = new UserRepository();
        List<Card> userList = new ArrayList<>();
        try(ObjectInputStream textToList = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)))) {
            Object object = textToList.readObject();

            userList = (List<Card>) object;

            System.out.println("이용자 목록 읽기 성공!");
        } catch (IOException | ClassNotFoundException e) {
            userList = userRepository.savedUser();
        }
        return userList;
    }
}