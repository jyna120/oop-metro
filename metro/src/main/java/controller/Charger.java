package controller;

import model.vo.card.Card;

import java.util.List;

public class Charger {
    public void menu(Card card) { // Station에서 menu로 전달한 사용자의 Card를 전달받습니다.
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