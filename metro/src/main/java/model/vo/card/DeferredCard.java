package model.vo.card;

import model.vo.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DeferredCard extends User {
    private LocalDate begin;
    private LocalDate end;
    private int expense;

    public DeferredCard() {}
    public DeferredCard(int userId, String name, int age, String card) {
        super(userId, name, age, card);
        this.begin = null;
        this.end = null;
        this.expense = 0;
    }

    public void chargeDeferred() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작일을 입력하세요. (yyyyMMdd)");
        String begin = sc.next();
//        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
//        String end = sc.next();

        this.begin = LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.end = this.begin.plusMonths(1);

//        this.setCharged(true);

        if (this.end.isBefore(LocalDate.now())) {
            System.out.println("올바른 기간설정이 아닙니다.");
        } else {
            System.out.println("자동결제일은 " + this.end + " 입니다.");
        }
    }

    public void checkValid() {
        if (this.end.isEqual(LocalDate.now().plusDays(1))) {
            this.begin = this.end.plusDays(1);
            this.expense = 0;
        }
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "DeferredCard{" +
                "begin=" + begin +
                ", end=" + end +
                ", expense=" + expense +
                '}';
    }
}
