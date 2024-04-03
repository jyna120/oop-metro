package model.vo.card;

import model.vo.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrepaidCard {
    private int balance = 0;

    public PrepaidCard() {}

    public PrepaidCard(int balance) {
        this.balance = balance;
    }

    // 선불카드 충전메소드입니다.
    // 입금액에 대한 예외처리가 필요할 것 같긴 함
    public void chargePrepaid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금액을 입력하세요.");
        int userBalance = this.balance;
        try {
            userBalance = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("올바른 입금액을 입력해주세요. : ");
        }
        this.balance += userBalance;
        System.out.println("충전되었습니다!");
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    @Override
    public String toString() {
        return "PrepaidCard{" +
                "balance=" + balance +
                '}';
    }
}
