package controller;

import model.vo.card.Card;

public class Charger {
    public void menu(Card card) { // userList.get(userId) List<Card> 타입의 요소 하나, userId 인덱스 가져오기
        System.out.printf("%s님의 카드는 %s 입니다.", card.getName(), card.getCard());
        if (card.getCard().equals("climate")){
            card.getClimateCard().chargeClimate();
            // Card 에 저장한 ClimateCard 객체의 충전 메소드를 실행시킴
            System.out.println(card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getClimateCard());
        } else if (card.getCard().equals("deferred")) {
            card.getDeferredCard().chargeDeferred();
            System.out.println(card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getDeferredCard());
        } else if (card.getCard().equals("prepaid")) {
            card.getPrepaidCard().chargePrepaid();
            System.out.println(card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getPrepaidCard());
        }
    }
}
