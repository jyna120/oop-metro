package model.vo.card;

import model.vo.User;

import java.io.Serializable;
import java.util.Scanner;

public class PrepaidCard implements Serializable {
    private int balance = 0;

    public PrepaidCard() {}

    public PrepaidCard(int balance) {
        this.balance = balance;
    }

    public void chargePrepaid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금액을 입력하세요.");
        this.balance = sc.nextInt();
        System.out.println("충전되었습니다!");
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "PrepaidCard{" +
                "balance=" + balance +
                '}';
    }
}
