package model.vo.card;

import model.vo.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
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
        // 생성시에 입력값이 유효한지 확인합니다.
        if (begin.plusMonths(1).isBefore(LocalDate.now())) {
            return;
        } else {
            this.begin = begin;
            this.end = begin.plusMonths(1);
            this.expense = expense;
        }
    }

    // 후불카드 충전메소드입니다.
    public void chargeDeferred() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작일을 입력하세요. (yyyyMMdd)");

        String begin;
        Long beginL = 20000101L;
        // 숫자 이외의 문자, 기호 등을 입력받았을 경우 예외처리
        try {
            beginL = sc.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 날짜 입력값입니다. : " + beginL);
        }
//        System.out.println("만료일을 입력하세요. (yyyyMMdd)");
//        String end = sc.next();
        begin = beginL.toString();
        // Long값으로 받았지만 LocalDate로 쓰기 위해 String으로 바꿔줍니다.

        LocalDate userBegin = LocalDate.parse(begin, DateTimeFormatter.ofPattern("yyyyMMdd"));

//        this.setCharged(true);

        if (userBegin.plusMonths(1).isBefore(LocalDate.now())) {
            // 만료일이 현재 날짜보다 이전일 때
            System.out.println("올바른 기간설정이 아닙니다.");
        } else {
            // 유효한 기간을 입력했을 때
            this.begin = userBegin;
            this.end = userBegin.plusMonths(1);
            System.out.println("자동결제일은 " + this.end + " 입니다.");
        }
    }

    // 한달이 지나면 자동으로 만기가 되어 지출액이 0원으로 바뀝니다.
    // 이 메소드는 매번 실행할 때 함께 실행해주어야 합니다.
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
