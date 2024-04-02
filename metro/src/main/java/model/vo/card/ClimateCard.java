package model.vo.card;

import model.vo.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClimateCard extends User {
    private LocalDate begin;
    private LocalDate end;
    private boolean valid = false;

    public ClimateCard() {}
    public ClimateCard(int userId, String name, int age, String card) {
        super(userId, name, age, card);
        this.begin = null;
        this.end = null;
        this.valid = false;
    }

    public void chargeClimate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작일을 입력하세요. (yyyyMMdd)");
        String begin = sc.next();
//        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
//        String end = sc.next();

        this.begin = LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.end = this.begin.plusMonths(1);

//        this.setCharged(true);

        if ((this.begin.isEqual(LocalDate.now()) || this.begin.isBefore(LocalDate.now())) && this.end.isAfter(LocalDate.now())) {
            this.valid = true;
            System.out.println("유효기간 : " + this.begin + "~" + this.end);
            System.out.println("62000원을 결제합니다.");
        } else {
            this.valid = false;
            System.out.println("올바른 기간설정이 아닙니다.");
        }
    }

    public void checkValid() {
        if ((this.begin.isEqual(LocalDate.now()) || this.begin.isBefore(LocalDate.now())) && this.end.isAfter(LocalDate.now())) {
            this.valid = true;
        } else {
            this.valid = false;
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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "ClimateCard{" +
                "begin=" + begin +
                ", end=" + end +
                ", valid=" + valid +
                '}';
    }
}
