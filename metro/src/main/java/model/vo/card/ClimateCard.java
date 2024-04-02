package model.vo.card;

import model.vo.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClimateCard {
    private LocalDate begin;
    private LocalDate end;
    private boolean valid = false;

    public ClimateCard() {
        this.begin = null;
        this.end = null;
        this.valid = false;
    }

    public ClimateCard(LocalDate begin, LocalDate end) {
        this.begin = begin;
        this.end = this.begin.plusMonths(1);
        checkValid();
    }

    public void chargeClimate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작일을 입력하세요. (yyyyMMdd)");
        String begin = sc.next();
//        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
//        String end = sc.next();

        LocalDate userBegin = LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate userEnd = userBegin.plusMonths(1);

//        this.setCharged(true);

        if ((userBegin.isEqual(LocalDate.now()) || userBegin.isBefore(LocalDate.now())) && userEnd.isAfter(LocalDate.now())) {
            this.begin = userBegin;
            this.end = userEnd;
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
