package controller;

import controller.manager.FeeInvoice;
import model.vo.card.Card;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Gate {
    private boolean isStopover; // 하차 여부

    public void setStopover(boolean isStopover) {
        this.isStopover = isStopover;
    }

    public boolean isStopover() {
        return this.isStopover;
    }

    public void menu(Card card) {
        Scanner sc = new Scanner(System.in);
        FeeInvoice feeInvoice = new FeeInvoice();

        // 승차 검사
        if (!check(card)) {
            setStopover(false); // 하차하지 않았으므로 false
            return;
        }

        int stops = 0; // 총 이동한 정거장 수
        int transfer = 0; // 총 환승 횟수
        int countStop = 0; // 한 번 이동한 정거장 수
        char transferYN = ' '; // 환승 여부 입력
        String info = """
                ===============🚇🚇🚇지하철 요금 안내🚇🚇🚇===============
                💰지하철 기본 요금은 일반 1,400원, 청소년 800원, 어린이 500원, 노약자는 무료입니다.
                🚎정거장 10개 이하 이동 시 기본 요금이며, 그 이후엔 4개마다 50원씩 추가로 부과됩니다.
                🔄환승은 4번 이하 무료이며, 그 이후엔 4번마다 기본요금이 추가로 부과됩니다.
                🚫선불카드인 경우, 승차 도중 추가 요금을 지불할 잔액 부족 시 강제 하차될 수 있습니다.
                =========================================================
                """;
        String move = """
                🚎🚎🚎🚎~~이동하는 중~~🚎🚎🚎🚎
                🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎🚎
                """;

        System.out.println(info);
        System.out.println("=====🚎지하철에 승차했습니다.🚎=====");
        feeInvoice.rideFare(card); // 사용자의 기본 요금, 잔액/누적 금액 출력
        System.out.println();

        move:
        while(true) {
            System.out.print("> 몇 정거장 이동하시겠습니까? : ");
            countStop = sc.nextInt(); // 한 번 이동한 정거장 수
            System.out.println();
            stops += countStop; // 총 이동한 정거장 수 계산
            System.out.println("> 🚇이동 정거장 누적 수 : " + stops + "🚇");

            boolean bool = feeInvoice.checkBalance(card, stops, transfer);
            if(bool) {
                System.out.println(move);
            }else { // 선불카드일 때 승차 중 추가 요금으로 잔액이 부족한 경우
                System.out.println("=====🚎지하철에서 하차했습니다.🚎=====\n");
                return;
            }

            while(true) {
                System.out.print("> 환승 하시겠습니까? (y/n) : ");
                transferYN = sc.next().toUpperCase().charAt(0); // 환승 여부 입력 (대소문자 구분x)
                System.out.println();

                if(transferYN == 'Y') {
                    transfer++; // 환승 한 번 할 때마다 환승 횟수 증가
                    System.out.println("> 🔄환승 누적 횟수 : " + transfer + "🔄");
                    break;
                }
                else if(transferYN == 'N') {
                    System.out.println("=====🚎지하철에서 하차했습니다.🚎=====");
                    setStopover(true); // 하차했으므로 true
                    break move;
                } else // 문자를 잘못 입력한 경우
                    System.out.println("> 잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }

        System.out.println("> 총 이동 정거장 수 : " + stops + "개, 총 환승 횟수 : " + transfer + "번");
        System.out.println();
        feeInvoice.surcharge(card, stops, transfer);
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
                isChargedClimate = card.getClimateCard().getBegin() != null; // 기후동행카드를 충전한 상태라면 true
                isValidity = isChargedClimate && ChronoUnit.DAYS.between(card.getClimateCard().getEnd(), now)<0; // 기후동행카드 유효기간 만료 날짜가 오늘 이전이라면 true
                if(!isChargedClimate || !isValidity) {
                    System.out.println("> 기후동행카드를 충전하지 않았거나 유효 기간이 만료되었습니다. 충전하세요...\n");
                    return false;
                }
                break;
            case "prepaid":
                balance = card.getPrepaidCard().getBalance(); // 선불카드의 잔액
                price = card.getPrice(); // 사용자 나이에 맞는 기본 요금
                if(balance < price) {
                    System.out.println("> 선불카드 잔액이 부족합니다. 충전하세요...\n");
                    return false;
                }
                break;
        }

        return true;
    }
}