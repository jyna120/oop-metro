package controller;

import model.vo.card.Card;

import java.util.List;

public class Charger {
    public void menu(Card card) { // Station에서 menu로 전달한 사용자의 Card를 전달받습니다.
        String info = """
                =============🚇🚇🚇교통카드 충전 안내🚇🚇🚇=============
                💳교통카드의 종류로 선불카드, 후불카드, 기후동행카드가 있습니다.
                1️⃣선불카드는 잔액 부족 시 승차할 수 없으며, 승차 전에 먼저 금액을 충전합니다.
                2️⃣후불카드는 이용 금액을 누적하여 한 달 후에 지불합니다.
                3️⃣기후동행카드는 한 달 동안 횟수 제한없이 승차할 수 있습니다. 요금은 62,000원입니다.
                ============================================================
                """;
        System.out.println(info);

        System.out.printf("> %s님의 카드는 %s 입니다.\n", card.getName(), card.getCard());
        if (card.getCard().equals("climate")){ // 사용자의 카드가 기후동행카드라면,
            card.getClimateCard().chargeClimate();
//            userList.set(card.getUserId(), card);
            // Card 에 저장한 필드 ClimateCard 객체의 충전 메소드를 실행합니다.
            System.out.println("> " + card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getClimateCard() + "\n");
            // Card 에 저장한 필드 ClimateCard 객체의 toString()을 출력합니다.
        } else if (card.getCard().equals("deferred")) { // 사용자의 카드가 후불카드라면,
            card.getDeferredCard().chargeDeferred();
//            userList.set(card.getUserId(), card);
            // Card 에 저장한 필드 DeferrendCard 객체의 충전 메소드를 실행합니다.
            System.out.println("> " + card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getDeferredCard() + "\n");
            // Card 에 저장한 필드 DeferrendCard 객체의 toString()을 출력합니다.
        } else if (card.getCard().equals("prepaid")) {
            card.getPrepaidCard().chargePrepaid();
//            userList.set(card.getUserId(), card);
            // Card 에 저장한 필드 PrepaidCard 객체의 충전 메소드를 실행합니다.
            System.out.println("> " + card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getPrepaidCard() + "\n");
            // Card 에 저장한 필드 PrepaidCard 객체의 toString()을 출력합니다.
        }
    }
}