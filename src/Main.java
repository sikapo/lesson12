import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> product = new ArrayList<>();
        product.add(new Product("Book", 20));
        product.add(new Product("Book", 200, true));
        product.add(new Product("Car", 2000));
        product.add(new Product("Food", 3, false, LocalDateTime.of(2023, 6, 24, 13, 26)));
        product.add(new Product("Book", 67));
        product.add(new Product("Book", 650, false, LocalDateTime.of(2023, 6, 24, 14, 26)));
        product.add(new Product("Estate", 200000));
        product.add(new Product("Book", 251, true));
        product.add(new Product("Toys", 44, true, LocalDateTime.of(2023, 6, 24, 13, 29)));
        product.add(new Product("Book", 45, false, LocalDateTime.of(2022, 6, 23, 14, 26)));
        product.add(new Product("Book", 12, false, LocalDateTime.of(2023, 6, 24, 14, 56)));

        Methods methods = new Methods();
        System.out.println(methods.findType(product));
        System.out.println(methods.isDiscount(product));
        System.out.println(methods.lowestPrice(product));
        System.out.println(methods.lastThree(product));
        System.out.println(methods.dataTypePriceFilter(product));
        System.out.println(methods.grouping(product));

    }
}