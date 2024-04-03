package model.vo.card;

import model.vo.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClimateCard implements Serializable {
    private LocalDate begin;
    private LocalDate end;
    private boolean valid = false;

    public ClimateCard() {
        this.begin = null;
        this.end = null;
        this.valid = false;
    }

    public ClimateCard(LocalDate begin) {
        this.begin = begin;
        this.end = this.begin.plusMonths(1);
        checkValid();
    }

    // 기후동행카드 충전 메소드입니다.
    public void chargeClimate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작일을 입력하세요. (yyyyMMdd)");

        String begin;
        Long beginL = 20000101L;
        try {
            beginL = sc.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 날짜 입력값입니다. : ");
        }
        begin = beginL.toString();

//        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
//        String end = sc.next();

        LocalDate userBegin = LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate userEnd = userBegin.plusMonths(1);
        // 사용자에게 입력받은 시작날짜를 토대로 한달이 지난 시점을 만료일로 자동 설정합니다.

//        this.setCharged(true);

        if ((userBegin.isEqual(LocalDate.now()) || userBegin.isBefore(LocalDate.now())) && userEnd.isAfter(LocalDate.now())) {
            // 만약 시작일이 오늘날짜와 같거나 이전이고, 만료일이 오늘날짜보다 이후라면 유효함!
            this.begin = userBegin;
            this.end = userEnd;
            this.valid = true;
            // 유효한 카드로 바꿔줌
            System.out.println("유효기간 : " + this.begin + "~" + this.end);
            System.out.println("62000원을 결제합니다.");
        } else {
            this.valid = false; // 아니면 만료된 카드로 바꿔줍니다.
            System.out.println("올바른 기간설정이 아닙니다.");
        }
    }

    public void checkValid() {
        // 유효한지 확인하는 메소드, 이는 레포지토리에서 Card객체를 저장할 때 사용하기 위한 것입니다.
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