package controller.manager;
import model.vo.card.Card;

public class FeeInvoice {
    int balance = 0; // 잔액(or 누적 금액) 임시 저장

    //탑승했을 때 출력하는 메소드 작성
    //-> 카드를 먼저 체크하고 나이에 따른 기본 요금 보여줌
    public void rideFare(Card card) { // 나이대 별 요금, 카드 종류, 잔액(or 누적 금액)
        switch(card.getCard()) {
            case "DeferredCard": // 신용카드로 탑승 시
                balance = card.getDeferredCard().getExpense();
                System.out.println("기본 요금 : " + card.getPrice() + "누적 금액 : " + balance);
                break;
            case "PrepaidCard": // 체크카드로 탑승 시
                balance = card.getPrepaidCard().getBalance();
                System.out.println("기본 요금 : " + card.getPrice() + "잔액 : " + balance);
                break;
            default: // 신용/체크 카드가 아닐 때(기후 동행은 호출하지 않아도 된다.)
                System.out.println("승차에 실패했습니다. 다시 시도해주세요.");
                return;
        }
    }

    //하차했을 때 출력하는 메소드 작성
    //-> 카드 먼저 체크하고 나이에 해당하는 price, 이동 정거장 수, 환승 체크해서 계산
//    public int surcharge(String cardCase, int price, int stops, int transfer) { // 카드 종류, 나이대 별 요금, 이동 정거장 수, 환승
//        int overTransfer = transfer / 4;
//        int plusPrice = price * overTransfer + (stops - 10) * 50;
//
//        switch(cardCase) {
//            case "DeferredCard": // 신용카드로 하차 시
//                int addPrice = balance + plusPrice; // 누적 금액
//                System.out.println("추가 요금 : " + plusPrice + ", 누적 금액: " + addPrice);
//                return addPrice;
//            case "PrepaidCard": // 체크카드로 하차 시
//                int subPrice = balance - plusPrice; // 잔액
//                System.out.println("추가 요금 : " + plusPrice + ", 잔액: " + subPrice);
//                return subPrice;
//            default: // 신용/체크 카드가 아닐 때(기후 동행은 호출하지 않아도 된다.)
//                System.out.println("하차에 실패했습니다. 다시 시도해주세요.");
//                return 0;
//        }
//    }

    public void surcharge(Card card, int stops, int transfer) { // Card(카드 종류, 나이대 별 요금), 이동 정거장 수, 환승
        int overTransfer = transfer / 4;
        int plusPrice = card.getPrice() * overTransfer + (stops - 10) * 50;

        switch(card.getCard()) {
            case "DeferredCard": // 신용카드로 하차 시
                int addPrice = balance + plusPrice; // 누적 금액
                System.out.println("추가 요금 : " + plusPrice + ", 누적 금액: " + addPrice);
                card.getDeferredCard().setExpense(addPrice);
                break;
            case "PrepaidCard": // 체크카드로 하차 시
                int subPrice = balance - plusPrice; // 잔액
                System.out.println("추가 요금 : " + plusPrice + ", 잔액: " + subPrice);
                card.getPrepaidCard().setBalance(subPrice);
                break;
            default: // 신용/체크 카드가 아닐 때(기후 동행은 호출하지 않아도 된다.)
                System.out.println("하차에 실패했습니다. 다시 시도해주세요.");
                break;
        }
    }
}