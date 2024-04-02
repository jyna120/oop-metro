package controller.manager;

import controller.Gate;

public class FeeInvoice {
    Gate gate = new Gate();

    //    String cardCase = gate.getCardCase(); // 카드 종류
//    int price = gate.getPrice(); // 유저에서 프라이스 가져오기
//    cards[userId].getPrepaidCards()[userId].getBalance(); // 선불카드 잔액
//    cards[userId].getDeferredCards()[userId].getExpense(); // 후불카드 누적 금액
//    cards[userId].getClimateCards()[userId].isCharged(); // 기후동행 유효 여부
    int price = 1400;
    String cardCase = "ClimateCard";
    int balance = 30000;

    //탑승했을 때 출력하는 메소드 작성
    //-> 카드를 먼저 체크하고 나이에 따른 기본 요금 보여줌
    private void rideFare(int price, String cardCase, int balance) { // 나이대 별 요금, 카드 종류, 잔액(or 누적 금액)
        switch(cardCase) {
            case "DeferredCard":
                System.out.println("기본 요금 : " + price + "누적 금액 : " + balance);
                break;
            case "PrepaidCard":
                System.out.println("기본 요금 : " + price + "잔액 : " + balance);
                break;
            default:
                System.out.println("승차에 실패했습니다. 다시 시도해주세요.");
                return;
        }
    }



    //하차했을 때 출력하는 메소드 작성
    //-> 카드 먼저 체크하고 나이 체크하고 이동 정거장 수랑 환승 체크해서 계산
    private void surcharge() {

    }

}
