package model.vo;

public class User {
    private int userId;
    private String name;
    private int age;
    private String card;
    private int price;

    public User() {
    }

    public User(int userId, String name, int age, String card) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.card = card;

        if (age < 65)
            this.price = 1400;
        else if (age < 19)
            this.price = 800;
        else if (age < 12)
            this.price = 500;
        else
            this.price = 0;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", card='" + card + '\'' +
                ", price=" + price +
                '}';
    }
}
