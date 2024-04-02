package model.vo.card;

import java.util.Scanner;

public class PrepaidCard extends Card{
    int balance = 0;

    public PrepaidCard(int userId, String name, int age, String card) {
        super(userId, name, age, card);
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
