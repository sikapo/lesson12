import java.time.LocalDateTime;

public class Product {
    private final String type;

    private double price;
    private boolean discount = false;
    private LocalDateTime time;
    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public Product(String type, double price, boolean discount, LocalDateTime time) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.time = time;
    }



    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    public boolean getDiscount() {
        return discount;
    }
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", prise=" + price;
    }
}
