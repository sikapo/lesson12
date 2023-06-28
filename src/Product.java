import java.time.LocalDateTime;

public class Product {
    private final String type;

    private double prise;
    private boolean discount = false;
    private LocalDateTime time;
    public Product(String type, double prise) {
        this.type = type;
        this.prise = prise;
    }

    public Product(String type, double prise, boolean discount) {
        this.type = type;
        this.prise = prise;
        this.discount = discount;
    }

    public Product(String type, double prise, boolean discount, LocalDateTime time) {
        this.type = type;
        this.prise = prise;
        this.discount = discount;
        this.time = time;
    }



    public String getType() {
        return type;
    }

    public double getPrise() {
        return prise;
    }
    public boolean getDiscount() {
        return discount;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public double setPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", prise=" + prise;
    }
}
