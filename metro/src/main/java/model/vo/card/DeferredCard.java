package model.vo.card;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DeferredCard extends Card{
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
        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
        String begin = sc.next();
        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
        String end = sc.next();

        this.setBegin(LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd")));
        this.setEnd(LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyyMMdd")));

        if (getBegin().isBefore(LocalDate.now()) && getEnd().isAfter(LocalDate.now())) {
            System.out.println("유효한 카드입니다.");
        } else {
            this.expense = 0;
            System.out.println("이 카드는 만료되었습니다.");
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
