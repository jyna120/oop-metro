package controller.manager;

public class FeeInvoice {
    Gate gate = new Gate();

    //    String cardCase = gate.getCardCase(); // 카드 종류
//    int price = gate.getPrice(); // 유저에서 프라이스 가져오기
//    cards[userId].getPrepaidCards()[userId].getBalance(); // 선불카드 잔액
//    cards[userId].getDeferredCards()[userId].getExpense(); // 후불카드 누적 금액
//    cards[userId].getClimateCards()[userId].isCharged(); // 기후동행 유효 여부
    String cardCase = "ClimateCard";
    int balance;
    int price = 1400;

    //탑승했을 때 출력하는 메소드 작성
    //-> 카드를 먼저 체크하고 나이에 따른 기본 요금 보여줌
    private int rideFare() {
        switch(cardCase) {
            case "ClimateCard":
                System.out.println("기본 요금 : " + price + "잔액 : " );
                break;
            case "DeferredCard": break;
            case "PrepaidCard": break;
            default:
                System.out.println("카드 정보가 유효하지 않습니다.");
                return -1;
        }
        return 0;
    }



    //하차했을 때 출력하는 메소드 작성
    //-> 카드 먼저 체크하고 나이 체크하고 이동 정거장 수랑 환승 체크해서 계산
    private int surcharge() {
        return 0;
    }

    // 카드에 따른 잔액 조회
    private int balanceInquiry(String cardCase) {
        switch(cardCase) {
            case "Prepaid": break;
            case "Deferred": break;
            case "Climate": break;
            default:
                System.out.println();
                break;
        }
        return balance;
    }
}
