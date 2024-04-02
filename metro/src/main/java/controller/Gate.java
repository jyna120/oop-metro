package controller;

import model.vo.card.Card;
import repository.UserRepository;
import run.Station;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Gate {
    private Scanner sc = new Scanner(System.in);
    private int stops; // 총 이동한 정거장 수
    private int transfer; // 환승 횟수

    public void menu() {
        Gate gate = new Gate();

        if(!gate.check()) // 승차 검사
            return;

        int countStop = 0; // 한 번 이동한 정거장 수
        char transferYN = ' '; // 환승 여부
        String move = """
                🚎🚎🚎🚎~~이동하는 중~~🚎🚎🚎🚎
                🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎
                """;

        System.out.println("====🚎지하철에 승차했습니다.🚎====");

        while(true) {
            System.out.print("> 몇 정거장 이동하시겠습니까? : ");
            countStop = sc.nextInt();
            System.out.println();
            System.out.println(move);
            this.stops += countStop;

            System.out.print("> 환승 하시겠습니까? (y/n) : ");
            transferYN = sc.next().toUpperCase().charAt(0);
            System.out.println();

            if(transferYN == 'Y') {
                this.transfer++;
            } else if(transferYN == 'N') {
                System.out.println("====🚎지하철에서 하차했습니다.🚎====\n");
                break;
            }
        }
    }

    public boolean check() {
        UserRepository userRepository = new UserRepository();
        Card card = new Card();

        List<Card> userList = userRepository.saveUser(); // 사용자 리스트
        LocalDate now = LocalDate.now();

        boolean isClimate = "climate".equals(userList.get(Station.userId).getCard()); // 기후동행카드 여부
        boolean isPrepaid = "prepaid".equals(userList.get(Station.userId).getCard()); // 선불카드 여부
        // NPE 발생
//        boolean isChargedClimate = card.getClimateCards()[Station.userId].isCharged(); // 기후동행카드 충전 여부
//        boolean isValidity = now.isAfter(card.getClimateCards()[Station.userId].getEnd()); // 기후동행카드 유효기간 만료 여부
//        int balance = card.getPrepaidCards()[Station.userId].getBalance(); // 선불카드 잔액
//        int price = userList.get(Station.userId).getPrice(); // 사용자 나이에 맞는 기본 요금
//
//        if(isClimate && (!isChargedClimate || isValidity)) {
//            System.out.println("> 기후동행카드를 충전하지 않았거나 유효 기간이 만료되었습니다. 충전하세요...");
//            return false;
//        }
//
//        if(isPrepaid && (balance < price)) {
//            System.out.println("> 선불카드 잔액이 부족합니다. 충전하세요...");
//            return false;
//        }

        return true;
    }
}