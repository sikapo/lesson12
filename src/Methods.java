import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Methods {
    public List<Product> findType(List<Product> list){
        return list.stream()
                .filter(ls -> ls.getType()
                .equals("Book"))
                .filter(ls -> ls
                .getPrice() > 250).toList();
    }
    public List<AbstractMap.SimpleEntry<String, Double>> isDiscount(List<Product> list){
        return list.stream()
                .filter(ls -> ls.getType().equals("Book"))
                .filter(Product::getDiscount)
                .map(ls -> new AbstractMap.SimpleEntry<>(ls.getType(), ls.getPrice()*0.9) {})
                .toList();
    }
    public Optional<AbstractMap.SimpleEntry<String, Double>> lowestPrice(List<Product> list){
        Optional<AbstractMap.SimpleEntry<String, Double>> lowestPrice = list.stream()
                .filter(ls -> ls.getType().equals("Book"))
                .filter(Product::getDiscount)
                .map(ls -> new AbstractMap.SimpleEntry<>(ls.getType(), ls.getPrice()*0.9) {})
                .min(Comparator.comparingDouble(AbstractMap.SimpleEntry::getValue));
        if (lowestPrice.isPresent()) {
            return lowestPrice;
        }
        else throw new RuntimeException("Продукт [категорія: Book] не знайдено");
    }

    public List<Product> lastThree(List<Product> list){
        return  list.stream()
                .filter(ls -> ls.getTime() != null)
                .sorted(Comparator.comparing(Product::getTime))
                .limit(3)
                .collect(Collectors.toList());
    }
    public List<Product> dataTypePriceFilter(List<Product> list){
        LocalDate date = LocalDate.now();
        return  list.stream()
                .filter(ls -> ls.getTime() != null)
                .filter(ls -> ls.getTime().getYear() == date.getYear())
                .filter(ls -> ls.getType().equals("Book"))
                .filter(ls -> ls.getPrice() < 75)
                .collect(Collectors.toList());
    }
    public Map<String, List<Product>> grouping(List<Product> list){
        return list.stream().collect(Collectors.groupingBy(Product::getType));

    }
}
