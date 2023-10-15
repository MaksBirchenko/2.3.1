package web.controller;

public class Car {
    private String mark;
    private String color;
    private int number;

    public Car() {
    }

    public Car(String mark, String color, int number) {
        this.mark = mark;
        this.color = color;
        this.number = number;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
