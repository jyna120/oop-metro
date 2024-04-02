package model.vo.card;

import model.vo.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DeferredCard {
    private LocalDate begin;
    private LocalDate end;
    private int expense;

    public DeferredCard() {
        this.begin = null;
        this.end = null;
        this.expense = 0;
    }

    public DeferredCard(LocalDate begin, int expense) {
        if (begin.plusMonths(1).isBefore(LocalDate.now())) {
            return;
        } else {
            this.begin = begin;
            this.end = begin.plusMonths(1);
            this.expense = expense;
        }
    }

    public void chargeDeferred() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작일을 입력하세요. (yyyyMMdd)");
        String begin = sc.next();
//        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
//        String end = sc.next();

        LocalDate userBegin = LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd"));

//        this.setCharged(true);

        if (userBegin.plusMonths(1).isBefore(LocalDate.now())) {
            // 만료일이 현재 날짜보다 이전일 때
            System.out.println("올바른 기간설정이 아닙니다.");
        } else {
            this.begin = userBegin;
            this.end = userBegin.plusMonths(1);
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
