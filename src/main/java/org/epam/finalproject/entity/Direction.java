package org.epam.finalproject.entity;

public class Direction {
    private int id;
    private String direction;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                ", price=" + price +
                '}';
    }
}
