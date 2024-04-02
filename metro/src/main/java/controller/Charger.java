package controller;

import model.vo.card.Card;

public class Charger {
    public void menu(Card card, int userId) { // userList.get(userId) List<Card> 타입의 요소 하나, userId 인덱스 가져오기
        System.out.printf("%s님의 카드는 %s 입니다.", card.getName(), card.getCard());
        if (card.getCard().equals("climate")){
            card.getClimateCards()[userId].chargeClimate();
            // Card로 저장한 (ClimateCard 리스트에 userId를 인덱스로 갖는) ClimateCard 객체의 충전 메소드를 실행시킴
            System.out.println(card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getClimateCards()[userId]);
            // userId 번째 ClimateCard 객체의 toString() 메소드가 실행 및 출력됨
        } else if (card.getCard().equals("deferred")) {
            card.getDeferredCards()[userId].chargeDeferred();
            // Card로 저장한 (DeferredCard 리스트에 userId를 인덱스로 갖는) DeferredCard 객체의 충전 메소드를 실행시킴
            System.out.println(card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getDeferredCards()[userId]);
            // userId 번째 DeferredCard 객체의 toString() 메소드가 실행 및 출력됨
        } else if (card.getCard().equals("prepaid")) {
            card.getPrepaidCards()[userId].chargePrepaid();
            // Card로 저장한 (PrepaidCard 리스트에 userId를 인덱스로 갖는) PrepaidCard 객체의 충전 메소드를 실행시킴
            System.out.println(card.getName() +"님의 카드현황 입니다.");
            System.out.println(card.getPrepaidCards()[userId]);
            // userId 번째 저장된 PrepaidCard 객체의 toString() 메소드가 실행 및 출력됨
        }
    }
}
