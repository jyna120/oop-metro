package model.vo.card;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClimateCard extends Card{
    private LocalDate begin;
    private LocalDate end;
    private boolean charged = false;

    public ClimateCard() {}
    public ClimateCard(int userId, String name, int age, String card) {
        super(userId, name, age, card);
        this.begin = null;
        this.end = null;
        this.charged = false;
    }

    public void chargeClimate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작일을 입력하세요. (yyyyMMdd)");
        String begin = sc.next();
        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
        String end = sc.next();
        System.out.println("62000원을 결제합니다.");

        this.setBegin(LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd")));
        this.setEnd(LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyyMMdd")));
        this.setCharged(true);

        if (getEnd().isAfter(LocalDate.now())) {
            this.charged = true;
            System.out.println("유효한 카드입니다.");
        } else {
            this.charged = false;
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

    public boolean isCharged() {
        return charged;
    }

    public void setCharged(boolean charged) {
        this.charged = charged;
    }

    @Override
    public String toString() {
        return "ClimateCard{" +
                "begin=" + begin +
                ", end=" + end +
                ", charged=" + charged +
                '}';
    }
}
