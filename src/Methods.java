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
    public List<List<Product>> isDiscount(List<Product> list){
        return list.stream()
                .filter(ls -> ls.getType().equals("Book"))
                .filter(Product::getDiscount)
                //.map(ls -> new AbstractMap.SimpleEntry<>(ls.getType(), ls.getPrice()*0.9) {})
                .map(ls -> {ls.setPrice(ls.getPrice()*0.9); return list;})
                .collect(Collectors.toList());
    }

    public Optional<Product> lowestPrice(List<Product> list){
        Optional<Product> lowestPrice = list.stream()
                .filter(ls -> ls.getType().equals("Book"))
                .filter(Product::getDiscount)
                //.map(ls -> new AbstractMap.SimpleEntry<>(ls.getType(), ls.getPrice()*0.9) {})
                .map(ls -> {ls.setPrice(ls.getPrice()*0.9); return ls;})
                //.min(Comparator.comparingDouble(AbstractMap.SimpleEntry::getValue));
                .min(Comparator.comparingDouble(Product::getPrice));
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
