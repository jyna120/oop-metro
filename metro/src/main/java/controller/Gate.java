package controller;

import controller.manager.FeeInvoice;
import model.vo.card.Card;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Gate {
    private Scanner sc = new Scanner(System.in);
    private int stops; // 총 이동한 정거장 수
    private int transfer; // 환승 횟수

    public Gate() {}

    public Gate(int stops, int transfer) {
        this.stops = stops;
        this.transfer = transfer;
    }
    public int getStops() {
        return stops;
    }
    public void setStops(int stops) {
        this.stops = stops;
    }
    public int getTransfer() {
        return transfer;
    }
    public void setTransfer(int transfer) {
        this.transfer = transfer;
    }

    public void menu(Card card) {
//        Gate gate = new Gate();
        FeeInvoice feeInvoice = new FeeInvoice();

        // 승차 검사
        if(!check(card))
            return;

        int stops = 0; // 총 이동한 정거장 수
        int transfer = 0; // 총 환승 횟수
        int countStop = 0; // 한 번 이동한 정거장 수
        char transferYN = ' '; // 환승 여부 입력
        String move = """
                🚎🚎🚎🚎~~이동하는 중~~🚎🚎🚎🚎
                🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎
                """;

        System.out.println("====🚎지하철에 승차했습니다.🚎====");
        feeInvoice.rideFare(card); // 사용자의 기본 요금, 잔액/누적 금액 출력
        System.out.println();

        feeInvoice.rideFare(card);

        while(true) {
            System.out.print("> 몇 정거장 이동하시겠습니까? : ");
            countStop = sc.nextInt(); // 한 번 이동한 정거장 수
            System.out.println();
            System.out.println(move);
            stops += countStop; // 총 이동한 정거장 수 계산

            System.out.print("> 환승 하시겠습니까? (y/n) : ");
            transferYN = sc.next().toUpperCase().charAt(0); // 환승 여부 입력 (대소문자 구분x)
            System.out.println();

            if(transferYN == 'Y') {
                transfer++; // 환승 한 번 할 때마다 환승 횟수 증가
            } else if(transferYN == 'N') {
                System.out.println("====🚎지하철에서 하차했습니다.🚎====");
                break;
            }
//            else {
                 // 문자를 잘못 입력한 경우
//            }

        }

        System.out.println("> 총 이동 정거장 수 : " + stops + "개, 환승 횟수 : " + transfer + "번");
        feeInvoice.surcharge(card, stops, transfer);
        System.out.println();
    }

    // 승차 검사
    // 선불카드일 경우, 잔액이 사용자의 기본요금보다 부족할 시 승차에 실패한다.
    // 기후동행카드일 경우, 충전하지 않았거나 유효기간 날짜가 만료되면 승차에 실패한다.
    public boolean check(Card card) {
        LocalDate now = LocalDate.now();

        boolean isChargedClimate = false; // 기후동행카드 충전 여부
        boolean isValidity = false; // 기후동행카드 유효기간 만료 여부
        int balance = 0; // 선불카드의 잔액
        int price = 0; // 사용자 나이에 맞는 기본 요금

        switch (card.getCard()) {
            case "climate":
                isChargedClimate = card.getClimateCard().isValid(); // 기후동행카드를 충전한 상태라면 true
                isValidity = ChronoUnit.DAYS.between(card.getClimateCard().getEnd(), now) > 0; // 기후동행카드 유효기간 만료 날짜가 오늘 이전이라면 true
                if(!isChargedClimate || isValidity) {
                    System.out.println("> 기후동행카드를 충전하지 않았거나 유효 기간이 만료되었습니다. 충전하세요...");
                    return false;
                }
                break;
            case "prepaid":
                balance = card.getPrepaidCard().getBalance(); // 선불카드의 잔액
                price = card.getPrice(); // 사용자 나이에 맞는 기본 요금
                if(balance < price) {
                    System.out.println("> 선불카드 잔액이 부족합니다. 충전하세요...");
                    return false;
                }
                break;
        }

        return true;
    }
}